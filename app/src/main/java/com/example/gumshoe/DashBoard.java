package com.example.gumshoe;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class DashBoard extends AppCompatActivity {

    private ViewPager2 mViewPager;
    private BottomNavigationView mBottomNavigationView;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        initUi();
    }

    private void initUi() {

        mViewPager = findViewById(R.id.view_pager);
        mBottomNavigationView = findViewById(R.id.bottom_navigation);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());

        viewPagerAdapter.addFragment(new HomeFragment());
        viewPagerAdapter.addFragment(new StreamFragment());
        viewPagerAdapter.addFragment(new NotifyFragment());

        mViewPager.setAdapter(viewPagerAdapter);
        mViewPager.setUserInputEnabled(false);

        mBottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.nav_stream:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.nav_notify:
                        mViewPager.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }
}