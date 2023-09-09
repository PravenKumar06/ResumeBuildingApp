package com.example.resumebuilding;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FinalResume extends AppCompatActivity {
    private TextView certificationTitleTextView;
    private TextView certificationDescriptionTextView;
    private TextView certificationDateTextView;
    private TextView personalNameTextView;
    private TextView personalEmailTextView;
    private TextView personalPhoneTextView;
    private TextView personalAddressTextView;
    private TextView projectTitleTextView;
    private TextView projectDescriptionTextView;
    private TextView projectDurationTextView;
    private TextView educationUniversityTextView;
    private TextView educationDegreeTextView;
    private TextView educationCGPATextView;
    private TextView educationYearTextView;
    private TextView experienceJobTextView;
    private TextView experienceCompanyTextView;
    private TextView experienceDurationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_resume);

        certificationTitleTextView = findViewById(R.id.certificationTitleTextView);
        certificationDescriptionTextView = findViewById(R.id.certificationDescriptionTextView);
        certificationDateTextView = findViewById(R.id.certificationDateTextView);
        personalNameTextView = findViewById(R.id.personalNameTextView);
        personalEmailTextView = findViewById(R.id.personalEmailTextView);
        personalPhoneTextView = findViewById(R.id.personalPhoneTextView);
        personalAddressTextView = findViewById(R.id.personalAddressTextView);
        projectTitleTextView = findViewById(R.id.projectTitleTextView);
        projectDescriptionTextView = findViewById(R.id.projectDescriptionTextView);
        projectDurationTextView = findViewById(R.id.projectDurationTextView);
        educationUniversityTextView = findViewById(R.id.educationUniversityTextView);
        educationDegreeTextView = findViewById(R.id.educationDegreeTextView);
        educationCGPATextView = findViewById(R.id.educationCGPATextView);
        educationYearTextView = findViewById(R.id.educationYearTextView);
        experienceJobTextView = findViewById(R.id.experienceJobTextView);
        experienceCompanyTextView = findViewById(R.id.experienceCompanyTextView);
        experienceDurationTextView = findViewById(R.id.experienceDurationTextView);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

        // Fetch certifications details
        databaseReference.child("certifications").child("details").orderByKey().limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Retrieve the last entered certification details
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Certification certification = snapshot.getValue(Certification.class);
                    // Display the certification details in your activity
                    certificationTitleTextView.setText("Title: " + certification.getName());
                    certificationDescriptionTextView.setText("Description: " + certification.getDesc());
                    certificationDateTextView.setText("Year: " + certification.getYear());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle the error
            }
        });

        // Fetch personal details
        databaseReference.child("personal").child("details").orderByKey().limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Retrieve the last entered personal details
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Personal personal = snapshot.getValue(Personal.class);
                    // Display the personal details in your activity
                    personalNameTextView.setText("Name: " + personal.getName());
                    personalEmailTextView.setText("Email: " + personal.getEmail());
                    personalPhoneTextView.setText("Phone: " + personal.getPhone());
                    personalAddressTextView.setText("Address: " + personal.getAddress());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle the error
            }
        });

        // Fetch project details
        databaseReference.child("project").child("details").orderByKey().limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("Snapshot", dataSnapshot.toString());
                // Retrieve the last entered project details
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    Project project = snapshot.getValue(Project.class);
                    // Display the project details in your activity
                    projectTitleTextView.setText("Project Title: "+project.getName() );
                    projectDescriptionTextView.setText("Project Description: " + project.getDesc());
                    projectDurationTextView.setText("Project Duration: " + project.getDur());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle the error
            }
        });

        // Fetch education details
        databaseReference.child("education").child("details").orderByKey().limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Retrieve the last entered education details
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Education education = snapshot.getValue(Education.class);
                    // Display the education details in your activity
                    educationUniversityTextView.setText("University: " + education.getUniversity());
                    educationDegreeTextView.setText("Degree: " + education.getDegree());
                    educationCGPATextView.setText("CGPA: " + education.getCGPA());
                    educationYearTextView.setText("Year: " + education.getYear());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle the error
            }
        });

        // Fetch experience details
        databaseReference.child("experiences").child("details").orderByKey().limitToLast(1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Retrieve the last entered experience details
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Experience experience = snapshot.getValue(Experience.class);
                    // Display the experience details in your activity
                    experienceJobTextView.setText("Job: " + experience.getName());
                    experienceCompanyTextView.setText("Company: " + experience.getComp());
                    experienceDurationTextView.setText("Duration: " + experience.getDur());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle the error
            }
        });
    }
}
