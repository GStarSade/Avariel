package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.database.DbHelper;

public class MainFragmentActivity extends FragmentActivity {
    MainFragmentAdaptor mMainFragmentAdaptor;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DbHelper mDbHelper = new DbHelper(this);

        mDbHelper.createNewPlayer(
                "Gideon",
                "I am ExMachina",
                "Human",
                "Lawful Good",
                "Edward");

        //TODO if DB EXISTS, if not CREATE A NEW DB. Also create a default player.
        //Search Terms for research (Android SQLite check if DB Exists)!


        setContentView(R.layout.activity_main_fragment);
        mMainFragmentAdaptor = new MainFragmentAdaptor(getSupportFragmentManager(), mDbHelper);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mMainFragmentAdaptor);
    }
}
