package com.example.myapplication.ui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.ui.fragments.DailyQuoteFragment;
import com.example.myapplication.ui.fragments.MyQuotesFragment;

import javax.inject.Inject;


public class TabAdapter extends FragmentStateAdapter {

    private DailyQuoteFragment dailyQuoteFragment;
    private MyQuotesFragment myQuotesFragment;

    @Inject
    public TabAdapter(FragmentManager fragmentManager,
                      Lifecycle lifecycle,
                      DailyQuoteFragment dailyQuoteFragment,
                      MyQuotesFragment myQuotesFragment) {
        super(fragmentManager, lifecycle);
        this.dailyQuoteFragment = dailyQuoteFragment;
        this.myQuotesFragment = myQuotesFragment;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return dailyQuoteFragment;
            case 1:
                return myQuotesFragment;
            default:
                throw new IllegalArgumentException("Unavailable tab");
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
