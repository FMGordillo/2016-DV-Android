package com.example.fmgordillo.clases;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutMe extends Activity {

    TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_aboutme);

        inicializar();

    }

    private void inicializar() {
        description = (TextView) findViewById(R.id.aboutme_description);
    }
}
