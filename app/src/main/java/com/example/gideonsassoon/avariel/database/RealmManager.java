package com.example.gideonsassoon.avariel.database;

import android.app.Activity;
import android.util.Log;

import com.example.gideonsassoon.avariel.datamodels.Player;
import com.example.gideonsassoon.avariel.ui.MainFragmentActivity;

import java.util.Random;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Gideon Sassoon on 16/05/2017.
 */
public class RealmManager extends Activity {

    public static final String TAG = MainFragmentActivity.class.getName();
    private Realm realm;
    public Player player;

    public RealmManager(Realm realm) {
        this.realm = realm;
        createSetPlayer();
        //updatePlayer();

        //Player playerQuerhy = queryPlayer("playerName", "Gideon");
        //playerQuerhy.setCurrentHP(53);
    }

    public void savePlayer(Player player) {
        Player player2 = realm.copyToRealm((player));
    }


    public void createSetPlayer() {
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
        realm.beginTransaction();
        Player player = realm.createObject(Player.class, new Random().nextInt());
        player = Player.create(player, "Lola", "The Gravekeeper", "Human", "Lawful Good", "Fighter", "A wandering Warrior", 0, 30, 0, null, null, null, null, null, null, null, null, null, 0);
        player.setName("Gideon Edward");
        realm.commitTransaction();
     /*   try {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Log.i("Avariel REALM SET", "Before create object");
                    Player player = realm.createObject(Player.class);
                    player.setCurrentHP(37);
//                    Player.create(new Random().nextInt(), "Lola", "The Gravekeeper", "Human", "Lawful Evil", "Fighter", "A wandering Warrior", 0, 30, 0, null, null, null, null, null, null, null, null, null, 0);

                    Log.i("Avariel REALM SET", "after create object");

                }
            });
        } catch (Exception e) {
            Log.e("REALM SET PLAYER ERROR", e.toString());
        }*/
    }

    public void updatePlayer() {
        realm = Realm.getDefaultInstance();
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
        try {
            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    Log.i("Avariel REALM QUERY", "on execute");
                    player.setCurrentHP(44);
                    realm.copyToRealmOrUpdate(player);
                    player.setAlignment("Lawful Evil");
                    Log.i("Avariel REALM QUERY", "after setting");
                }
            });
        } catch (Exception e) {
            Log.e("REALM QUERY CATCH", e.toString());
        }
    }

    public Player queryPlayer(String key, String value) {
        // https://realm.io/docs/java/latest/#queries
        realm = Realm.getDefaultInstance();
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
        realm.beginTransaction();
        RealmQuery<Player> query = realm.where(Player.class);
        query.equalTo("playerName", "Gideon");
        query.or().equalTo(key, value);
        RealmResults<Player> result1 = query.findAll();
        Log.i("Avariel REALM QUERY", "Before execute");
        return result1.where().equalTo(key, value).or().equalTo("playerName", "Gideon").findFirst();
    }
}
