package com.jobresearch.controller.jobsresearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListCvActivity extends AppCompatActivity {
    ListView listViewCvs;
    DatabaseReference databaseCv;
    List<Cv>cvs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cv);

        listViewCvs = (ListView) findViewById(R.id.listViewCv);

        databaseCv = FirebaseDatabase.getInstance().getReference("cv");

        //list to store artists
        cvs = new ArrayList<>();
        listViewCvs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
               //recupere le cv selectionné
                Cv cv=cvs.get(i);
                //
                Intent intent=new Intent(getApplicationContext(),ListCvActivity.class);

                startActivity(intent);
            }
        });
    }
    protected void onStart(){
        super.onStart();
        databaseCv.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                cvs.clear();
                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    Cv cv=postSnapshot.getValue(Cv.class);
                    cvs.add(cv);
                }
                CvList cvAdapter=new CvList(ListCvActivity.this,cvs);
                listViewCvs.setAdapter(cvAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
