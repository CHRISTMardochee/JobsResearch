package com.jobresearch.controller.jobsresearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecruteurActivity extends AppCompatActivity {
    ImageView add;
    ImageView update;
    ImageView list;
    ImageView delete;
    TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recruteur);

        add = findViewById(R.id.addR);
        update = findViewById(R.id.updateR);
        list = findViewById(R.id.listR);
        delete = findViewById(R.id.deleteR);
        //tvEmail = (TextView) findViewById(R.id.tvEmail);
       // tvEmail.setText(getIntent().getExtras().getString("Email"));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecruteurActivity.this, OffreActivity.class);
                startActivity(i);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RecruteurActivity.this, ListOffreActivity.class);
                startActivity(i);
            }
        });
    }
}
