package com.example.medicalproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.medicalproject.R;

public class AppointmentsListActivity extends AppCompatActivity {

    private ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments_list);
        initViews();
    }
   //with Id, find views and attribute the variables
    private void initViews() {
        img_back = findViewById(R.id.img_back);

        //OnClick for run the android method for backing to previous page

        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}