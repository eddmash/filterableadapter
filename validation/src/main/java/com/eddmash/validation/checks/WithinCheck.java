package com.eddmash.validation.checks;

import android.widget.EditText;
import android.widget.Spinner;

/*
* This file is part of the androidcomponents package.
* 
* (c) Eddilbert Macharia (http://eddmash.com)<edd.cowan@gmail.com>
*
* For the full copyright and license information, please view the LICENSE
* file that was distributed with this source code.
*/

/**
 * Checks if a view values is within the provided min and max values, the check is inclusive.
 * <p>
 * i.e if min is 10 and the value is 10 this will pass the validation
 */
public class WithinCheck extends NotEmptyCheck {

    private double min;
    private double max;

    public WithinCheck(EditText view, String errorMessage, int min, int max) {
        super(view, errorMessage);
        this.min = (double) min;
        this.max = (double) max;
    }

    public WithinCheck(Spinner view, String errorMessage, int min, int max) {
        super(view, errorMessage);

        this.min = (double) min;
        this.max = (double) max;
    }

    public WithinCheck(EditText view, String errorMessage, double min, double max) {
        super(view, errorMessage);
        this.min = min;
        this.max = max;
    }

    public WithinCheck(Spinner view, String errorMessage, double min, double max) {
        super(view, errorMessage);
        this.min = min;
        this.max = max;
    }

    @Override
    public boolean run() {
        boolean status = super.run();
        if (status) {
            Double val = Double.valueOf(getValue());

            if (!(val >= min && val <= max)) {
                status = false;
            }
        }

        return status;
    }
}
