package com.example.myapplication.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;

public class MyQuotesFragment extends BaseFragment {

    public MyQuotesFragment() {
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstance) {
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my_quotes;
    }
}