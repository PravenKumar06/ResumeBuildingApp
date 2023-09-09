package com.example.resumebuilding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class EducationDetails extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("education");

    private EditText uni,degree,cgpa,year;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_details);
        uni = findViewById(R.id.uni);
        degree = findViewById(R.id.degree);
        cgpa = findViewById(R.id.cgpa);
        year = findViewById(R.id.year);
        submit = findViewById(R.id.eduSave);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unis =uni.getText().toString();
                String degrees = degree.getText().toString();
                String cgpas = cgpa.getText().toString();
                String years = year.getText().toString();

                if (unis.isEmpty()) {
                    uni.setError("Name cannot be empty");
                } else if (degrees.isEmpty()) {
                    degree.setError("Email cannot be empty");
                } else if (cgpas.isEmpty()) {
                    cgpa.setError("Phone number cannot be empty");
                } else if (years.isEmpty()) {
                    year.setError("Address cannot be empty");
                } else {
                    String key = databaseReference.child("details").push().getKey(); // Generate a unique key for each entry

                    DatabaseReference userRef = databaseReference.child("details").child(key);

                    HashMap<String, String> usermap = new HashMap<>();
                    usermap.put("university", unis);
                    usermap.put("degree", degrees);
                    usermap.put("cgpa", cgpas);
                    usermap.put("year", years);

                    userRef.setValue(usermap);
                    Toast.makeText(EducationDetails.this, "Educational details stored successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}