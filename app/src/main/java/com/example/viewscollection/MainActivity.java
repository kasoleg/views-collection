package com.example.viewscollection;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ViewGroup container = new VerticalLinearLayout(
                new LinearLayout(this)
        ).build();
        setContentView(container);
        new SimpleViewsCollection(container)
                .show(
                        new TextCollectionItem("Text 1"),
                        new TextCollectionItem("Text 2"),
                        new TextCollectionItem("Text 3")
                );
    }
}