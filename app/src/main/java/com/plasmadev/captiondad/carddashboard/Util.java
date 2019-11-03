package com.plasmadev.captiondad.carddashboard;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import javax.annotation.Nullable;

public class Util {
    private static HashMap<String, Bitmap> onlineAssets = new HashMap<>();

    @Nullable
    private static Bitmap getBitmapFromURL(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            return BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    static Bitmap findOrCreateBy(String url) {
        if (onlineAssets.containsKey(url)) return onlineAssets.get(url);
        else {
            Bitmap b = getBitmapFromURL(url);
            onlineAssets.put(url, b);
            return b;
        }
    }
}
