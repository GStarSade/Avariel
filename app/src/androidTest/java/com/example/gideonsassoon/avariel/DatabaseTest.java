package com.example.gideonsassoon.avariel;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.gideonsassoon.avariel.database.DbHelper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by Gideon Sassoon on 25/03/2017.
 */

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    @Before
    public void setup(){
        DbHelper dbHelper = new DbHelper(InstrumentationRegistry.getTargetContext());
        long newPlayer = dbHelper.createNewPlayer(
                "Gideon",
                "I am ExMachina",
                "Human",
                "Lawful Good",
                "Edward");
        dbHelper.getPlayer(newPlayer);

    }
    @Test
    public void createNewPlayer(){

    }
}
