package com.example.myapplication.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

public class DailyQuoteFragment extends BaseFragment<FragmentDailyQuoteBinding> implements DailyQuoteFragmentContract.ViewListener {

    SharedPreferences sharedPreferences;
    public static final String myPreference = "myPref";
    public static final String EngQuoteText = "engQuoteTextKey";
    public static final String EngQuoteAuthor = "engQuoteAuthorKey";
    public static final String RusQuoteText = "rusQuoteTextKey";
    public static final String RusQuoteAuthor = "rusQuoteAuthorKey";
    public static final String LastSingedDate = "lastSingedDateKey";

    @Inject
    DailyQuoteFragmentContract.PresenterListener presenterListener;
    @Inject
    QuoteDatabaseService databaseService;

    private boolean ifQuoteIsAlreadySaved = false;

    private boolean isLangEng = true;

    @Inject
    public DailyQuoteFragment() {
    }

    @Override
    protected void onFragmentCreated(View view, Bundle savedInstance) {
        setHasOptionsMenu(true);
        presenterListener.setViewListener(this);
        setOnClickListeners();
        sharedPreferences = getActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE);
        DateChecker();
        getFirstQuote();
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
        if (item.getItemId() == R.id.lang_change) {
            presenterListener.onChangeLangButtonClicked();
        }
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        checkIfCurrentQuoteIsSaved();
    }

    @Override
    public void shareQuote() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                binding.txtQuote.getText().toString() + "\n -" + binding.txtAuthor.getText().toString());
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }

    @Override
    public void changeLang() {
        isLangEng = !isLangEng;
        if (!isLangEng) {
            if (sharedPreferences.contains(RusQuoteText)) {
                binding.txtQuote.setText(sharedPreferences.getString(RusQuoteText, ""));
                binding.txtAuthor.setText(sharedPreferences.getString(RusQuoteAuthor, ""));
            } else getAndSetNewRusQuote();
        } else {
            if (sharedPreferences.contains(EngQuoteText)) {
                binding.txtQuote.setText(sharedPreferences.getString(EngQuoteText, ""));
                binding.txtAuthor.setText(sharedPreferences.getString(EngQuoteAuthor, ""));
            } else getAndSetNewEngQuote();
        }
        checkIfCurrentQuoteIsSaved();
    }

    private void getAndSetNewRusQuote() {
        Api.getInstance().getRandomRussianQuote(new Api.ApiListener() {
            @Override
            public void onQuoteReceived(String quote, String author) {
                binding.txtQuote.setText(quote);
                binding.btnSave.setImageDrawable(getContext().getDrawable(R.drawable.heart_empty));
                if (author != "") {
                    binding.txtAuthor.setText(author);
                } else binding.txtAuthor.setText("незнакомец");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(RusQuoteText, quote);
                editor.putString(RusQuoteAuthor, author);
                editor.apply();
            }

            @Override
            public void onFailure() {
                Toast.makeText(getContext(), "Some error occurred", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void saveOrDeleteQuote() {
        if (ifQuoteIsAlreadySaved) {
            databaseService.deleteQuoteByQuoteText(binding.txtQuote.getText().toString());
            ifQuoteIsAlreadySaved = false;
            binding.btnSave.setImageDrawable(getContext().getDrawable(R.drawable.heart_empty));
        } else {

            Quote quote = new Quote(binding.txtQuote.getText().toString(), binding.txtAuthor.getText().toString());
            databaseService.addQuote(quote);
            binding.btnSave.setImageDrawable(getContext().getDrawable(R.drawable.heart_clicked));
            ifQuoteIsAlreadySaved = true;
        }
    }

    @Override
    public void getAndSetNewQuote() {
        if (isLangEng) {
            getAndSetNewEngQuote();
        } else if (!isLangEng){
            getAndSetNewRusQuote();
        }

    }

    public void getAndSetNewEngQuote() {
        Api.getInstance().getRandomEnglishQuote(new Api.ApiListener() {
            @Override
            public void onQuoteReceived(String quote, String author) {
                binding.txtQuote.setText(quote);
                binding.btnSave.setImageDrawable(getContext().getDrawable(R.drawable.heart_empty));
                if (author != "") {
                    binding.txtAuthor.setText(author);
                } else binding.txtAuthor.setText("unknown");
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(EngQuoteText, quote);
                editor.putString(EngQuoteAuthor, author);
                editor.apply();
            }

            @Override
            public void onFailure() {
                Toast.makeText(getContext(), "Some error occurred", Toast.LENGTH_LONG).show();
            }
        });
    }

    void setOnClickListeners() {
        binding.btnSave.setOnClickListener(v -> presenterListener.onSaveButtonClicked());
        binding.btnShare.setOnClickListener(v -> presenterListener.onShareButtonClicked());
    }

    void checkIfCurrentQuoteIsSaved() {
        databaseService.ifExists(this::setIfQuoteIsAlreadySaved, binding.txtQuote.getText().toString());
    }

    void setIfQuoteIsAlreadySaved(Boolean ifExists) {
        if (ifExists) {
            binding.btnSave.setImageDrawable(getContext().getDrawable(R.drawable.heart_clicked));
        } else {
            binding.btnSave.setImageDrawable(getContext().getDrawable(R.drawable.heart_empty));
        }
        ifQuoteIsAlreadySaved = ifExists;
    }

    private void getFirstQuote(){
        if (sharedPreferences.contains(EngQuoteText)) {
            binding.txtQuote.setText(sharedPreferences.getString(EngQuoteText, ""));
            binding.txtAuthor.setText(sharedPreferences.getString(EngQuoteAuthor, ""));
        } else getAndSetNewEngQuote();
    }
    private String getDate() {
        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
        return df.format(c);
    }

    private void DateChecker(){
        if (sharedPreferences.contains(LastSingedDate)){
            if (!getDate().equals(sharedPreferences.getString(LastSingedDate, ""))){
                getAndSetNewQuote();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(LastSingedDate, getDate());
                editor.apply();
            }
        }
    }

}