package com.example.healhcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));

            }
        });
        CardView familyphysician = findViewById(R.id.cardFDFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindDoctorActivity.this, HelloActivity.class);
                startActivity(intent);
            }
        });


        CardView dietician = findViewById(R.id.cardFDDieatician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new  Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dietician");
                startActivity(it);
            }
        });

        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new  Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dentist");
                startActivity(it);
            }
        });

        CardView surgean = findViewById(R.id.cardFDSurgean);
        surgean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new  Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Surgean");
                startActivity(it);
            }
        });

        CardView cardiologists = findViewById(R.id.cardFDCardiologists);
        cardiologists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new  Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                it.putExtra("title","Cardiologists");
                startActivity(it);
            }
        });
    }
}