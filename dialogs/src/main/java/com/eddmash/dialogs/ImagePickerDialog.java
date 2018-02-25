package com.eddmash.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * A picker that allows to choose between taking a photo using a camera app
 * or pick one from the phone gallery.
 */

public class ImagePickerDialog extends GenericDialog {
    private TextView camera;
    private TextView gallary;
    private OnClickInterface clickListner;

    @Override
    protected void onViewReady(View view, @Nullable Bundle savedInstanceState) {
        setTitle(getString(R.string.prompt));

        gallary = view.findViewById(R.id.gallery);
        gallary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListner.fromGallery();
            }
        });
        camera = view.findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListner.fromCamera();
            }
        });

    }

    @Override
    protected int getContentLayout() {
        return R.layout.dialog_imagepicker;
    }

    /**
     * Set a listener for camera or gallery action.
     *
     * @param clickListner
     */
    public void setClickListner(OnClickInterface clickListner) {

        this.clickListner = clickListner;
    }

    /**
     * Listener for camera or gallery .
     */
    public interface OnClickInterface {

        /**
         * Trigered if image is to fetched from the gallery
         */
        void fromGallery();

        /**
         * Triggered if image is to taken from the camera.
         */
        void fromCamera();
    }

}
