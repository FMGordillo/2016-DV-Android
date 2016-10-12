package com.example.fmgordillo.clases;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class AboutMe extends Activity {

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
