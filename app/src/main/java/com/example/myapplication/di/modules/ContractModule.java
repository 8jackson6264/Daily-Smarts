package com.example.myapplication.di.modules;

import com.example.myapplication.core.contracts.DailyQuoteFragmentContract;
import com.example.myapplication.core.contracts.MyQuotesFragmentContract;
import com.example.myapplication.core.presenters.DailyQuoteFragmentPresenter;
import com.example.myapplication.core.presenters.MyQuotesFragmentPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContractModule {
    @Singleton
    @Provides
    DailyQuoteFragmentContract.PresenterListener provideTabDailyQuotePresenter() {
        return new DailyQuoteFragmentPresenter();
    }

    @Singleton
    @Provides
    MyQuotesFragmentContract.PresenterListener provideTabMyQuotesPresenter() {
        return new MyQuotesFragmentPresenter();
    }
}
