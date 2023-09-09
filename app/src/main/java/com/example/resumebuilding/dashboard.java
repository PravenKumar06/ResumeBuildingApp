package com.example.resumebuilding;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboard extends AppCompatActivity {
    Button btnNewResume,btnPreviewResume,btnDownloadResume,btnExit,btnBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btnNewResume=findViewById(R.id.btnNewResume);
        btnPreviewResume=findViewById(R.id.btnPreviewResume);
        btnDownloadResume=findViewById(R.id.btnDownloadResume);
        btnExit=findViewById(R.id.btnExit);
        btnBack=findViewById(R.id.Back);
        btnNewResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ResumeSection.class);
                startActivity(intent);
                finish();
            }
        });

        btnDownloadResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this,DownloadResume.class);
                startActivity(intent);

            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this,MainActivity.class);
                startActivity(intent);

            }
        });
        btnPreviewResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dashboard.this,PreviewActivity.class);
                startActivity(intent);

            }
        });
    }
}