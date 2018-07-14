package com.jobresearch.controller.jobsresearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CvActivity extends AppCompatActivity {
    public static final String CV_NAME = "com.jobresearch.controller.jobsresearch.nom";
    public static final String CV_ID = "com.jobresearch.controller.jobsresearch.id";

    EditText txtNm;
    EditText txtPn;
    EditText email;
    EditText adr;
    EditText ci;
    EditText tel;
    EditText obj;
    EditText fmt;
    EditText cpt;
    Button btnAdd;

    DatabaseReference databaseCv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cv);


       // getting the reference of cv node

        databaseCv = FirebaseDatabase.getInstance().getReference("cv");

        //getting views
        txtNm = (EditText) findViewById(R.id.txtNm);
        txtPn = (EditText) findViewById(R.id.txtPn);
        email = (EditText) findViewById(R.id.email);
        adr = (EditText) findViewById(R.id.adr);
        ci = (EditText) findViewById(R.id.ci);
        tel = (EditText) findViewById(R.id.tel);
        obj = (EditText) findViewById(R.id.obj);
        fmt = (EditText) findViewById(R.id.fmt);
        cpt=findViewById(R.id.cpt);

        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             addCv();
            }
        });


    }

    private void addCv(){
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
                !TextUtils.isEmpty(objectif)|| !TextUtils.isEmpty(formation) || !TextUtils.isEmpty(competence)){


            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our CV
            String id =databaseCv.push().getKey();


            //Creation de  l'objet CV
            Cv cv =new Cv(id,nom,prenom,mail,adresse,cdi,phone,objectif,formation,competence);

            //Sauvegarde
            databaseCv.child(id).setValue(cv);



            //Vider les champs

            txtNm.setText("");
            txtPn.setText("");
            email.setText("");
            adr.setText("");
            ci.setText("");
            tel.setText("");
            obj.setText("");
            fmt.setText("");
            cpt.setText("");
            Toast.makeText(this, "Votre CV aété bien crée", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Champs obligatoires", Toast.LENGTH_LONG).show();
        }
    }


}

