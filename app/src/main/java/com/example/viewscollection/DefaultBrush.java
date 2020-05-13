package com.example.viewscollection;

import android.graphics.Paint;

public class DefaultBrush implements Brush {
    private final Paint paint;

    public DefaultBrush() {
        this.paint = new Paint();
    }

    @Override
    public Paint paint() {
        return paint;
    }
}
