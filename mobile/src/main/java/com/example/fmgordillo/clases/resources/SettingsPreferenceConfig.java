package com.example.fmgordillo.clases.resources;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import com.example.fmgordillo.clases.R;

import java.util.Locale;

/**
 * Created by facundomg on 13/10/16.
 */

public class SettingsPreferenceConfig extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {

    public static final String PREF_LANGUAGE = "language_pref";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(PREF_LANGUAGE)) {
            Preference connectionPref = findPreference(key);
            connectionPref.setSummary(sharedPreferences.getString(key, ""));
            changeLanguagePref(sharedPreferences.getString(key, ""));
        }
    }

    private void changeLanguagePref(String lang) {
        Locale locale = null;
        if (lang.equals("Spanish")) {
            locale = new Locale("SPA");//("zh_rTW");
        } else if (lang.equals("English")) {
            locale = new Locale("ENG");//("zh_rCN");
        } else {
            locale = new Locale("SPA");
        }
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
    }

    //languagePreference.setOnPreferenceChangeListener

}
