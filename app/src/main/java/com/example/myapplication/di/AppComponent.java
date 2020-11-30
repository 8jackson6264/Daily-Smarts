package com.example.myapplication.di;

import com.example.myapplication.DailySmartsApp;
import com.example.myapplication.di.modules.FragmentsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {FragmentsModule.class})
public interface AppComponent {
    void inject(DailySmartsApp dailySmartsApp);
    
}
