package com.example.myapplication.ui.activities;

import androidx.viewpager2.widget.ViewPager2;
import com.example.myapplication.R;
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

    private void managingFragments(){
        TabLayout tabLayout=findViewById(R.id.tabs);
        TabAdapter tabAdapter= new TabAdapter(this.getSupportFragmentManager(),getLifecycle());
        ViewPager2 viewPager2=findViewById(R.id.viewpager);
        viewPager2.setAdapter(tabAdapter);
        viewPager2.setUserInputEnabled(true);
        TabLayoutMediator mediator=new TabLayoutMediator(tabLayout,viewPager2, (fragment, position) ->{
            switch (position){
                case 0:fragment.setText("DailyQuotes");
                case 1: fragment.setText("MyQuotes");
            }
        });
        mediator.attach();
    }


}