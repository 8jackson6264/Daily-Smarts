package com.example.myapplication.ui.activities;

import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.R;
import com.example.myapplication.data.api.Api;
import com.example.myapplication.ui.fragments.DailyQuoteFragment;
import com.example.myapplication.ui.fragments.MyQuotesFragment;

import javax.inject.Inject;

import com.example.myapplication.ui.adapters.TabAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends BaseActivity {

    @Inject
    DailyQuoteFragment dailyQuoteFragment;

    @Inject
    MyQuotesFragment myQuotesFragment;

    @Override
    protected void onViewCreated() {
        managingFragments();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    private void managingFragments() {
        TabLayout tabLayout = findViewById(R.id.tabs);
        TabAdapter tabAdapter = new TabAdapter(this.getSupportFragmentManager(), getLifecycle(),
                dailyQuoteFragment, myQuotesFragment);
        ViewPager2 viewPager2 = findViewById(R.id.viewpager);
        viewPager2.setAdapter(tabAdapter);
        viewPager2.setUserInputEnabled(false);
        TabLayoutMediator mediator = new TabLayoutMediator(tabLayout, viewPager2,
                this::setTextToTheTabLayoutDependingOnThePosition);
        mediator.attach();
    }

    private void setTextToTheTabLayoutDependingOnThePosition(TabLayout.Tab tab, int position){
        switch (position) {
            case 0:
                tab.setText("DailyQuotes"); break;
            case 1:
                tab.setText("MyQuotes"); break;
            default:
                throw new IllegalArgumentException("unavailable tab");
        }
    }



}