package com.example.viewscollection;

import android.graphics.Paint;

public final class DensityTextSizeBrush implements Brush {
    private final Brush brush;
    private final float density;


    public DensityTextSizeBrush(Brush brush, float density) {
        this.brush = brush;
        this.density = density;
    }

    public DensityTextSizeBrush(final int size, float density) {
        this(new TextSizeBrush(size), density);
    }

    @Override
    public Paint paint() {
        Paint paint = brush.paint();
        paint.setTextSize(paint.getTextSize() * density);
        return paint;
    }
}
