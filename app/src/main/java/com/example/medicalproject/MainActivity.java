package com.example.medicalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.medicalproject.Activities.AddAppointmentActivity;
import com.example.medicalproject.Activities.AddPatientActivity;
import com.example.medicalproject.Activities.AppointmentsListActivity;
import com.example.medicalproject.Activities.PatientsListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //these 4 methods are from xml and call by OnClick method
    public void PatientsList(View view) {
        Intent intent = new Intent(MainActivity.this, PatientsListActivity.class);
        startActivity(intent);
        //  with Intent , we enter to patientList class
    }

    public void AppointmentsList(View view) {
        Intent intent = new Intent(MainActivity.this, AppointmentsListActivity.class);
        startActivity(intent);
        //  with Intent , we enter to AppointmentsList class
    }

    public void AddPatient(View view) {
        Intent intent = new Intent(MainActivity.this, AddPatientActivity.class);
        startActivity(intent);
        // with Intent , we enter to AddPatient class
    }

    public void AddAppointment(View view) {
        Intent intent = new Intent(MainActivity.this, AddAppointmentActivity.class);
        startActivity(intent);
        // with Intent , we enter to AddPatient class
    }
}