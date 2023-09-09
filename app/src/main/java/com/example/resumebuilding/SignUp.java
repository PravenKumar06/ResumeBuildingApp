package com.example.resumebuilding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resumebuilding.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SignUp extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("user");
    private FirebaseAuth auth;
    private EditText username,name,phone,db;
    private EditText pass,conpass;
    private Button loginButton;
    private TextView loginrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        auth=FirebaseAuth.getInstance();
        conpass=findViewById(R.id.c_password);
        username=findViewById(R.id.email);
        pass=findViewById((R.id.password));
        loginButton=findViewById((R.id.button));
        phone=findViewById(R.id.phone);
        loginrt=findViewById(R.id.loginrt);
        name=findViewById(R.id.name);
        db=findViewById(R.id.date);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String password=pass.getText().toString();
                String n=name.getText().toString();
                String d=db.getText().toString();
                String p=phone.getText().toString();
                String c=conpass.getText().toString();
                if(n.isEmpty()) {
                    name.setError("name cannot be empty");
                }
                else if(user.isEmpty())
                {
                    username.setError("email cannot be empty");
                }
                else if(p.isEmpty())
                {
                    phone.setError("phone number cannot be empty");
                }
                else if(d.isEmpty())
                {
                    db.setError("Date of birth cannot be empty");
                }
                else if(password.isEmpty())
                {
                    pass.setError("password cannot be empty");
                }
                else if(c.isEmpty())
                {
                    conpass.setError("password cannot be empty");
                }
                else if (!password.equals(c))
                {
                    Toast.makeText(SignUp.this,"Passwords are not matching",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(p)) {
                                Toast.makeText(SignUp.this, "Phone number is already registered", Toast.LENGTH_SHORT).show();
                            } else {
                                DatabaseReference userRef = databaseReference.child("users").child(p);

                                HashMap<String, String> usermap = new HashMap<>();
                                usermap.put("name", n);
                                usermap.put("email", user);
                                usermap.put("date of birth", d);
                                usermap.put("phone number", p);
                                usermap.put("password", password);

                                userRef.setValue(usermap);
                                Toast.makeText(SignUp.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                            // Handle any errors that occur
                            Toast.makeText(SignUp.this, "Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

                    auth.createUserWithEmailAndPassword(user,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            FirebaseUser user=auth.getCurrentUser();
                            if(task.isSuccessful())
                            {
                                Toast.makeText(SignUp.this,"Signup succesfull",Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(SignUp.this, MainActivity.class));
                            }
                            else
                            {
                                Toast.makeText(SignUp.this,"SignUp failed",Toast.LENGTH_SHORT).show();
                                Toast.makeText(SignUp.this,"login successful" +task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                            }
                        }
                    });


                }

            }
        });
        loginrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this,MainActivity.class));
                finish();
            }
        });
    }

}