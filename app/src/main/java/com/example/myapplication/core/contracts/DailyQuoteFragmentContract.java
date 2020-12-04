package com.example.myapplication.core.contracts;

public interface DailyQuoteFragmentContract {

    interface ViewListener {

        void getAndSetNewQuote();

        void saveQuote();

    }

    interface PresenterListener {
        void setViewListener(ViewListener viewListener);

        void onSaveButtonClicked();

        void onRefreshButtonClicked();
    }
}

