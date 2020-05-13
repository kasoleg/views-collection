package com.example.viewscollection;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public final class Text implements UiElement {
    private final String text;
    private final Brush brush;
    private final Rect layout;
    private final Rect bounds = new Rect();

    public Text(final String text, final Brush brush, final Rect layout) {
        this.text = text;
        this.brush = brush;
        this.layout = layout;
    }

    public Text(final String text) {
        this(text, new DefaultBrush(), new Rect());
    }

    public Text(final String text, final Rect layout) {
        this(text, new DefaultBrush(), layout);
    }

    @Override
    public void draw(final Canvas canvas) {
        Paint paint = brush.paint();
        paint.getTextBounds(text, 0, text.length(), bounds);
        int height = Math.abs(bounds.top);
        int x = layout.left;
        int y = layout.top + height;
        canvas.drawText(text, x, y, paint);
    }

    @Override
    public Rect measure() {
        brush.paint().getTextBounds(text, 0, text.length(), bounds);
        final int height = Math.abs(bounds.top);
        int left = layout.left;
        int top = layout.top;
        int right = left + bounds.right;
        int bottom = top + height;
        return new Rect(left, top, right, bottom);
    }
}
