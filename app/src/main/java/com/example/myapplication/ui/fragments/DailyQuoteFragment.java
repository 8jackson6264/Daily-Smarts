package com.example.myapplication.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentDailyQuoteBinding;

import javax.inject.Inject;

public class DailyQuoteFragment extends BaseFragment<FragmentDailyQuoteBinding> {

    @Inject
    public DailyQuoteFragment() {
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstance) {
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_daily_quote;
    }
}