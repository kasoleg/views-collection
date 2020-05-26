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
        getWindow().setBackgroundDrawable(
                new Drawable() {
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
                                new MultilineText(
                                                "Cyclone Amphan (satellite image shown) impacts eastern India and Bangladesh, killing at least eighty-two people and forcing the evacuation of more than four million others.",
                                                new DensityTextSizeBrush(
                                                        30,
                                                        getResources().getDisplayMetrics().density
                                                ),
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
                }
        );
    }
}