package com.example.viewscollection;

import android.graphics.Paint;

public class TextSizeBrush implements Brush {
    private final Brush brush;
    private final int size;

    public TextSizeBrush(Brush brush, int size) {
        this.brush = brush;
        this.size = size;
    }

    public TextSizeBrush(int size) {
        this(new DefaultBrush(), size);
    }

    @Override
    public Paint paint() {
        Paint paint = brush.paint();
        paint.setTextSize(size);
        return paint;
    }
}
