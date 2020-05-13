package com.example.viewscollection;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public final class Background implements UiElement {
    private final UiElement view;
    private final Paint paint;

    public Background(final UiElement view, final Paint paint) {
        this.view = view;
        this.paint = paint;
    }

    @Override
    public void draw(Canvas canvas) {
        Rect rect = view.measure();
        canvas.drawRect(rect, paint);
        view.draw(canvas);
    }

    @Override
    public Rect measure() {
        return view.measure();
    }
}
