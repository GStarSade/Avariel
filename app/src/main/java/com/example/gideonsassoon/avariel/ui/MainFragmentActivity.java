package com.example.gideonsassoon.avariel.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.EditText;

import com.example.gideonsassoon.avariel.R;
import com.example.gideonsassoon.avariel.data.Player;
import com.example.gideonsassoon.avariel.database.DbHelper;

public class MainFragmentActivity extends FragmentActivity {
    MainFragmentAdaptor mMainFragmentAdaptor;
    ViewPager mViewPager;

    //This section is using DB stuff it may need to be moved about this is just for a quick fix
    EditText mNameEditText = null;
    Long dbNewPlayer;
    Player newPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DbHelper mDbHelper = new DbHelper(this);

        dbNewPlayer = mDbHelper.createNewPlayer(
                "Gideon",
                "I am ExMachina",
                "Human",
                "Lawful Good",
                "Edward");

        //TODO if DB EXISTS, if not CREATE A NEW DB. Also create a default player.
        //Search Terms for research (Android SQLite check if DB Exists)!
        newPlayer = null;
        newPlayer = mDbHelper.getPlayer(11);

        setContentView(R.layout.activity_main_fragment);
        mMainFragmentAdaptor = new MainFragmentAdaptor(getSupportFragmentManager(), mDbHelper);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mMainFragmentAdaptor);
        //addPlayerToUI(newPlayer);
    }

    //This might in the wrong play by the errors it seems that you're inserting this before it's set up
    void addPlayerToUI(Player player){

        mNameEditText = (EditText) findViewById(R.id.et_character_name);
        mNameEditText.setText(player.getName());
    }
}
