package com.github.nene.imagesconverttopdf.collection;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.github.nene.imagesconverttopdf.ApplicationMainActivity;
import com.github.nene.imagesconverttopdf.R;
import com.github.nene.imagesconverttopdf.adapter.ImageAdapter;

public class ImageCollectionFragment extends Fragment {
    private GridView gridView_image_collection;
    private Button btnCancel;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, @NonNull Bundle saveBundle) {
        super.onCreateView(inflater, parent, saveBundle);
        View view = inflater.inflate(R.layout.activity_image_collection, null);
        Intent intent = getActivity().getIntent();
        setUpWidget(view);
        gridView_image_collection.setAdapter(new ImageAdapter(getContext(), intent));
        // The cancel click listener implements
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ApplicationMainActivity.class));
            }
        });
        return view;
    }

    private void setUpWidget(View view) {
        gridView_image_collection = view.findViewById(R.id.gridView_image_collection);
        btnCancel = view.findViewById(R.id.btnCancel);
    }
}
