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
import android.widget.Spinner;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
public class ConnexionActivity extends AppCompatActivity {
    private EditText txtEmail;
    private EditText txtPwd;
    private Button btnCnx;
    private FirebaseAuth firebaseAuth;
    private Spinner type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);


        txtEmail=findViewById(R.id.editTxtEmail);
        txtPwd=findViewById(R.id.editTxtPassword);
        btnCnx=findViewById(R.id.btnCnx);
        firebaseAuth = FirebaseAuth.getInstance();
        type=findViewById(R.id.spinnerType);
        btnCnx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = txtEmail.getText().toString().trim();
                String password = txtPwd.getText().toString().trim();
                String contrat=type.getSelectedItem().toString();
                //Verifie si l'email et le pswd sont vides
                if (email.isEmpty()|| password.isEmpty()) {
                    Toast.makeText(ConnexionActivity.this, "Champs obligatoires....", Toast.LENGTH_LONG).show();
                    return;
                }else if(contrat.equals("Demandeur")){

                    final ProgressDialog progressDialog = ProgressDialog.show(ConnexionActivity.this, "Please wait...", "En cours...", true);

                    (firebaseAuth.signInWithEmailAndPassword(txtEmail.getText().toString(), txtPwd.getText().toString()))
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressDialog.dismiss();

                                    if (task.isSuccessful()) {
                                        Toast.makeText(ConnexionActivity.this, "Connexion réusssie", Toast.LENGTH_LONG).show();
                                        Intent i = new Intent(ConnexionActivity.this, DemandeurActivity.class);
                                        //i.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());
                                        startActivity(i);
                                    } else {
                                        Log.e("ERROR", task.getException().toString());
                                        Toast.makeText(ConnexionActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                    }
                                }
                            });
                }else if(contrat.equals("Recruteur")){

                    final ProgressDialog progressDialog = ProgressDialog.show(ConnexionActivity.this, "Please wait...", "En cours...", true);

                    (firebaseAuth.signInWithEmailAndPassword(txtEmail.getText().toString(), txtPwd.getText().toString()))
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressDialog.dismiss();

                                    if (task.isSuccessful()) {
                                        Toast.makeText(ConnexionActivity.this, "Connexion Réussie", Toast.LENGTH_LONG).show();
                                        Intent i = new Intent(ConnexionActivity.this, RecruteurActivity.class);
                                        startActivity(i);
                                    } else {
                                        Log.e("ERROR", task.getException().toString());
                                        Toast.makeText(ConnexionActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();

                                    }
                                }
                            });
                }else {
                    Toast.makeText(ConnexionActivity.this, "Choisissez votre profil", Toast.LENGTH_LONG).show();

                }

            }
        });
    }

}
