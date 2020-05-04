package com.example.viewscollection;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);
        setContentView(container);
        new SimpleViewsCollection(container)
                .show(
                        new TextCollectionItem("Text 1"),
                        new TextCollectionItem("Text 2"),
                        new TextCollectionItem("Text 3")
                );
    }
}