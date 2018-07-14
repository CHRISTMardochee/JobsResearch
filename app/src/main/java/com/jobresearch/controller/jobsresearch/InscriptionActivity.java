package com.jobresearch.controller.jobsresearch;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class InscriptionActivity extends AppCompatActivity {
    private EditText txtEmail;
    private EditText txtPwd;
    private FirebaseAuth firebaseAuth;
    private Button btnInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        txtEmail = (EditText) findViewById(R.id.editTextEmail);
        txtPwd = (EditText) findViewById(R.id.editTextPassword);
        btnInscription=findViewById(R.id.btnInscription);
        firebaseAuth = FirebaseAuth.getInstance();

        btnInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPwd.getText().toString().trim();
                if (email.isEmpty()|| password.isEmpty()) {
                    Toast.makeText(InscriptionActivity.this, "Champs obligatoires....", Toast.LENGTH_LONG).show();
                    return;
                }else {
                    final ProgressDialog progressDialog = ProgressDialog.show(InscriptionActivity.this, getString(R.string.waiting), "En cours...", true);
                    (firebaseAuth.createUserWithEmailAndPassword(txtEmail.getText().toString(), txtPwd.getText().toString()))
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressDialog.dismiss();
                                    if (task.isSuccessful()) {
                                        Toast.makeText(InscriptionActivity.this, getString(R.string.success_inscription), Toast.LENGTH_LONG).show();
                                        Intent i = new Intent(InscriptionActivity.this, ConnexionActivity.class);
                                        startActivity(i);
                                    } else {
                                        Log.e(getString(R.string.error_inscription), task.getException().toString());
                                        Toast.makeText(InscriptionActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                }

                            });
                }

            }
        });
    }



    public void inscription_Click() {


    }

}



