package com.example.gideonsassoon.avariel.database;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.gideonsassoon.avariel.datamodels.Player;
import com.example.gideonsassoon.avariel.ui.MainFragmentActivity;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Gideon Sassoon on 16/05/2017.
 */
public class RealmManager extends Activity {

    public static final String TAG = MainFragmentActivity.class.getName();
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("Avariel REALM", "I am running Realm Manager's on Create");
        /**
         * https://realm.io/docs/java/latest/#getting-started
         * http://facebook.github.io/stetho/
         * https://github.com/uPhyca/stetho-realm
         * chrome://inspect/#devices
         */
       /* Stetho.initializeWithDefaults(this);
        Realm.init(this);
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());

        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Player player = realm.createObject(Player.class);
        player = player.create(01, "Gideon", "Barlock", "Orc", "Lawful Evil", "Fighter", "A wandering Warrior", 0, 30, 0, null, null, null, null, null, null, null, null, null, 0);
        realm.commitTransaction();
        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
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
