package com.example.viewscollection;

import android.view.ViewGroup;
import android.widget.LinearLayout;

public class VerticalLinearLayout implements ContainerView {
    private final LinearLayout linearLayout;

    public VerticalLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
    }


    @Override
    public ViewGroup build() {
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        return linearLayout;
    }
}
