package com.example.fmgordillo.clases;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;

public class Menu extends Activity {

    TabHost tabs;
    Button change, stayIdle;
    EditText nombre, edad;
    Button ABMbtn, settingsBtn;
    boolean a = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Inicializacion
        tabs = (TabHost) findViewById(android.R.id.tabhost);
        change = (Button) findViewById(R.id.menu_changeColor_btn);
        stayIdle = (Button) findViewById(R.id.menu_changeColorDefault_btn);
        ABMbtn = (Button) findViewById(R.id.tabs_3_alta_btn);
        settingsBtn = (Button) findViewById(R.id.menu_changeSettings_btn);
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

        stayIdle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabs.getCurrentView().setBackgroundColor(Color.TRANSPARENT);
            }
        });

        // *** TAB 2
        spec = tabs.newTabSpec("ABM");
        spec.setContent(R.id.tab2);
        spec.setIndicator("TAB2");
        ABMbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, ABM.class));
            }
        });
        tabs.addTab(spec);

        // *** TAB 3
        spec = tabs.newTabSpec("About me");
        spec.setContent(R.id.tab3);
        spec.setIndicator("TAB3");
        tabs.addTab(spec);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Settings.class));
            }
        });
        tabs.setCurrentTab(0);

    }
}
