package com.example.medicalproject.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.medicalproject.Models.PatientModel;
import com.example.medicalproject.R;
import com.example.medicalproject.SingletonListPatients;

public class PatientDetailsActivity extends AppCompatActivity {
    //bellow create patient Model
    PatientModel patientModel = new PatientModel();

    //bellow I explain page views to use in Java code
    TextView txt_first_name,txt_last_name,txt_tracking_code,txt_appointment_date,txt_description;
    Button btn_next,btn_prev,btn_change_details;

    //variables for save the patients index
    int index;

    //with bundle we receive the information that was send from toast length from previous page
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);
        Bundle bundle = getIntent().getExtras();
        //receive index that was send from previous class
        index = bundle.getInt("index");
        //with Singlton class , receive patinet list from sent index
        patientModel = SingletonListPatients.getInstance().getPatients().get(index);

        initViews();
        upDateView();
    }
    //bellow, with Id, find views and connected to before variables
    private void initViews() {
        txt_first_name = findViewById(R.id.txt_first_name);
        txt_last_name = findViewById(R.id.txt_last_name);
        txt_tracking_code = findViewById(R.id.txt_tracking_code);
        txt_appointment_date = findViewById(R.id.txt_appointment_date);
        txt_description = findViewById(R.id.txt_description);
        btn_next =findViewById(R.id.btn_next);
        btn_prev =findViewById(R.id.btn_prev);
        btn_change_details =findViewById(R.id.btn_change_details);

        //check that patient is the last one or not
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if it's the last patient
                if (index == SingletonListPatients.getInstance().getPatients().size() - 1) {
                    Toast.makeText(PatientDetailsActivity.this, "No More Patient", Toast.LENGTH_SHORT).show();
              //if not the last one, add in index, and get the patient from list and call update method
                } else {
                    index++;
                    patientModel = SingletonListPatients.getInstance().getPatients().get(index);
                    upDateView();
                }
            }
        });
       //check if the patient is the first one or not
        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if the first one
                if (index == 0) {
                    Toast.makeText(PatientDetailsActivity.this, "No More Patient", Toast.LENGTH_SHORT).show();
                    //if not the first one, subtract 1 from index and get patient form list and call update page method
                } else {
                    index--;
                    patientModel = SingletonListPatients.getInstance().getPatients().get(index);
                    upDateView();

                }
            }
        });

        btn_change_details.setOnClickListener(new View.OnClickListener() {
            @Override
            //intent to update page of patient and send patient index
            public void onClick(View view) {
                Intent intent = new Intent(PatientDetailsActivity.this,AddPatientActivity.class);
                intent.putExtra("index",index);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", index);
        Log.i("dfgdfgdfgfg", "dgdfdgdf");
    }

   //get the patient information and set in text view
    private void upDateView(){
        txt_first_name.setText(patientModel.getFname());
        txt_last_name.setText(patientModel.getLname());
        txt_tracking_code.setText(patientModel.getTracking_code());
        txt_appointment_date.setText(patientModel.getAppointment_date());
        txt_description.setText(patientModel.getDescription());
    }
}