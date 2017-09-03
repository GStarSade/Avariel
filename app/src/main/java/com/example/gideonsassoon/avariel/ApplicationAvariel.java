package com.example.gideonsassoon.avariel;

import android.app.Application;
import android.os.Bundle;

import com.example.gideonsassoon.avariel.datamodels.Sheet;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.regex.Pattern;

import io.realm.Realm;
import okhttp3.OkHttpClient;

/**
 * Created by scorchgid on 03/09/17.
 */

public class ApplicationAvariel extends Application {

    private Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        realmInit();
    }

    private void realmInit() {
        /**
         * https://realm.io/docs/java/latest/#getting-started
         * http://facebook.github.io/stetho/
         * https://github.com/uPhyca/stetho-realm
         * chrome://inspect/#devices
         *
         * https://stackoverflow.com/a/36531095/1358857 < Exporting Realm table
         */
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                        .build());
        RealmInspectorModulesProvider.builder(this)
                .withFolder(getCacheDir())
                .withMetaTables()
                .withDescendingOrder()
                .withLimit(1000)
                .databaseNamePattern(Pattern.compile(".+\\.realm"))
                .build();
        Stetho.initializeWithDefaults(this);
        Realm.init(this);
        new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        realm = Realm.getDefaultInstance();
    }
}
