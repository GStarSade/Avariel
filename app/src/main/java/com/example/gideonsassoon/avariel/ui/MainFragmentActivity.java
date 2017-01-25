package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.gideonsassoon.avariel.R;

public class MainFragmentActivity extends FragmentActivity {
    MainFragmentAdaptor mMainFragmentAdaptor;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        mMainFragmentAdaptor = new MainFragmentAdaptor(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mMainFragmentAdaptor);
    }
}
