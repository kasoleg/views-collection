package com.example.viewscollection;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

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
        int linesCount = 0;
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            width += widths[i];
            if (width > rect.right - rect.left) {
                Rect bounds = new Rect();
                paint.getTextBounds(text, 0, text.length(), bounds);
                int height = Math.abs(bounds.top) + Math.abs(bounds.bottom);
                new Text(
                        text.substring(start, i - 1),
                        brush,
                        new Rect(
                                rect.left,
                                rect.top + linesCount * height,
                                rect.right,
                                rect.bottom
                        )
                ).draw(canvas);
                linesCount++;
                start = i - 1;
                width = 0;
            }
        }
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        int height = Math.abs(bounds.top) + Math.abs(bounds.bottom);
        new Text(
                text.substring(start),
                brush,
                new Rect(
                        rect.left,
                        rect.top + linesCount * height,
                        rect.right,
                        rect.bottom
                )
        ).draw(canvas);
    }

    @Override
    public Rect measure() {
        Paint paint = brush.paint();
        final float[] widths = new float[text.length()];
        paint.getTextWidths(text, 0, text.length(), widths);
        int width = 0;
        int linesCount = 0;
        for (int i = 0; i < text.length(); i++) {
            width += widths[i];
            if (width > rect.right - rect.left) {
                linesCount++;
                width = 0;
            }
        }
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        int height = Math.abs(bounds.top) + Math.abs(bounds.bottom);
        linesCount++;
        return new Rect(rect.left, rect.top, rect.right, rect.top + linesCount * height);
    }
}
