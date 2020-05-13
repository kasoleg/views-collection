package com.example.viewscollection;

import android.graphics.Paint;

public final class ColorBrush implements Brush {
    private final int color;
    private final Paint paint;

    public ColorBrush(final int color) {
        this.color = color;
        paint = new Paint();
    }

    @Override
    public Paint paint() {
        paint.setColor(color);
        return paint;
    }
}
