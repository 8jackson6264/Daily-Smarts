package com.example.myapplication.core.contracts;

public interface DailyQuoteFragmentContract {

    interface ViewListener {
        void saveOrDeleteQuote();
        void getAndSetNewQuote();
        void shareQuote();

    }

    interface PresenterListener {
        void setViewListener(ViewListener viewListener);
        void onSaveButtonClicked();
        void onRefreshButtonClicked();
        void onShareButtonClicked();
    }
}

