package com.example.myapplication;

import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class DailySmartsApp extends Application implements HasAndroidInjector {

   @Inject
   DispatchingAndroidInjector<Object> activityDispatchingAndroidInjector;

    @Override
    public AndroidInjector<Object> androidInjector() {
        return activityDispatchingAndroidInjector;
    }
}
