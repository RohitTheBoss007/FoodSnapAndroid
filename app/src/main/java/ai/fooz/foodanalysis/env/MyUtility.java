package ai.fooz.foodanalysis.env;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import ai.fooz.foodanalysis.MainActivity;

public class MyUtility {

    private static final String LABEL_FILE = "file:///android_asset/labels.txt";
    public static final float PREDICTION_THRESHOLD = (float) 0.60;

    public static String getDateWithFormat(Date dt, String format) {
        SimpleDateFormat df = new SimpleDateFormat(format);
        String formattedDate = df.format(dt);
        return formattedDate;
    }

    public static String toTitleCase(String str) {

        if (str == null) {
            return null;
        }

        boolean space = true;
        StringBuilder builder = new StringBuilder(str);
        final int len = builder.length();

        for (int i = 0; i < len; ++i) {
            char c = builder.charAt(i);
            if (space) {
                if (!Character.isWhitespace(c)) {
                    // Convert to title case and switch out of whitespace mode.
                    builder.setCharAt(i, Character.toTitleCase(c));
                    space = false;
                }
            } else if (Character.isWhitespace(c)) {
                space = true;
            } else {
                builder.setCharAt(i, Character.toLowerCase(c));
            }
        }

        return builder.toString();
    }

    public static int getRandomNumber(int min, int max) {
        Random r = new Random();
        final int random = r.nextInt((max - min) + 1) + min;
        return random;
    }

    public static String getLabels(Context myContext) {

        String actualFilename = LABEL_FILE.split("file:///android_asset/")[1];
        String lbls = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(myContext.getAssets().open(actualFilename)));
            String line;
            while ((line = br.readLine()) != null) {
                lbls = lbls+"\n"+ MyUtility.toTitleCase(line);
            }
            br.close();
            return lbls;
        } catch (IOException e) {
            throw new RuntimeException("Problem reading label file!" , e);
        }
    }

    public static Boolean logFirebaseEvent(FirebaseAnalytics mFirebaseAnalytics, String itemName) {
        Bundle bundle = new Bundle();
//        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, itemName);
//        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        return true;
    }
}
