package com.example.gideonsassoon.avariel.database;

import android.app.Activity;
import android.util.Log;

import com.example.gideonsassoon.avariel.datamodels.Player;
import com.example.gideonsassoon.avariel.ui.MainFragmentActivity;

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


    public RealmManager() {



        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Log.i("Avariel REALM", "Before Create object");

        Player player = realm.createObject(Player.class);
        Log.i("Avariel REALM", "After Create object");
        player = player.create(01, "Gideon", "Barlock", "Orc", "Lawful Evil", "Fighter", "A wandering Warrior", 0, 30, 0, null, null, null, null, null, null, null, null, null, 0);
        Log.i("Avariel REALM", "After Create Player");
        realm.commitTransaction();
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }

    public void savePlayer(Player player) {
        Player player2 = realm.copyToRealm((player));

    }
    public void queryPlayer(String key, String value){
        // https://realm.io/docs/java/latest/#queries
        RealmQuery<Player> query = realm.where(Player.class);
        query.equalTo("playerName","Gideon");
        query.or().equalTo(key, value);
        RealmResults<Player> result1 = query.findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Player player  = realm.createObject(Player.class);
                player.setCurrentHP(26);
                player.setAlignment("Lawful Evil");
            }
        });
        //Player player = result1.where().equalTo(key, value).or().equalTo("playerName", "Gideon").findFirst();
    }
}
