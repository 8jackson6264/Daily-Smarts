package com.example.myapplication.ui.activities;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;

import com.example.myapplication.R;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {
    public static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_AppCompat);
        setContentView(getLayoutRes());
        onViewCreated();

    }

    protected abstract void onViewCreated();

    protected abstract int getLayoutRes();
}
