package com.example.mediguide;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;

public class DashBoard extends AppCompatActivity {

    CardView drug_ineraction_crd , interaction_info_card , dose_indication_crd , disease_info_crd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("Dashboard");

        drug_ineraction_crd = findViewById(R.id.drug_interaction_card);
        interaction_info_card = findViewById(R.id.interactions_info_card);
        dose_indication_crd = findViewById(R.id.dose_indication_card);
        disease_info_crd = findViewById(R.id.disease_info_card);



        drug_ineraction_crd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoard.this, Interaction_screen_activity.class ));
                finish();
            }
        });

        dose_indication_crd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoard.this, Dose_indication.class));
                finish();
            }
        });

        disease_info_crd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoard.this, Disease_Info_Activity.class));
                finish();
            }
        });

        interaction_info_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashBoard.this , Interactions_info.class));
                finish();
            }
        });




    }
}