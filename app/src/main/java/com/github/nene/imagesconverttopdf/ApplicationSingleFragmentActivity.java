package com.github.nene.imagesconverttopdf;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public abstract class ApplicationSingleFragmentActivity extends AppCompatActivity {
    protected abstract Fragment CreateFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_main_fragement);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            fragment = CreateFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
