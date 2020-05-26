package com.example.viewscollection;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.util.ArrayList;

public final class MultilineText implements UiElement {
    private final String text;
    private final Brush brush;
    private final Rect rect;
    private final ArrayList<Rect> strings = new ArrayList<>();

    public MultilineText(final String text, final Rect rect) {
        this(text, new DefaultBrush(), rect);
    }

    public MultilineText(final String text, final Brush brush, final Rect rect) {
        this.text = text;
        this.brush = brush;
        this.rect = rect;
    }
    Text textView;
    @Override
    public void draw(Canvas canvas) {
        Paint paint = brush.paint();
        final float[] widths = new float[text.length()];
        paint.getTextWidths(text, 0, text.length(), widths);
        int width = 0;
        int height = 0;
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            width += widths[i];
            if (width > rect.right - rect.left || i == text.length() - 1) {
                final Text text = new Text(
                        this.text.substring(start, i - 1),
                        brush,
                        new Rect(
                                rect.left,
                                rect.top + height,
                                rect.right,
                                rect.bottom
                        )
                );
                final Rect measure = text.measure();
                int height1 = Math.abs(measure.bottom) - Math.abs(measure.top);
                height += height1;
                text.draw(canvas);
                linesCount++;
                start = i - 1;
                width = 0;
            }
        }
    }

    @Override
    public Rect measure() {
        Paint paint = brush.paint();
        final float[] widths = new float[text.length()];
        paint.getTextWidths(text, 0, text.length(), widths);
        int width = 0;
        int height = 0;
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            width += widths[i];
            if (width > rect.right - rect.left || i == text.length() - 1) {
                final Text text = new Text(
                        this.text.substring(start, i - 1),
                        brush,
                        new Rect(
                                rect.left,
                                rect.top + height,
                                rect.right,
                                rect.bottom
                        )
                );
                final Rect measure = text.measure();
                height += Math.abs(measure.bottom) - Math.abs(measure.top);
                width = 0;
                start = i - 1;
            }
        }
        return new Rect(rect.left, rect.top, rect.right, rect.top + height);
    }
}
