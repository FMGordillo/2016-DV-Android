package com.example.fmgordillo.clases;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class Menu extends AppCompatActivity {

    Resources res;
    TabHost tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        res = getResources();

        tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        // *** TAB 1
        TabHost.TabSpec spec = tabs.newTabSpec("MiTab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("TAB1");
        tabs.addTab(spec);

        // *** TAB 2
        spec = tabs.newTabSpec("MiTab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("TAB2");
        tabs.addTab(spec);

        // *** TAB 3
        spec = tabs.newTabSpec("UnaTabMas");
        spec.setContent(R.id.tab3);
        spec.setIndicator("TAB1");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

    }
}
