package com.example.viewscollection;

import android.graphics.Paint;

public class SizeBrush implements Brush {
    private final Brush brush;
    private final int size;
    private final Paint paint;

    public SizeBrush(Brush brush, int size) {
        this.brush = brush;
        this.size = size;
        this.paint = new Paint();
    }

    public SizeBrush(int size) {
        this(new DefaultBrush(), size);
    }

    @Override
    public Paint paint() {
        paint.setTextSize(size);
        return paint;
    }
}
