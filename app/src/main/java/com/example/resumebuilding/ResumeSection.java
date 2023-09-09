package com.example.resumebuilding;

import static com.example.resumebuilding.R.id.Back;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResumeSection extends AppCompatActivity {
    Button btnPer,btnEdu,btnCer,btnPro,btnExp,btnSav,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_section);
        btnCer=(Button) findViewById(R.id.btnCertifications);
        btnExp=(Button) findViewById(R.id.btnExperience);
        btnEdu=(Button) findViewById(R.id.btnEducation);
        btnPer=(Button) findViewById(R.id.btnPersonalDetails);
        btnPro=(Button)findViewById(R.id.btnProjects);
        btnSav=(Button) findViewById(R.id.save);
        btnBack=(Button)findViewById(R.id.Back);
        btnPer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResumeSection.this,PersonalDetails.class);
                startActivity(intent);

            }
        });
        btnEdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResumeSection.this,EducationDetails.class);
                startActivity(intent);

            }
        });
        btnPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResumeSection.this,ProjectDetails.class);
                startActivity(intent);

            }
        });
        btnCer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResumeSection.this,CertificationsDetails.class);
                startActivity(intent);

            }
        });
        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResumeSection.this,ExperienceDetails.class);
                startActivity(intent);

            }
        });
        btnSav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResumeSection.this,FinalResume.class);
                startActivity(intent);

            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResumeSection.this,dashboard.class);
                startActivity(intent);

            }
        });





    }
}