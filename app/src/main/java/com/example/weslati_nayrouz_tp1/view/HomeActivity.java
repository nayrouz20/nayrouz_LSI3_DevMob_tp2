package com.example.weslati_nayrouz_tp1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.weslati_nayrouz_tp1.R;
import com.example.weslati_nayrouz_tp1.controller.LoginController;

public class HomeActivity extends AppCompatActivity {

    private Button btnConsultation;

    private EditText etUserName;
    private EditText etPassword;
    private LoginController loginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();

        etUserName.setText(loginController.getUserName());
        etPassword.setText(loginController.getPassword());
        btnConsultation = (Button) findViewById(R.id.btnConsultation);
        btnConsultation.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                String userName, password;
                boolean verifUserName = false, verifPassword = false;

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if(!etUserName.getText().toString().isEmpty())
                        verifUserName = true;
                    else
                        Toast.makeText(HomeActivity.this, "Veuillez saisir votre nom d'utilisateur !", Toast.LENGTH_SHORT).show();
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    if(!etPassword.getText().toString().isEmpty())
                        verifPassword = true;
                    else
                        Toast.makeText(HomeActivity.this, "Veuillez saisir votre mot de passe !", Toast.LENGTH_LONG).show();
                }

                if(verifPassword && verifUserName) {
                    userName = etUserName.getText().toString();
                    password = etPassword.getText().toString();
                    loginController.createUser(userName, password, HomeActivity.this);
                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
            }
        });
    }

    private void init()
    {
        loginController = LoginController.getInstance(HomeActivity.this);
        btnConsultation = (Button) findViewById(R.id.btnConsultation);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etUserName = (EditText) findViewById(R.id.etUserName);
    }

}