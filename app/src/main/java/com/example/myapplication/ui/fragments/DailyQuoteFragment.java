package com.example.myapplication.ui.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.api.Api;
import com.example.myapplication.databinding.FragmentDailyQuoteBinding;

import javax.inject.Inject;

public class DailyQuoteFragment extends BaseFragment<FragmentDailyQuoteBinding> {

    @Inject
    public DailyQuoteFragment() {
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstance) {
        Api.getInstance().getRandomEnglishQuote(new Api.ApiListener() {
            @Override
            public void onQuoteReceived(String quote, String author) {
                binding.txtQuote.setText(quote);
                binding.txtAuthor.setText(author);
            }

            @Override
            public void onFailure() {
                Toast.makeText(getContext(), "Some error has occurred", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_daily_quote;
    }
}