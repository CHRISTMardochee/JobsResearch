package com.jobresearch.controller.jobsresearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DemandeurActivity extends AppCompatActivity {
    ImageView add;
    ImageView update;
    ImageView list;
    ImageView delete;
    TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demandeur);
        add=findViewById(R.id.addO);
        update=findViewById(R.id.updateO);
        list=findViewById(R.id.listO);
        delete=findViewById(R.id.deleteO);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
       // tvEmail.setText(getIntent().getExtras().getString("Email"));

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DemandeurActivity.this, CvActivity.class);
                startActivity(i);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DemandeurActivity.this, ListCvActivity.class);
                startActivity(i);

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DemandeurActivity.this, UpdateCv.class);
                startActivity(i);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DemandeurActivity.this, DeleteCvActivity.class);
                startActivity(i);

            }
        });

    }
}
