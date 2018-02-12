package com.eddmash.androidcomponents;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eddmash.androidcomponents.helpers.DatabaseSchema;
import com.eddmash.androidcomponents.helpers.SqlHelper;
import com.eddmash.db.ActiveRecord;
import com.eddmash.dialogs.GenericDialog;
import com.eddmash.grids.DataGridView;
import com.eddmash.grids.columns.ActionColumn;
import com.eddmash.validation.Validator;
import com.eddmash.validation.checks.NotEmptyCheck;

import java.util.List;
import java.util.Map;

public class DialogsActivity extends AppCompatActivity {

    private DataGridView dataGridView;
    private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogs);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addBtn = findViewById(R.id.add_coffee);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FormDialog formdialog = new FormDialog();
                formdialog.setTitle(getString(R.string.edit_dialog_title));
                formdialog.show(getSupportFragmentManager(), "formdialog");
            }
        });

        dataGridView = (DataGridView) findViewById(R.id.content_dsp);
        dataGridView.setPageSize(10);
        dataGridView.addColumn(new EditActionColumn(this, "Edit"), DataGridView.RIGHT);
        dataGridView.setQuery(SqlHelper.getInstance(this).getReadableDatabase(),
                "select * from coffees", new String[]{});


    }

    public static class FormDialog extends GenericDialog {

        private static final String VALIDATIONTAG = "edit_dialog_box";
        private EditText price;
        private EditText name;
        private Validator validator;

        @Override
        protected int getContentLayout() {
            return R.layout.content_edit_coffee;
        }

        @Override
        protected void onViewReady(View view, @Nullable Bundle savedInstanceState) {
            validator = new Validator(VALIDATIONTAG);
            name = (EditText) view.findViewById(R.id.name);
            price = (EditText) view.findViewById(R.id.price);

            validator.addCheck(new NotEmptyCheck(name, getString(R.string.not_blank, "Name")));
            validator.addCheck(new NotEmptyCheck(price, getString(R.string.not_blank, "Price")));


            // when left button is clicked
            setLeftButton(getString(R.string.update_btn), new ButtonClickedListener() {
                @Override
                public void onClick(View view, DialogFragment dialog) {
                    if (validator.validate()) {
                        dialog.dismiss();
                        updateRecord();
                    }
                }
            });
        }

        private void updateRecord() {
            ContentValues val = new ContentValues();
            val.put("coffee_name", name.getText() + "");
            val.put("price", price.getText() + "");
            SqlHelper.getInstance(getActivity())
                    .getWritableDatabase()
                    .insertOrThrow(
                            DatabaseSchema.Coffees.TABLE_NAME,
                            null,
                            val
                    );

            ((DialogsActivity) getActivity()).refreshDataView();

        }

    }


    private void refreshDataView() {
        Intent intent = new Intent(this, getClass());

        startActivity(intent);
    }


    public class EditActionColumn extends ActionColumn {
        public EditActionColumn(Context context, String name) {
            super(context, name);
        }

        @Override
        protected void onItemClick(View v, Map datum) {
            Intent intent = new Intent(getContext(), MainActivity.class);
            intent.putExtra("record_id", String.valueOf(datum.get("id")));
            startActivity(intent);
        }
    }

}
