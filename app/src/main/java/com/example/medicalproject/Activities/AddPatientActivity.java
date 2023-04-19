package com.example.medicalproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.medicalproject.Models.PatientModel;
import com.example.medicalproject.R;
import com.example.medicalproject.SingletonListPatients;

  //this page is for updating the patients and also add new patient to the list
//bellow I put page views for using in Java code
public class AddPatientActivity extends AppCompatActivity {
    private ImageView img_back;
    private Spinner spn_appointment_date;
    private ArrayAdapter<String> spinnerAdapter;
    private EditText edt_first_name, edt_last_name, edt_tracking_code, edt_description;
    private Button btn_submit;

    //bellow create variable for save the update patient information
    int UpdatingIndex;
    // bellow this variable is for save the page usability that is for updating or Not
    Boolean isUpdating = false;

    //bellow create patient Model (empty patient model)
    PatientModel patientModel = new PatientModel();

    //variables for save the patients information
    String first_name, last_name, tracking_code, description;

    @Override
    //with bundle we receive the information that was send from previous page
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient);
        initViews();

        Bundle bundle = getIntent().getExtras();
        //if bundle exist, we use this page for update patient , so the information that was send here will be set in edit text
        if (bundle != null) {
            UpdatingIndex = bundle.getInt("index");
            isUpdating = true;
            patientModel = SingletonListPatients.getInstance().getPatients().get(UpdatingIndex);
            edt_first_name.setText(patientModel.getFname());
            edt_last_name.setText(patientModel.getLname());
            edt_tracking_code.setText(patientModel.getTracking_code());
            edt_description.setText(patientModel.getDescription());
            btn_submit.setText("Update");
        }


    }
    //with use of Id, find views and put in variables
    private void initViews() {
        edt_first_name = findViewById(R.id.edt_first_name);
        edt_last_name = findViewById(R.id.edt_last_name);
        edt_tracking_code = findViewById(R.id.edt_tracking_code);
        edt_description = findViewById(R.id.edt_description);
        img_back = findViewById(R.id.img_back);
        spn_appointment_date = findViewById(R.id.spn_appointment_date);

       //OnClick for run the android method for backing to previous page
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
     //for spinner use adapter to set the available appointment date(free space)
     //to chose one of them (it's not create the structure of appointment time! just in default I add text and set adapter for spinner
     //spinner is like menu that give list of options to chose just one option, after chose, text of that option will set on spinner
        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAdapter.add("Chose an Appointment Date");
        spn_appointment_date.setAdapter(spinnerAdapter);

      //for this Button I put OnClick to call one of these method, base on our use
        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isUpdating) {
                    UpdatePatient();
                } else {
                    SavePatient();
                }
            }
        });

    }
    //get from edit text and set in string
    private void UpdatePatient() {
        first_name = edt_first_name.getText().toString();
        last_name = edt_last_name.getText().toString();
        tracking_code = edt_tracking_code.getText().toString();
        description = edt_description.getText().toString();
     //if each edit text is empty , send or toast them to fill the information in it
        if (first_name.isEmpty()) {
            Toast.makeText(this, "Please enter your first name", Toast.LENGTH_SHORT).show();
        }
        if (last_name.isEmpty()) {
            Toast.makeText(this, "Please enter your last name", Toast.LENGTH_SHORT).show();
        }
        if (tracking_code.isEmpty()) {
            Toast.makeText(this, "Please enter your tracking code", Toast.LENGTH_SHORT).show();
        }
        //if there is no edit text is empty, create object from Singleton class
        //use updating method to create updated patient information and back to previous page
        if (!first_name.isEmpty() && !last_name.isEmpty() && !tracking_code.isEmpty()) {
            SingletonListPatients patients = SingletonListPatients.getInstance();
            patients.replacePatient(UpdatingIndex, new PatientModel(patients.getPatients().size() + 1, first_name, last_name, "unknown", description, tracking_code));
            Toast.makeText(this, "Patient Updated", Toast.LENGTH_SHORT).show();
            edt_first_name.setText("");
            edt_last_name.setText("");
            edt_tracking_code.setText("");
            edt_description.setText("");
            Intent intent = new Intent(AddPatientActivity.this, PatientDetailsActivity.class);
            intent.putExtra("index", UpdatingIndex);
            startActivity(intent);
            finish();
        }
    }
      //get from edit text and set in string
    private void SavePatient() {
         first_name = edt_first_name.getText().toString();
         last_name = edt_last_name.getText().toString();
         tracking_code = edt_tracking_code.getText().toString();
         description = edt_description.getText().toString();

        //if each edit text is empty , send or toast them to fill the information in it
        if (first_name.isEmpty()) {
            Toast.makeText(this, "Please enter your first name", Toast.LENGTH_SHORT).show();
        }
        if (last_name.isEmpty()) {
            Toast.makeText(this, "Please enter your last name", Toast.LENGTH_SHORT).show();
        }
        if (tracking_code.isEmpty()) {
            Toast.makeText(this, "Please enter your tracking code", Toast.LENGTH_SHORT).show();
        }
        //if there is no edit text is empty, create object from Singleton class
        //use add patient method to add patient information and after that edit text will be empty
        if (!first_name.isEmpty() && !last_name.isEmpty() && !tracking_code.isEmpty()) {
            SingletonListPatients patients = SingletonListPatients.getInstance();
            patients.addToPatients(new PatientModel(patients.getPatients().size() + 1, first_name, last_name, "unknown", description, tracking_code));
            Toast.makeText(this, "Patient Added", Toast.LENGTH_SHORT).show();
            edt_first_name.setText("");
            edt_last_name.setText("");
            edt_tracking_code.setText("");
            edt_description.setText("");
        }

    }
    //override the OnBackPressed method to change when edit here to be able back to that class
    // send the patient update index and if not , get back to previous page with default android method
    @Override
    public void onBackPressed() {
        if (isUpdating) {
            Intent intent = new Intent(AddPatientActivity.this, PatientDetailsActivity.class);
            intent.putExtra("index", UpdatingIndex);
            startActivity(intent);
            finish();
        } else {
            super.onBackPressed();
        }

    }
}