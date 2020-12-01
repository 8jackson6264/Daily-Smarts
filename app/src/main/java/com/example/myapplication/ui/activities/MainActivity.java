package com.example.myapplication.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.myapplication.DailySmartsApp;
import com.example.myapplication.R;
import com.example.myapplication.ui.fragments.DailyQuoteFragment;
import com.example.myapplication.ui.fragments.MyQuotesFragment;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;

public class MainActivity extends BaseActivity {

    @Inject
    DailyQuoteFragment dailyQuoteFragment;

    @Inject
    MyQuotesFragment myQuotesFragment;


    @Override
    protected void onViewCreated() {
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }
}