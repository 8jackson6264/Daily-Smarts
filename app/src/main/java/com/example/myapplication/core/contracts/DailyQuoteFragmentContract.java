package com.example.myapplication.core.contracts;

public interface DailyQuoteFragmentContract {

    interface ViewListener {
        void saveQuote();
        void getAndSetNewQuote();

    }

    interface PresenterListener {
        void setViewListener(ViewListener viewListener);
        void onSaveButtonClicked();
        void onRefreshButtonClicked();
    }
}

