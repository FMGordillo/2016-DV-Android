package com.example.fmgordillo.clases;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

public class Menu extends AppCompatActivity {

    TabHost tabs;
    Button change;
    Button ABMbtn;
    boolean a = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Inicializacion

        change = (Button) findViewById(R.id.menu_changeColor_btn);
        tabs = (TabHost) findViewById(android.R.id.tabhost);
        ABMbtn = (Button) findViewById(R.id.tabs_3_alta_btn);
        tabs.setup();

        // *** TAB 1
        TabHost.TabSpec spec = tabs.newTabSpec("Color");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Cambiar Color");
        tabs.addTab(spec);

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a) {
                    tabs.getCurrentView().setBackgroundColor(Color.RED);
                } else {
                    tabs.getCurrentView().setBackgroundColor(Color.BLUE);
                }
                a = !a;
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
        spec.setIndicator("TAB3");
        tabs.addTab(spec);
        ABMbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, ABM.class));
            }
        });

        tabs.setCurrentTab(0);

    }
}
