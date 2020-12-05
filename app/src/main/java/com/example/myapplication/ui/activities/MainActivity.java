package com.example.myapplication.ui.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
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
        if(!isNetworkConnected()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Check your internet connection and try again")
                    .setTitle("Not connected").setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    recreate();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
        else {
            managingFragments();
            SwipeRefreshLayout pullToRefresh = findViewById(R.id.swipeRefresh);
            pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    onRefresh();
                    pullToRefresh.setRefreshing(false);
                }
            });
        }
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
                tab.setText("Daily Quote"); break;
            case 1:
                tab.setText("My Quotes"); break;
            default:
                throw new IllegalArgumentException("unavailable tab");
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();    }


}