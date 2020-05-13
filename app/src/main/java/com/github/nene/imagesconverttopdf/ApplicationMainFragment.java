package com.github.nene.imagesconverttopdf;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

public class ApplicationMainFragment extends Fragment implements View.OnClickListener {
    private static final String APPLICATION_TAG = ApplicationMainFragment.class.toString();
    private Button open_file_location_btn;
    private final int REQUEST_EXTERNAL_STORAGE = 100;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.activity_main_application, container, false);
        open_file_location_btn = v.findViewById(R.id.open_file_location_btn);
        open_file_location_btn.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        Log.e(APPLICATION_TAG, "Click on button ");
        getReadPermissionGranted();
    }

    private void getReadPermissionGranted() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            Log.e(APPLICATION_TAG, "getReadPermissionGranted() take permssion ");
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_EXTERNAL_STORAGE);
        } else
            galleryOfFiles();

    }

    private void galleryOfFiles() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setType("images/*");
        startActivityForResult(intent, REQUEST_EXTERNAL_STORAGE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @Nullable String[] permissions, @Nullable int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_EXTERNAL_STORAGE) {
            if (permissions[0].equals(Manifest.permission.READ_EXTERNAL_STORAGE)
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.e(APPLICATION_TAG, "onRequestPermissionsResult and now going to call gallery ");

                galleryOfFiles();
            }
        }
    }
}
