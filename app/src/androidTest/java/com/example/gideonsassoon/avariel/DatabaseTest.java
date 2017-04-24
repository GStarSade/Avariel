package com.example.gideonsassoon.avariel;

import android.database.SQLException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.gideonsassoon.avariel.data.Player;
import com.example.gideonsassoon.avariel.database.DbHelper;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


/**
 * Created by Gideon Sassoon on 25/03/2017.
 */


@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DatabaseTest extends TestCase {
    DbHelper dbHelper;
    long player;

    Player actualPlayerResult;
    String actualStringResult;
    long actualLongResult;

    @Before
    public void setup() {
        System.out.println("Before Start");
        dbHelper = new DbHelper(InstrumentationRegistry.getTargetContext());
        player = 1;
    }

    @Test
    public void aCreateNewPlayer() {
        try {
            System.out.println("Create new player Start");
            actualLongResult = dbHelper.createNewPlayer(
                    "Gideon",
                    "I am ExMachina",
                    "Human",
                    "Lawful Good",
                    "Edward");
            if (actualLongResult == -1) {
                Log.println(Log.ERROR, "Test createNewPlayer", "Database returned: " + actualLongResult);
                System.exit(-1);
            } else {
                Log.println(Log.INFO, "Test createNewPlayer", "Database returned: " + actualLongResult);
            }
            //Assert.assertThat(newPlayer, Is.<Long>is(IsNot.<Long>not(IsEqual.<Long>equalTo((long) -1))));
            //TODO: Returns: long: the row ID of the newly inserted row, or -1 if an error occurred AN ERROR WAS RETURNED.
        } catch (SQLException e) {
            // Sep 12, 2013 6:50:17 AM
            Log.e("Exception", "SQLException " + String.valueOf(e.getMessage()));
            e.printStackTrace();
        }
    }

    @Test
    public void bGetPlayer() {
        actualPlayerResult = dbHelper.getPlayer(player);
        Log.i("Test getPlayer", "Our player's name is: " + actualPlayerResult.getName());
    }

    public void cPlacePlayerInApp() {
        dbHelper.getPlayer(1);

    }
}
