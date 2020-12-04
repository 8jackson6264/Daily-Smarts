package com.example.myapplication.di;

import com.example.myapplication.DailySmartsApp;
import com.example.myapplication.di.modules.ActivityModule;
import com.example.myapplication.di.modules.ContractModule;
import com.example.myapplication.di.modules.DataModule;
import com.example.myapplication.di.modules.FragmentsModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        FragmentsModule.class,
        AndroidSupportInjectionModule.class,
        ActivityModule.class,
        AndroidInjectionModule.class,
        DataModule.class,
        ContractModule.class
})
public interface AppComponent {
    void inject(DailySmartsApp dailySmartsApp);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder applicationBind(DailySmartsApp dailySmartsApp);

        AppComponent build();
    }

}
