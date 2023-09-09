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

public class ExperienceDetails extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("experiences");
private EditText name,comp,dur;
Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_details);
        name = findViewById(R.id.eTitle);
        comp = findViewById(R.id.eCompany);
        dur = findViewById(R.id.eDuration);
        submit = findViewById(R.id.Save);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names =name.getText().toString();
                String comps = comp.getText().toString();
                String durs = dur.getText().toString();


                if (names.isEmpty()) {
                    name.setError("Title cannot be empty");
                } else if (comps.isEmpty()) {
                    comp.setError("Name cannot be empty");
                } else if (durs.isEmpty()) {
                    dur.setError("Duration cannot be empty");

                } else {
                    String key = databaseReference.child("details").push().getKey(); // Generate a unique key for each entry

                    DatabaseReference userRef = databaseReference.child("details").child(key);

                    HashMap<String, String> usermap = new HashMap<>();
                    usermap.put("name", names);
                    usermap.put("comp",comps );
                    usermap.put("dur", durs);


                    userRef.setValue(usermap);
                    Toast.makeText(ExperienceDetails.this, "experience details stored successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}