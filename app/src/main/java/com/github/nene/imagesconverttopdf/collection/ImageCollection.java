package com.github.nene.imagesconverttopdf.collection;

import androidx.fragment.app.Fragment;

import com.github.nene.imagesconverttopdf.ApplicationSingleFragmentActivity;

public class ImageCollection extends ApplicationSingleFragmentActivity {
    @Override
    protected Fragment CreateFragment() {
        return new ImageCollectionFragment();
    }
}
