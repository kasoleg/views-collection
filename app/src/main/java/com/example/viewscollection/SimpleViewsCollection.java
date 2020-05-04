package com.example.viewscollection;

import android.view.ViewGroup;

public final class SimpleViewsCollection implements ViewsCollection {
    private final ViewGroup container;

    public SimpleViewsCollection(ViewGroup container) {
        this.container = container;
    }

    @Override
    public void show(CollectionItem... items) {
        for (CollectionItem item: items) {
            item.show(container);
        }
    }
}
