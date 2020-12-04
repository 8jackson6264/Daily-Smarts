package com.example.myapplication.core.presenters;

import com.example.myapplication.core.contracts.DailyQuoteFragmentContract;

public class DailyQuoteFragmentPresenter implements DailyQuoteFragmentContract.PresenterListener {

    DailyQuoteFragmentContract.ViewListener viewListener;

    @Override
    public void setViewListener(DailyQuoteFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    @Override
    public void onSaveButtonClicked() {
        viewListener.saveQuote();
    }

    @Override
    public void onRefreshButtonClicked() {
        viewListener.getAndSetNewQuote();
    }
}
