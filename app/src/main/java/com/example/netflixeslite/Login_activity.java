package com.example.netflixeslite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_activity extends AppCompatActivity {
    // set content variabel
    EditText username,password;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.android_email);
        password = (EditText) findViewById(R.id.pass_et);
        btnLogin = (Button)findViewById(R.id.btn_order);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if (usernameKey.equals("admin") && passwordKey.equals("123")){
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login_activity.this, Home.class);
                    startActivity(intent);
                }else {
                    //jika login gagal
                    Toast.makeText(getApplicationContext(), "LOGIN FAILED",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

    }
}