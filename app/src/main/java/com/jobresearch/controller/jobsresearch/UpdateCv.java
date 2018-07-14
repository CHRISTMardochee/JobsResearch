package com.jobresearch.controller.jobsresearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateCv extends AppCompatActivity {
    EditText txtNm;
    EditText txtPn;
    EditText email;
    EditText adr;
    EditText ci;
    EditText tel;
    EditText obj;
    EditText fmt;
    EditText cpt;
    Button btnUpdate;

    DatabaseReference databaseCv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cv);
        txtNm = (EditText) findViewById(R.id.txtNmU);
        txtPn = (EditText) findViewById(R.id.txtPnU);
        email = (EditText) findViewById(R.id.emailU);
        adr = (EditText) findViewById(R.id.adrU);
        ci = (EditText) findViewById(R.id.ciU);
        tel = (EditText) findViewById(R.id.telU);
        obj = (EditText) findViewById(R.id.objU);
        fmt = (EditText) findViewById(R.id.fmtU);
        cpt=findViewById(R.id.cptU);
        btnUpdate=findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom=txtNm.getText().toString().trim();
                String prenom=txtPn.getText().toString().trim();
                String mail=email.getText().toString().trim();
                String adresse=adr.getText().toString().trim();
                String cdi=ci.getText().toString().trim();
                String phone=tel.getText().toString().trim();
                String objectif=obj.getText().toString().trim();
                String formation=fmt.getText().toString().trim();
                String competence=cpt.getText().toString().trim();

                if(!TextUtils.isEmpty(nom)|| !TextUtils.isEmpty(prenom) || !TextUtils.isEmpty(mail)
                        || !TextUtils.isEmpty(adresse)|| !TextUtils.isEmpty(cdi) || !TextUtils.isEmpty(phone)||
                        !TextUtils.isEmpty(objectif)|| !TextUtils.isEmpty(formation) || !TextUtils.isEmpty(competence)) {

                    //getting a unique id using push().getKey() method
                    //it will create a unique id and we will use it as the Primary Key for our CV
                    String id =databaseCv.push().getKey();

                    updateCv(id,nom,prenom,mail,adresse,cdi,phone,objectif,formation,competence);


                }
            }
        });
    }

    private boolean updateCv(String id,String nom, String prenom,String adresse,String mail,String cdi,String phone,String objectif,String formation,String competence) {
        //getting the specified cv reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("cv").child(id);

        //updating cv
        Cv cv = new Cv(id,nom,prenom,mail,adresse,cdi,phone,objectif,formation,competence);
        dR.setValue(cv);
        Toast.makeText(getApplicationContext(), "Votre Cv a été bien mise à jour", Toast.LENGTH_LONG).show();
        return true;
    }
}
