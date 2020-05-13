package com.example.viewscollection;

import android.graphics.Canvas;
import android.view.View;

public interface UiElement extends UiMeasure {
    void draw(Canvas canvas);
}
