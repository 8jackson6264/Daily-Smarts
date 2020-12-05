package com.example.myapplication.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.Quote;
import com.example.myapplication.data.api.Api;
import com.example.myapplication.data.database.QuoteDatabaseService;
import com.example.myapplication.databinding.FragmentMyQuotesBinding;
import com.example.myapplication.ui.adapters.MyQuotesAdapter;

import java.util.List;

import javax.inject.Inject;

public class MyQuotesFragment extends BaseFragment<FragmentMyQuotesBinding> {

    private MyQuotesAdapter myQuotesAdapter;
    @Inject
    QuoteDatabaseService quoteDatabaseService;

    @Inject
    public MyQuotesFragment() {
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstance) {
        quoteDatabaseService = new QuoteDatabaseService(getContext());
        setRecycleView();
    }

    @Override
    public void onResume() {
        super.onResume();
        quoteDatabaseService.getAllQuotes(data -> myQuotesAdapter.setQuotesList(data));
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_my_quotes;
    }

    private void setRecycleView() {
        binding.quoteRecycle.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        myQuotesAdapter = new MyQuotesAdapter();
        binding.quoteRecycle.setAdapter(myQuotesAdapter);
    }

}