package com.eddmash.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by edd on 2/17/18.
 */

public class ImagePickerDialog extends GenericDialog {
    @Override
    protected void onViewReady(View view, @Nullable Bundle savedInstanceState) {
        setTitle(getString(R.string.prompt));

    }

    @Override
    protected int getContentLayout() {
        return R.layout.dialog_imagepicker;
    }


}
