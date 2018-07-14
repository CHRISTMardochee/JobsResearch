package com.jobresearch.controller.jobsresearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class OffreActivity extends AppCompatActivity {
    Spinner spinnerSecteur;
    EditText fonction;
    EditText lieu;
    EditText type;
    EditText poste ;
    EditText profil ;

    Button btnAdd;

    DatabaseReference databaseOffre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offre);

        // getting the reference of cv node

        databaseOffre = FirebaseDatabase.getInstance().getReference("offre");

        //getting views
        spinnerSecteur=findViewById(R.id.spinnerSecteur);
        fonction=findViewById(R.id.fonction);
        lieu=findViewById(R.id.lieu);
        type=findViewById(R.id.type);
        poste=findViewById(R.id.poste);
        profil=findViewById(R.id.profil);
        btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                addOffre();
            }
        });
    }
    private void addOffre(){
        String secteur=spinnerSecteur.getSelectedItem().toString();
        String fn=fonction.getText().toString().trim();
        String location=lieu.getText().toString().trim();
        String contrat=type.getText().toString().trim();
        String level=poste.getText().toString().trim();
        String pf=profil.getText().toString().trim();

        if(!TextUtils.isEmpty(fn) || !TextUtils.isEmpty(location) || !TextUtils.isEmpty(contrat)||
                !TextUtils.isEmpty(level) || !TextUtils.isEmpty(pf)){

                //getting a unique id using push().getKey() method
                //it will create a unique id and we will use it as the Primary Key for our CV
                String id=databaseOffre.push().getKey();

                //Creation de l'objet
                Offre offre=new Offre(id,secteur,fn,contrat,level,pf,location);

                //Sauvegarde de la base de donnée
                databaseOffre.child(id).setValue(offre);
                //Vider les champs
                fonction.setText("");
                lieu.setText("");
                type.setText("");
                poste.setText("");
                profil.setText("");

        Toast.makeText(this, "Votre offre a été bien publié", Toast.LENGTH_LONG).show();

    }else{
        Toast.makeText(this, "Champs obligatoires", Toast.LENGTH_LONG).show();
    }



    }
}
