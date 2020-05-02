package com.github.nene.imagesconverttopdf;

import androidx.fragment.app.Fragment;

public class ApplicationMainActivity extends ApplicationSingleFragmentActivity {

    @Override
    protected Fragment CreateFragment() {
        return new ApplicationMainFragment();
    }
}
