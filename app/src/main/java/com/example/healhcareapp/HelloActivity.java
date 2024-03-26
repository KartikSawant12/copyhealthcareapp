package com.example.healhcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class HelloActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        // Retrieve the title passed from the intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");

        // Set the title text
        TextView titleTextView = findViewById(R.id.textViewHello);
        titleTextView.setText(title);

        // Prepare doctor details based on the title
        String[][] doctorDetails = getDoctorDetails(title);

        // Prepare list data for SimpleAdapter
        ArrayList<HashMap<String, String>> listData = new ArrayList<>();
        for (int i = 0; i < doctorDetails.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("line1", doctorDetails[i][0]);
            item.put("line2", doctorDetails[i][1]);
            item.put("line3", doctorDetails[i][2]);
            item.put("line4", doctorDetails[i][3]);
            item.put("line5", "Cons Fees " + doctorDetails[i][4] + "/-");
            listData.add(item);
        }

        // Create SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(
                this,
                listData,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.Line_a, R.id.Line_b, R.id.Line_c, R.id.Line_d, R.id.Line_e}
        );

        // Set the adapter to the ListView
        ListView listView = findViewById(R.id.listViewHello);
        listView.setAdapter(simpleAdapter);

        // Set onClickListener for Back button
        Button backButton = findViewById(R.id.buttonHelloBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to FindDoctorActivity
                startActivity(new Intent(HelloActivity.this, FindDoctorActivity.class));
            }
        });
    }

    // Method to retrieve doctor details based on the title
    private String[][] getDoctorDetails(String title) {
        // Add your doctor details arrays here based on different titles
        // For simplicity, I'll just return a sample array
        return new String[][]{
                {"Doctor Name: John Doe", "Specialty: General Physician", "Address: ABC Hospital", "Phone: 1234567890", "Consultation Fee: $50"},
                {"Doctor Name: Jane Smith", "Specialty: Dentist", "Address: XYZ Dental Clinic", "Phone: 9876543210", "Consultation Fee: $80"}
        };
    }
}
