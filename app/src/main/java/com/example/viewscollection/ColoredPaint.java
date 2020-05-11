package com.example.viewscollection;

import android.graphics.Color;
import android.graphics.Paint;

public final class ColoredPaint {
    private final int color;

    public ColoredPaint(final int color) {
        this.color = color;
    }

    Paint paint() {
        Paint paint = new Paint();
        paint.setColor(color);
        return paint;
    }
}
