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
        viewListener.saveOrDeleteQuote();
    }

    @Override
    public void onRefreshButtonClicked() {
        viewListener.getAndSetNewQuote();
    }

    @Override
    public void onShareButtonClicked() {
        viewListener.shareQuote();
    }

    @Override
    public void onChangeLangButtonClicked() {
        viewListener.changeLang();
    }
}
