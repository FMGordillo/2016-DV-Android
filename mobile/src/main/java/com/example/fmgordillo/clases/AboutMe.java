package com.example.fmgordillo.clases;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AboutMe extends AppCompatActivity {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_aboutme);

        correo = prefs.getString("email", "por_defecto@email.com");
        editor.putString("email", "modificado@email.com");
        editor.putString("nombre", "Prueba");
        editor.commit();


    }

    private void inicializar() {
        prefs = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }
}
