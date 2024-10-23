/*
 * Copyright (c) 2021.  Hurricane Development Studios
 */

package com.hurricaneDev.videoDownloader.utils;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatButton;

import com.hurricaneDev.videoDownloader.R;

public class CustomButton extends AppCompatButton {

    public CustomButton(Context context) {
        super(context);
        setAppearance();
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        setAppearance();
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setAppearance();
    }

    private void setAppearance() {
        this.setBackgroundResource(R.drawable.button);
    }
}
