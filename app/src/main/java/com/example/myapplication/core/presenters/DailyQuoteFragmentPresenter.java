package com.example.myapplication.core.presenters;

import com.example.myapplication.core.contracts.DailyQuoteFragmentContract;

public class DailyQuoteFragmentPresenter implements DailyQuoteFragmentContract.PresenterListener {

    DailyQuoteFragmentContract.ViewListener viewListener;

    @Override
    public void setViewListener(DailyQuoteFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }
}
