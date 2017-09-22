package com.eddmash.dialogs;
/*
* This file is part of the Fivmszm package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

/**
 * A generic class that makes it to customize dialog boxes.
 * example usage
 * <p>
 * AlertboxDialog alertboxDialog = new AlertboxDialog();
 * alertboxDialog.disableButtons(true);
 * alertboxDialog.setTitle("NETWORK ERROR");
 * alertboxDialog.setIcon(R.drawable.fail);
 * alertboxDialog.setMessage(activity.getString(R.string.network_error));
 * alertboxDialog.show(activity.getSupportFragmentManager(), "network_error");
 * </p>
 */
public abstract class GenericDialog extends DialogFragment {
    protected Button leftButton;
    protected Button rightButton;
    protected View layout;
    private ButtonClickedListener buttonListener;
    private TextView customTitleView;
    private ImageView customIconView;
    private boolean disableButtons = false;
    private int _layoutID = 0;
    private String title;
    private int icon;
    private Map<String, Map> buttonSettings = new HashMap<>();
    private final String RIGHTBUTTON = "RIGHTBTN";
    private final String LEFTBUTTON = "LEFTBTN";
    private Map titleSettings = new HashMap<>();

    public GenericDialog() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        layout = inflater.inflate(R.layout.dialog_generic_body, container);
        // add content layout
        if (this.getContentLayout() != 0) {
            View childView = getActivity().getLayoutInflater().inflate(getContentLayout(), null);
            LinearLayout lay = (LinearLayout) layout.findViewById(R.id.dialog_content);
            lay.addView(childView);
        }

        return layout;
    }

    protected int getContentLayout() {
        return _layoutID;
    }

    public void setContentLayout(@LayoutRes int layoutID) {
        _layoutID = layoutID;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);

        customTitleView = (TextView) this.layout.findViewById(R.id.dialog_title);
        if (title != null) {
            customTitleView.setText(title);
        }
        customIconView = (ImageView) this.layout.findViewById(R.id.dialog_icon);
        if (icon != 0) {
            customIconView.setVisibility(View.VISIBLE);
            customIconView.setImageDrawable(ContextCompat.getDrawable(getActivity(), icon));
        }else {
            customIconView.setVisibility(View.GONE);
        }
        leftButton = (Button) view.findViewById(R.id.btn_get_data_update);
        rightButton = (Button) view.findViewById(R.id.btn_update_later);
        leftButton.setVisibility(View.GONE);
        rightButton.setVisibility(View.GONE);

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        onViewReady(layout, savedInstanceState);
        addToView(this.layout);

        doTitleConfigurations();
        doButtonConfigutions();

    }

    private void doTitleConfigurations() {
        if (titleSettings.size() > 0) {
            if (titleSettings.containsKey("bgColor")) {
                int colorId = (int) titleSettings.get("bgColor");
                if (colorId > 0) {
                    customTitleView.setBackgroundColor(getActivity().getResources().getColor(colorId));
                }
            }
            if (titleSettings.containsKey("textColor")) {
                int textColorId = (int) titleSettings.get("textColor");
                if (textColorId > 0) {
                    customTitleView.setTextColor(getActivity().getResources().getColor(textColorId));
                }
            }
        }
    }

    private void doButtonConfigutions() {
        if (buttonSettings.size() > 0) {
            if (buttonSettings.containsKey(RIGHTBUTTON)) {
                Map rSettings = buttonSettings.get(RIGHTBUTTON);
                final ButtonClickedListener lister = (ButtonClickedListener) rSettings.get("listener");
                rightButton.setVisibility(View.VISIBLE);
                rightButton.setText(rSettings.get("label").toString());
                rightButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bindButton(lister);
                    }
                });
            }
            if (buttonSettings.containsKey(LEFTBUTTON)) {
                Map lSettings = buttonSettings.get(LEFTBUTTON);
                final ButtonClickedListener lister = (ButtonClickedListener) lSettings.get("listener");
                leftButton.setVisibility(View.VISIBLE);
                leftButton.setText(lSettings.get("label").toString());
                leftButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bindButton(lister);
                    }
                });
            }
        }
    }

    /**
     * Add your logic to this method since at this point most of the work is done for you and the
     * base layout has been polutated with your content layout
     */
    protected abstract void onViewReady(View view, @Nullable Bundle savedInstanceState);

    public void addToView(View layout) {
    }

    public void setIcon(@DrawableRes int drawable) {
        icon = drawable;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * set listener to be invoked when the right button is cliked.
     *
     * @param label
     * @param clickListener
     */
    public void setRightButton(String label, ButtonClickedListener clickListener) {
        Map settings = new HashMap();
        settings.put("label", label);
        settings.put("listener", clickListener);
        buttonSettings.put(RIGHTBUTTON, settings);
    }

    /**
     * SEt the listner to be invoked when the left button is clicked
     *
     * @param label
     * @param clickListener
     */
    public void setLeftButton(String label, final ButtonClickedListener clickListener) {
        Map settings = new HashMap();
        settings.put("label", label);
        settings.put("listener", clickListener);
        buttonSettings.put(LEFTBUTTON, settings);
    }

    private void bindButton(ButtonClickedListener buttonListener) {
        buttonListener.onClick(layout, this);
    }

    public void disableButtons(boolean b) {
        this.disableButtons = b;
    }

    public void setTitleBackground(@ColorRes int titleBgColor) {
        titleSettings.put("bgColor", titleBgColor);
    }

    public void setTitleTextColor(@ColorRes int titleBgColor) {
        titleSettings.put("textColor", titleBgColor);
    }

    public interface ButtonClickedListener {
        abstract void onClick(View view, DialogFragment dialog);
    }


    public static class Dismiss implements ButtonClickedListener{
        @Override
        public void onClick(View view, DialogFragment dialog) {
            dialog.dismiss();
        }
    }
}
