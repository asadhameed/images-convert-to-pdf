package com.github.nene.imagesconverttopdf.collection;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.github.nene.imagesconverttopdf.R;
import com.github.nene.imagesconverttopdf.adapter.ImageAdapter;

public class ImageCollectionFragment extends Fragment {
    private GridView gridView_image_collection;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, @NonNull Bundle saveBundle) {
        super.onCreateView(inflater, parent, saveBundle);
        View v = inflater.inflate(R.layout.activity_image_collection, null);
        gridView_image_collection = v.findViewById(R.id.gridView_image_collection);
        Intent intent = getActivity().getIntent();
        gridView_image_collection.setAdapter(new ImageAdapter(getContext(), intent));
        return v;
    }
}
