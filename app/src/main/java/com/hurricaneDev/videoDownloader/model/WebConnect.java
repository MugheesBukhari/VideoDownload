/*
 * Copyright (c) 2021.  Hurricane Development Studios
 */

package com.hurricaneDev.videoDownloader.model;

import android.util.Patterns;
import android.widget.EditText;

import com.hurricaneDev.videoDownloader.activity.MainActivity;

public class WebConnect {
    private EditText textBox;
    private MainActivity activity;

    public WebConnect(EditText textBox, MainActivity activity) {
        this.textBox = textBox;
        this.activity = activity;
    }

    public void connect() {
        String text = textBox.getText().toString();
        if (Patterns.WEB_URL.matcher(text).matches()) {
            if (!text.startsWith("https")) {
                text = "https://" + text;
            }
            activity.getBrowserManager().newWindow(text);
        } else {
            text = "https://google.com/search?q=" + text;
            activity.getBrowserManager().newWindow(text);
        }
    }
}
