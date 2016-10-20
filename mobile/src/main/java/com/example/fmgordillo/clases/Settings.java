package com.example.fmgordillo.clases;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

import com.example.fmgordillo.clases.resources.SettingsPreferenceConfig;

import java.util.Locale;

public class Settings extends Activity {

    public static void updateLanguage(Context context, String selectedLanguage) {
        if (!"".equals(selectedLanguage)) {
            if ("English".equals(selectedLanguage)) {
                selectedLanguage = "en";
            } else if ("Traditional Chinese".equals(selectedLanguage)) {
                selectedLanguage = "zh";
            }
            Locale locale = new Locale(selectedLanguage);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.locale = locale;
            context.getResources().updateConfiguration(config, null);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Locale locale = new Locale("ENG");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());

        SettingsPreferenceConfig prefFragment = new SettingsPreferenceConfig();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, prefFragment);
        fragmentTransaction.commit();
    }
}
