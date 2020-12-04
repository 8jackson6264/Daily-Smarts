package com.example.myapplication.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.core.contracts.DailyQuoteFragmentContract;
import com.example.myapplication.data.Quote;
import com.example.myapplication.data.api.Api;
import com.example.myapplication.data.database.QuoteDatabaseService;
import com.example.myapplication.databinding.FragmentDailyQuoteBinding;

import javax.inject.Inject;

public class DailyQuoteFragment extends BaseFragment<FragmentDailyQuoteBinding> implements DailyQuoteFragmentContract.ViewListener {

    @Inject
    DailyQuoteFragmentContract.PresenterListener presenterListener;
    @Inject
    QuoteDatabaseService databaseService;

    @Inject
    public DailyQuoteFragment() {
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstance) {
        setHasOptionsMenu(true);
        presenterListener.setViewListener(this);
        setOnClickListeners();

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_daily_quote;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.drawer_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            presenterListener.onRefreshButtonClicked();
        }
        return true;
    }

    @Override
    public void saveQuote() {
        Quote quote = new Quote(binding.txtQuote.getText().toString(), binding.txtAuthor.getText().toString());

        databaseService.addQuote(quote);
        binding.btnSave.setImageDrawable(getContext().getDrawable(R.drawable.heart_clicked));
    }

    @Override
    public void getAndSetNewQuote() {
        binding.btnSave.setImageDrawable(getContext().getDrawable(R.drawable.heart_empty));
        Api.getInstance().getRandomEnglishQuote(new Api.ApiListener() {
            @Override
            public void onQuoteReceived(String quote, String author) {
                binding.txtQuote.setText(quote);
                if (author != "") {
                    binding.txtAuthor.setText("-" + author);
                } else binding.txtAuthor.setText("unknown");
            }

            @Override
            public void onFailure() {
                Toast.makeText(getContext(), "Some error occurred", Toast.LENGTH_LONG).show();
            }
        });
    }

    void setOnClickListeners (){
        binding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveQuote();
            }
        });
    }

}