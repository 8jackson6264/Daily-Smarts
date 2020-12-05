package com.example.myapplication.core.contracts;

public interface MyQuotesFragmentContract {

    interface ViewListener {
    }

    interface PresenterListener {
        void setViewListener(ViewListener viewListener);
    }

}
