package com.example.viewscollection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewGroup container = findViewById(R.id.container);
        new SimpleViewsCollection(container)
                .show(
                        new TextCollectionItem("Text 1"),
                        new TextCollectionItem("Text 2"),
                        new TextCollectionItem("Text 3")
                );
    }
}