package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.di.DaggerAppComponent;

import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;

public class DailySmartsApp extends Application implements HasAndroidInjector {

   @Inject
   DispatchingAndroidInjector<Object> activityDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();

        DaggerAppComponent.builder()
                .applicationBind(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return activityDispatchingAndroidInjector;
    }
}
