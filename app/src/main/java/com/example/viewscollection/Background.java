package com.example.viewscollection;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public final class Background implements UiElement {
    private final UiElement view;
    private final Brush brush;

    public Background(final UiElement view, final Brush brush) {
        this.view = view;
        this.brush = brush;
    }

    @Override
    public void draw(Canvas canvas) {
        Rect rect = view.measure();
        canvas.drawRect(rect, brush.paint());
        view.draw(canvas);
    }

    @Override
    public Rect measure() {
        return view.measure();
    }
}
