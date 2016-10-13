package com.example.fmgordillo.clases.resources;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ABM_DB extends SQLiteOpenHelper {

    private String sqlCreate = "CREATE TABLE Usuarios (codigo INTEGER NOT NULL, nombre TEXT)";
    private String sqlDelete = "DROP TABLE IF EXISTS Usuarios";

    public ABM_DB(Context contexto, String nombre,
                  SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(sqlDelete);
        db.execSQL(sqlCreate);
    }

}
