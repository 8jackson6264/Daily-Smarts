package com.example.myapplication.di.modules;

import com.example.myapplication.DailySmartsApp;
import com.example.myapplication.data.database.QuoteDatabaseService;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    @Provides
    QuoteDatabaseService provideQuoteService(DailySmartsApp application) {
        return new QuoteDatabaseService(application);
    }
}
