package com.example.fmgordillo.clases;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class Menu extends AppCompatActivity {

    Resources res;
    TabHost tabs;
    Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        res = getResources();

        change = (Button) findViewById(R.id.menu_changeColor_btn);
        tabs = (TabHost) findViewById(android.R.id.tabhost);
        tabs.setup();

        // *** TAB 1
        TabHost.TabSpec spec = tabs.newTabSpec("Color");
        spec.setContent(R.id.tab1);
        spec.setIndicator("TAB1");
        tabs.addTab(spec);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Tabs1.class));
            }
        });

        // *** TAB 2
        spec = tabs.newTabSpec("ABM");
        spec.setContent(R.id.tab2);
        spec.setIndicator("TAB2");
        tabs.addTab(spec);

        // *** TAB 3
        spec = tabs.newTabSpec("About me");
        spec.setContent(R.id.tab3);
        spec.setIndicator("TAB1");
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

    }
}
