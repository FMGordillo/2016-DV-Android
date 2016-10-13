package com.example.fmgordillo.clases;

import android.app.Activity;
import android.os.Bundle;

import com.example.fmgordillo.clases.resources.SettingsFragment;

public class Settings extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
