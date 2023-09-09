package com.example.resumebuilding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Year;
import java.util.HashMap;

public class CertificationsDetails extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("certifications");
private EditText name,desc,year;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certifications_details);
        name = findViewById(R.id.cName);
        desc = findViewById(R.id.cDescription);
        year = findViewById(R.id.cYear);
        submit = findViewById(R.id.Save);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names =name.getText().toString();
                String descs = desc.getText().toString();
                String years = year.getText().toString();


                if (names.isEmpty()) {
                    name.setError("Name cannot be empty");
                } else if (descs.isEmpty()) {
                    desc.setError("Email cannot be empty");
                } else if (years.isEmpty()) {
                    year.setError("Phone number cannot be empty");

                } else {
                    String key = databaseReference.child("details").push().getKey(); // Generate a unique key for each entry

                    DatabaseReference userRef = databaseReference.child("details").child(key);

                    HashMap<String, String> usermap = new HashMap<>();
                    usermap.put("name", names);
                    usermap.put("desc",descs );
                    usermap.put("year", years);


                    userRef.setValue(usermap);
                    Toast.makeText(CertificationsDetails.this, "Certification details stored successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}