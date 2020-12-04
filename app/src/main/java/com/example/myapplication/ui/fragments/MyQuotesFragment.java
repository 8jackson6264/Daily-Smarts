package com.example.myapplication.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.api.Api;
import com.example.myapplication.databinding.FragmentMyQuotesBinding;

import javax.inject.Inject;

public class MyQuotesFragment extends BaseFragment <FragmentMyQuotesBinding>{

    @Inject
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