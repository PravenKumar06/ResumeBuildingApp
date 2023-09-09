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

public class ProjectDetails extends AppCompatActivity {


        EditText name,desc,durat;

        Button submit;


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference(" project");


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_project_details);

            name = findViewById(R.id.pname);
            desc = findViewById(R.id.pdescription);
            durat = findViewById(R.id.PDuration);

            submit = findViewById(R.id.buttonSave);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String names = name.getText().toString();
                    String emails = desc.getText().toString();
                    String phones = durat.getText().toString();
                    String adds = submit.getText().toString();

                    if (names.isEmpty()) {
                        name.setError("Name cannot be empty");
                    } else if (emails.isEmpty()) {
                        desc.setError("Email cannot be empty");
                    } else if (phones.isEmpty()) {
                        durat.setError("Phone number cannot be empty");
                    } else if (adds.isEmpty()) {
                        submit.setError("Address cannot be empty");
                    } else {
                        String key = databaseReference.child("details").push().getKey(); // Generate a unique key for each entry

                        DatabaseReference userRef = databaseReference.child("details").child(key);

                        HashMap<String, String> usermap = new HashMap<>();
                        usermap.put("name", names);
                        usermap.put("desc", emails);
                        usermap.put("dur", phones);


                        userRef.setValue(usermap);
                        Toast.makeText(ProjectDetails.this, "Project details stored successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
            });
        }
    }

