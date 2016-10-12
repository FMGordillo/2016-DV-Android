package com.example.fmgordillo.clases;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fmgordillo.clases.resources.DBErrors;

public class ABM extends Activity {

    SQLiteDatabase db;
    ABM_DB usdbh;
    ActionBar actionBar;
    Cursor c;
    EditText code, name;
    TextView lista;
    Button insertBtn, deleteBtn, updateBtn; // Alta | Baja | Modificacion | Consulta
    String onInsertTxt, onUpdateTxt, onDeleteTxt,
            notificacionOK, notificacionErr,
            codeCursor, nameCursor;
    String[] campos;
    ContentValues nuevoRegistro;
    StringBuilder sb = new StringBuilder();
    long result; // Check DB Operation result
    Toast notification; // Inform the user the result

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs_abm);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //Initialization ¡¡NO BORRAR!!
        inicializar();

        // INSERT CASE
        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codeTxt = code.getText().toString();
                if (codeTxt.isEmpty() || codeTxt.equals("")) {
                    check(100L, onInsertTxt);
                    System.out.println(result);
                } else {
                    nuevoRegistro.put("codigo", code.getText().toString());
                    nuevoRegistro.put("nombre", name.getText().toString());
                    result = db.insert("Usuarios", null, nuevoRegistro);
                    check(0L, onInsertTxt);
                }
                startActivity(new Intent(ABM.this, ABM.class));
            }
        });

        // UPDATE CASE
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codeTxt = code.getText().toString();
                if (codeTxt.isEmpty() || codeTxt.equals("")) {
                    check(100L, onInsertTxt);
                } else {
                    nuevoRegistro.put("nombre", name.getText().toString());
                    result = db.update("Usuarios", nuevoRegistro,
                            "codigo=".concat(code.getText().toString()), null);
                    check(0L, onUpdateTxt);
                }
                startActivity(new Intent(ABM.this, ABM.class));
            }
        });

        // DELETE CASE
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codeTxt = code.getText().toString();
                if (codeTxt.isEmpty() || codeTxt.equals("")) {
                    check(100L, onInsertTxt);
                } else {
                    result = db.delete("Usuarios",
                            "codigo=".concat(code.getText().toString()), null);
                    check(0L, onDeleteTxt);
                }
                startActivity(new Intent(ABM.this, ABM.class));
            }
        });
    }

    // BACK TO HOME Button
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // FIXME Fix the handling of errors in SQLite
    private void check(Long result, String resultado) {
        if (result == 0L) {
            Toast.makeText(ABM.this,
                    notificacionOK + " " + resultado,
                    Toast.LENGTH_SHORT).show();
        } else {
            sb.append(notificacionErr);
            sb.append(" ");
            sb.append(result);
            sb.append(" ");
            sb.append(DBErrors.getResultTxyByNumber(result));

            Toast.makeText(ABM.this, sb.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private void inicializar() {

        nuevoRegistro = new ContentValues();
        lista = (TextView) findViewById(R.id.tabs_2_abm_list);

        usdbh = new ABM_DB(this, "DBUsuarios", null, 1);
        db = usdbh.getWritableDatabase();

        campos = new String[]{"codigo", "nombre"};
        c = db.query("Usuarios", campos, null, null, null, null, null);
        fillList(c);

        code = (EditText) findViewById(R.id.tabs_2_abm_insert_code);
        name = (EditText) findViewById(R.id.tabs_2_abm_insert_username);
        insertBtn = (Button) findViewById(R.id.tabs_2_abm_insert_btn);
        updateBtn = (Button) findViewById(R.id.tabs_2_abm_update_btn);
        deleteBtn = (Button) findViewById(R.id.tabs_2_abm_delete_btn);
        onInsertTxt = getResources().getString(R.string.onInsert);
        onUpdateTxt = getResources().getString(R.string.onUpdate);
        onDeleteTxt = getResources().getString(R.string.onDelete);
        notificacionOK = getResources().getString(R.string.tabs_2_abm_notification_OK);
        notificacionErr = getResources().getString(R.string.tabs_2_abm_notification_ERR);
    }

    private void fillList(Cursor c) {
        lista.setText("");
        if (c.moveToFirst()) {
            do {
                codeCursor = c.getString(0);
                nameCursor = c.getString(1);
                lista.append(codeCursor + " | " + nameCursor + "\n");
            } while (c.moveToNext());
        }
    }

    /* --- DATOS APARTE!!!!

     //Eliminar un registro con execSQL(), utilizando argumentos
     String[] args = new String[]{"usuario1"};
     db.execSQL("DELETE FROM Usuarios WHERE nombre=?", args);

     //Actualizar dos registros con update(), utilizando argumentos
     ContentValues valores = new ContentValues();
     valores.put("nombre","usunuevo");

     String[] args = new String[]{"usuario1", "usuario2"};
     db.update("Usuarios", valores, "nombre=? OR nombre=?", args);

     */
}
