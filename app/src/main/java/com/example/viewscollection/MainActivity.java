package com.example.viewscollection;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
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
        /*Log.d("oleg", "onCreate: " + point1);
        Log.d("oleg", "onCreate: " + point2);*/
        //getWindowManager().getDefaultDisplay().getSize(point1);
        getWindow().setBackgroundDrawable(new Drawable() {
            @Override
            public void draw(@NonNull Canvas canvas) {
                canvas.drawColor(Color.WHITE);
                final int top;
                final int rotation = getWindowManager().getDefaultDisplay().getRotation();
                if (rotation == 0 || rotation == 2) {
                    top = getBounds().height() - point2.y;
                } else {
                    top = getBounds().height() - point1.y;
                }
                new Background(
                        new Text(
                                "Text 1",
                                new TextSizeBrush(150),
                                new Rect(
                                        0,
                                        top,
                                        getBounds().width(),
                                        getBounds().height()
                                )
                        ),
                new ColorBrush(Color.GREEN)
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