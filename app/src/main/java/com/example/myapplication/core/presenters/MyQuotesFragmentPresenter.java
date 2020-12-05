package com.example.myapplication.core.presenters;

import com.example.myapplication.core.contracts.MyQuotesFragmentContract;

public class MyQuotesFragmentPresenter implements MyQuotesFragmentContract.PresenterListener {

    MyQuotesFragmentContract.ViewListener viewListener;

    @Override
    public void setViewListener(MyQuotesFragmentContract.ViewListener viewListener) {
        this.viewListener = viewListener;
    }

}
