package com.example.fmgordillo.clases.resources;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.fmgordillo.clases.R;

/**
 * Created by facundomg on 13/10/16.
 */

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}
