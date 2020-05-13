package com.example.viewscollection;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Point point1 = new Point();
        final Point point2 = new Point();
        getWindowManager().getDefaultDisplay().getCurrentSizeRange(point1, point2);
        getWindow().setBackgroundDrawable(new Drawable() {
            @Override
            public void draw(@NonNull Canvas canvas) {
                canvas.drawColor(Color.WHITE);
                new Background(
                        new SimpleText(
                                "Text 1",
                                new Paint(),
                                new Rect(
                                        0,
                                        getBounds().height() - point2.y,
                                        getBounds().width(),
                                        getBounds().height()
                                )
                        ),
                        new ColoredPaint(Color.GREEN).paint()
                ).draw(canvas);
            }

            @Override
            public void setAlpha(int alpha) {

            }

            @Override
            public void setColorFilter(@Nullable ColorFilter colorFilter) {

            }

            @Override
            public int getOpacity() {
                return 0;
            }
        });
    }
}