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

public class ImageCollectionFragment extends Fragment implements View.OnClickListener  {
    private GridView gridView_image_collection;
    private Button btnCancel;
    private Button btnOk;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, @NonNull Bundle saveBundle) {
        super.onCreateView(inflater, parent, saveBundle);
        View view = inflater.inflate(R.layout.activity_image_collection, null);
        Intent intent = getActivity().getIntent();
        setUpWidget(view);
        btnListener();
        gridView_image_collection.setAdapter(new ImageAdapter(getContext(), intent));
        return view;
    }

    private void btnListener(){
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    private void setUpWidget(View view) {
        gridView_image_collection = view.findViewById(R.id.gridView_image_collection);
        btnCancel = view.findViewById(R.id.btnCancel);
        btnOk=view.findViewById(R.id.btnOk);
    }

    @Override
    public  void onClick(View view){
        switch (view.getId()){
            case R.id.btnCancel:
                startActivity(new Intent(getContext(), ApplicationMainActivity.class));
                break;
            case R.id.btnOk:

                break;
            default:
        }
    }
}
