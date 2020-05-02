package com.example.viewscollection;

public class RecycleViewsCollection implements ViewsCollection {
    private final SimpleViewsCollection simpleViewsCollection;

    public RecycleViewsCollection(SimpleViewsCollection simpleViewsCollection) {
        this.simpleViewsCollection = simpleViewsCollection;
    }

    @Override
    public void show(CollectionItem... items) {

    }
}
