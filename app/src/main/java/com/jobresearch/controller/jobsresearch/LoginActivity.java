package com.jobresearch.controller.jobsresearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_login);
    }
    public void inscription_Click(View v){
        Intent i = new Intent(LoginActivity.this, InscriptionActivity.class);
        startActivity(i);

    }
    public void connexion_Click(View v){
        Intent i = new Intent(LoginActivity.this,ConnexionActivity.class);
        startActivity(i);

    }
}
