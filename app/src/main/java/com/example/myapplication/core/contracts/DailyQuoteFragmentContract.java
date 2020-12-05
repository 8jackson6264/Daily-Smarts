package com.example.myapplication.core.contracts;

public interface DailyQuoteFragmentContract {

    interface ViewListener {
        void saveOrDeleteQuote();
        void getAndSetNewEngQuote();
        void shareQuote();
        void changeLang();
    }

    interface PresenterListener {
        void setViewListener(ViewListener viewListener);
        void onSaveButtonClicked();
        void onRefreshButtonClicked();
        void onShareButtonClicked();
        void onChangeLangButtonClicked();
    }
}

