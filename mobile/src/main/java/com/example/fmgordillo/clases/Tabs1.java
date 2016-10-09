package com.example.fmgordillo.clases;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by FMGordillo on 08/10/16.
 */

public class Tabs1 extends AppCompatActivity {

    Button cambiarColor, volver;
    LinearLayout view;
    boolean a = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_1_color);

        cambiarColor = (Button) findViewById(R.id.tabs_1_color_btn_cambiar);
        volver = (Button) findViewById(R.id.tabs_1_color_btn_volver);
        view = (LinearLayout) findViewById(R.id.tabs_1_color_view);

        cambiarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (a) {
                    view.setBackgroundColor(Color.RED);
                } else {
                    view.setBackgroundColor(Color.BLUE);
                }

                a = !a;
            }
        });
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Tabs1.this, Menu.class));
            }
        });

    }
}
