package com.example.gideonsassoon.avariel;

import android.database.SQLException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.gideonsassoon.avariel.database.DbHelper;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * Created by Gideon Sassoon on 25/03/2017.
 */


@RunWith(AndroidJUnit4.class)
public class DatabaseTest extends TestCase {
    DbHelper dbHelper;
    long newPlayer;

    @Before
    public void setup() {
        System.out.println("Before Start");
        dbHelper = new DbHelper(InstrumentationRegistry.getTargetContext());
    }

    @Test
    public void createNewPlayer() {
        try {
            System.out.println("Create new player Start");
            newPlayer = dbHelper.createNewPlayer(
                    "Gideon",
                    "I am ExMachina",
                    "Human",
                    "Lawful Good",
                    "Edward");
            Log.println(Log.INFO, "DatabaseTest", "Database returned: " + newPlayer);
            //Assert.assertThat(newPlayer, Is.<Long>is(IsNot.<Long>not(IsEqual.<Long>equalTo((long) -1))));
            //TODO: Returns: long: the row ID of the newly inserted row, or -1 if an error occurred AN ERROR WAS RETURNED.
        }
        catch(SQLException e)
        {
            // Sep 12, 2013 6:50:17 AM
            Log.e("Exception","SQLException "+String.valueOf(e.getMessage()));
            e.printStackTrace();
        }
    }

    @Test
    public void getPlayer() {
        //dbHelper.getPlayer(newPlayer);
    }
}
