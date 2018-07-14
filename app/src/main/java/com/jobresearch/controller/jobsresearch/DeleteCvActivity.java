package com.jobresearch.controller.jobsresearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteCvActivity extends AppCompatActivity {
    EditText txtNm;
    EditText txtPn;
    EditText email;
    EditText adr;
    EditText ci;
    EditText tel;
    EditText obj;
    EditText fmt;
    EditText cpt;
    Button btnDelete;

    DatabaseReference databaseCv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_delete_cv);
        txtNm = (EditText) findViewById(R.id.txtNmS);
        txtPn = (EditText) findViewById(R.id.txtPnS);
        email = (EditText) findViewById(R.id.emailS);
        adr = (EditText) findViewById(R.id.adrS);
        ci = (EditText) findViewById(R.id.ciS);
        tel = (EditText) findViewById(R.id.telS);
        obj = (EditText) findViewById(R.id.objS);
        fmt = (EditText) findViewById(R.id.fmtS);
        cpt=findViewById(R.id.cptS);

        btnDelete=findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id =databaseCv.push().getKey();
                deleteCv(id);
            }
        });


    }




    private boolean deleteCv(String id) {
        //getting the specified Cv reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("cv").child(id);
        //removing Cv
        dR.removeValue();
        Toast.makeText(this, "Votre cv a été bien supprimé", Toast.LENGTH_SHORT).show();

        return true;
    }
}
