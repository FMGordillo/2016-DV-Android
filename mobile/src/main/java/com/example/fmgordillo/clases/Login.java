package com.example.fmgordillo.clases;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    Button login;

    TextView userTxt, pwTxt;

    Toast alert;

    String user = "test";
    String pw = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        
        login = (Button) findViewById(R.id.login_btn_accept);
        userTxt = (TextView) findViewById(R.id.login_field_user);
        pwTxt = (TextView) findViewById(R.id.login_field_pw);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* METODO NORMAL
                if (userTxt.getText().toString().equals("") // *** IF IS EMPTY
                        || pwTxt.getText().toString().equals("")) {
                    Toast.makeText(Login.this,
                            "Por favor llene los campos.", Toast.LENGTH_SHORT).show();
                } else if (userTxt.getText().toString().equals(user) // *** IF IS CORRECT
                        && pwTxt.getText().toString().equals(pw)) {
                    startActivity(new Intent(Login.this, Menu.class));
                } else { // *** IF IS INCORRECT
                    Toast.makeText(Login.this,
                            "Datos incorrectos. Vuelva a intentarlo.", Toast.LENGTH_SHORT).show();
                }
                */
                startActivity(new Intent(Login.this, Menu.class));
            }

        });
    }
}
