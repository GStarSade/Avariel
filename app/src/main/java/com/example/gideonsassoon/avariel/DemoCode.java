package com.example.gideonsassoon.avariel;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Gideon Sassoon on 07/01/2017.
 * A set of examples used to build this app, these things may no longer be used.
 */

public class DemoCode extends MainActivity {


    private void AssetStreamTxt() {
        AssetManager assetManager = getAssets();
        InputStream descriptor = null;
        String result = null;
        try {
            descriptor = assetManager.open("hello.txt");
            System.out.println(descriptor.toString());
            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                // Stream is read into the buffer
                br = new BufferedReader(new InputStreamReader(descriptor));
                // Line is then read
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        // Buffered reader is closed (For some reason it is a try-catch block)
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                result = sb.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }
}

