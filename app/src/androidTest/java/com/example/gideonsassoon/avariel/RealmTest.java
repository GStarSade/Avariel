package com.example.gideonsassoon.avariel;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.gideonsassoon.avariel.database.RealmManager;
import com.example.gideonsassoon.avariel.datamodels.Player;

import junit.framework.TestCase;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

/**
 * Created by Gideon Sassoon on 21/05/2017.
 */
@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RealmTest extends TestCase {

    RealmManager realmManager;
    Player player;
    Player actualPlayerResult;
    String actualStringResult;
    long actualLongResult;

    @BeforeClass
    public static void setup() {
        System.out.println("Before Start /r/n, Welcome to the Doom Room!");
        Log.i("TEST_START", "Before Start /r/n, Welcome to the Doom Room!");
    }

    @Test
    public void aCreateNewPlayer() {
        try {
            realmManager = new RealmManager();
            player = new Player();
            player = player.create(01, "Gideon", "Barlock", "Orc", "Lawful Evil", "Fighter", "A wandering Warrior", 0, 30, 0, null, null, null, null, null, null, null, null, null, 0);
            realmManager.savePlayer(player);
            Log.i("REALM", realmManager.toString());
        } catch (Exception e) {
            // Sep 12, 2013 6:50:17 AM
            Log.e("Exception", "RealmException " + String.valueOf(e.getMessage()));
            e.printStackTrace();
        }
    }

    @Test
    public void bGetPlayer() {
        //actualPlayerResult = Result here;
        realmManager.queryPlayer("playerName", "Gideon");
        Log.i("REALM Test getPlayer", "Our player's name is: " + actualPlayerResult.getName());
    }

    public void cPlacePlayerInApp() {


    }
}
