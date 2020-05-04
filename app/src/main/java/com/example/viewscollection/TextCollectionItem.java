package com.example.viewscollection;

import android.view.ViewGroup;
import android.widget.TextView;

public class TextCollectionItem implements CollectionItem {
    private final String text;

    public TextCollectionItem(String text) {
        this.text = text;
    }

    @Override
    public void show(ViewGroup container) {
        TextView textView = new TextView(container.getContext());
        textView.setLayoutParams(
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                )
        );
        textView.setText(text);
        container.addView(textView);
    }
}
