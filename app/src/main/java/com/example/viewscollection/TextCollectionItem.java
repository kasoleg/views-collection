package com.example.viewscollection;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextCollectionItem implements CollectionItem {
    private final String text;

    public TextCollectionItem(String text) {
        this.text = text;
    }

    @Override
    public void show(ViewGroup container) {
        View root = LayoutInflater
                .from(container.getContext())
                .inflate(R.layout.text_item, container, false);
        TextView textView = root.findViewById(R.id.text);
        textView.setText(text);
        container.addView(textView);
    }
}
