package com.example.glowpadexample;

import android.util.Log;

public class Utils {
    private static final String TAG = "ertewu";
    public static void log(String str) {
        Log.i("ertewu", str);
    }

    public static void footPrint() {
        String msgToPrint = Thread.currentThread().getStackTrace()[3]
                .getMethodName();
        Log.println(Log.INFO, TAG, msgToPrint);
    }
}
