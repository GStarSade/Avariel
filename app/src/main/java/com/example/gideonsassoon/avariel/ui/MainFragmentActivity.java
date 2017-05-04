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
    EditText mRaceEditText = null;
    EditText mAlignmentEditText = null;
    EditText mClassEditText = null;
    EditText mCurrentHPEditText = null;
    EditText mTotalHPEditText = null;
    EditText mExperincePointsEditText = null;

    EditText mStrEditText = null;
    EditText mDexEditText = null;
    EditText mConEditText = null;
    EditText mIntEditText = null;
    EditText mWisEditText = null;
    EditText mChaEditText = null;

    Long dbNewPlayer;
    Player newPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DbHelper mDbHelper = new DbHelper(this);

        dbNewPlayer = mDbHelper.createNewPlayer("Edward", "Gideon", "Human", "Lawful Good", "Fighter", "I am ExMachina");
        //TODO if DB EXISTS, if not CREATE A NEW DB. Also create a default player.
        //Search Terms for research (Android SQLite check if DB Exists)!
        newPlayer = null;
        newPlayer = mDbHelper.getPlayer(1);
        setContentView(R.layout.activity_main_fragment);
        mMainFragmentAdaptor = new MainFragmentAdaptor(getSupportFragmentManager(), mDbHelper);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(mMainFragmentAdaptor);
        Player newPlayer = mDbHelper.getPlayer(1);
        addPlayerToUI(newPlayer);
    }

    //This might in the wrong play by the errors it seems that you're inserting this before it's set up
    void addPlayerToUI(Player player){

        mNameEditText = (EditText) findViewById(R.id.et_character_name);
        mRaceEditText = (EditText) findViewById(R.id.et_race);
        mAlignmentEditText = (EditText) findViewById(R.id.et_alignment);
        mClassEditText = (EditText) findViewById(R.id.et_class);
        mCurrentHPEditText = (EditText) findViewById(R.id.et_current_hp);
        mTotalHPEditText = (EditText) findViewById(R.id.et_total_hp);
        mExperincePointsEditText = (EditText) findViewById(R.id.et_exp);

        //TODO: Pull in Abilities table so that this information can be shown, you will need to create the abilities table.
        mStrEditText = (EditText) findViewById(R.id.et_strength);
        mDexEditText = (EditText) findViewById(R.id.et_dexterity);
        mConEditText = (EditText) findViewById(R.id.et_constitution);
        mIntEditText = (EditText) findViewById(R.id.et_intelligence);
        mWisEditText = (EditText) findViewById(R.id.et_wisdom);
        mChaEditText = (EditText) findViewById(R.id.et_charisma);

        mNameEditText.setText(player.getName());
        mRaceEditText.setText(player.getRace());
        mAlignmentEditText.setText(player.getAlignment());
        mClassEditText.setText(player.getPlayerClass());
        mCurrentHPEditText.setText(String.valueOf(player.getCurrentHP()));
        mTotalHPEditText.setText(String.valueOf(player.getTotalHP()));
        mExperincePointsEditText.setText(String.valueOf(player.getExperiencePoint()));
    }
}
