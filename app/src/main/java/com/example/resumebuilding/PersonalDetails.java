package com.example.resumebuilding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class PersonalDetails extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("personal");

    private EditText name, email, add, phone;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        name = findViewById(R.id.pname);
        email = findViewById(R.id.pemailpe);
        phone = findViewById(R.id.pphone);
        add = findViewById(R.id.paddress);
        submit = findViewById(R.id.perBtn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = name.getText().toString();
                String emails = email.getText().toString();
                String phones = phone.getText().toString();
                String adds = add.getText().toString();

                if (names.isEmpty()) {
                    name.setError("Name cannot be empty");
                } else if (emails.isEmpty()) {
                    email.setError("Email cannot be empty");
                } else if (phones.isEmpty()) {
                    phone.setError("Phone number cannot be empty");
                } else if (adds.isEmpty()) {
                    add.setError("Address cannot be empty");
                } else {
                    String key = databaseReference.child("details").push().getKey(); // Generate a unique key for each entry

                    DatabaseReference userRef = databaseReference.child("details").child(key);

                    HashMap<String, String> usermap = new HashMap<>();
                    usermap.put("name", names);
                    usermap.put("email", emails);
                    usermap.put("phone", phones);
                    usermap.put("address", adds);

                    userRef.setValue(usermap);
                    Toast.makeText(PersonalDetails.this, "Personal details stored successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}
