package com.example.gideonsassoon.avariel.ui;

import android.os.Environment;
import android.util.Log;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by scorchgid on 29/08/17.
 */
public class MainActivityTest {
    @Test
    public void realmExport() throws Exception {
         MainActivity mainActivity = new MainActivity();
         mainActivity.realmInit();
         mainActivity.realmExport();

        File exportRealmFile = null;
        try {
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                exportRealmFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "export2.realm");
                Log.i("Avariel File Delete", "Checking if File exists");
                if (exportRealmFile.exists())
                    Log.i("Avariel File Delete", "File detected");
                try {
                    exportRealmFile.delete();
                    if (!exportRealmFile.exists())
                        Log.i("Avariel File Delete", "File deleted");
                    else
                        Log.e("Avariel File Delete", "File still exists!");
                } catch (
                        Exception e) {
                    e.printStackTrace();
                }
                mainActivity.realm.writeCopyTo(exportRealmFile);
                if(exportRealmFile.exists())
                    Log.i("Avariel File Delete", "new File created");
                else{
                    Log.e("Avariel File Delete", "new File was not created");
                }
            } else {
                throw new RuntimeException("Unable to mount External Storage for R+W");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}