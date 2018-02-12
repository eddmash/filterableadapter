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
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

public class AlertboxDialog extends GenericDialog {
    private TextView messageView;
    private String message;

    public AlertboxDialog() {

    }

    @Override
    public void onViewReady(View view, @Nullable Bundle savedInstanceState) {

        messageView = (TextView) layout.findViewById(R.id.message);
        if (message!=null){
            messageView.setText(message);
        }

    }

    @Override
    protected int getContentLayout() {
        return R.layout.dialog_alert;
    }

    public void setMessage(String s) {
        message = s;
    }
}
