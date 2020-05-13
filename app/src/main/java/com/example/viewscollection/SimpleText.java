package com.example.viewscollection;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.util.Log;
import android.util.Size;
import android.view.View;

public final class SimpleText implements UiElement {
    private final String text;
    private final Paint paint;
    private final Rect layout;
    private final Rect bounds = new Rect();

    public SimpleText(final String text, final Paint paint, final Rect layout) {
        this.text = text;
        this.paint = paint;
        this.layout = layout;
    }

    @Override
    public void draw(final Canvas canvas) {
        paint.getTextBounds(text, 0, text.length(), bounds);
        int height = Math.abs(bounds.top);
        int x = layout.left;
        int y = layout.top + height;
        canvas.drawText(text, x, y, paint);
    }

    @Override
    public Rect measure() {
        paint.getTextBounds(text, 0, text.length(), bounds);
        final int height = Math.abs(bounds.top);
        int left = layout.left;
        int top = layout.top;
        int right = left + bounds.right;
        int bottom = top + height;
        return new Rect(left, top, right, bottom);
    }
}
