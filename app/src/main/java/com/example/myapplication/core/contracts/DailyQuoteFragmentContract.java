package com.example.myapplication.core.contracts;

public interface DailyQuoteFragmentContract {

    interface ViewListener {

    }

    interface PresenterListener {
        void setViewListener(ViewListener viewListener);
    }
}

