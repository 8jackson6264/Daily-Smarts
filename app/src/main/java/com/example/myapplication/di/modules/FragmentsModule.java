package com.example.myapplication.di.modules;

import com.example.myapplication.ui.fragments.DailyQuoteFragment;
import com.example.myapplication.ui.fragments.MyQuotesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract DailyQuoteFragment provideDailyQuoteFragment();
    @ContributesAndroidInjector
    abstract MyQuotesFragment provideMyQuotesFragment();
}
