package com.example.medicalproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.medicalproject.Models.PatientModel;
import com.example.medicalproject.R;
import com.example.medicalproject.SingletonListPatients;

import java.util.ArrayList;

public class PatientsListActivity extends AppCompatActivity {
    //bellow I explain page views to use in Java code
    private ImageView img_back;
    ListView list_patient;

    TextView txt_no_patient;
     //create patient name list
    ArrayList<String> patientsName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patients_list);
        initViews();
    }
    //bellow, with Id, find views and connected to before variables
    private void initViews() {
        txt_no_patient = findViewById(R.id.txt_no_patient);
        img_back = findViewById(R.id.img_back);
        list_patient = findViewById(R.id.list_patient);

        //put OnClick for page that with click on it , with android method , will back to previous page
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
       //create ForLoop, for each patient in list in Singleton class will add it
        for (PatientModel patient: SingletonListPatients.getInstance().getPatients()) {
            patientsName.add(patient.getFname() + " " + patient.getLname());
            // یه حلقه ساختیم که به ازای هر بیمار در لیست اطلیمون در کلاس سینگلتون یه بار اجرا مبشه و اسم بیمار رو به لیست اسم بیمارا اظافه میکنه
        }
        //if list doesn't empty, hide the text view that wtitten on it "there is no patient in the list"
        if (patientsName.size() > 0){
            txt_no_patient.setVisibility(View.GONE);
            //else , show the text view
        }else{
            txt_no_patient.setVisibility(View.VISIBLE);
        }


        list_patient.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,patientsName));
        // از اداپتر دیفالت برای لیستمون استفاده کردیم که فقط اسم بیمار رو در یک لیست نشون بدیم در این اداپتر از ویوی دیفالت خود اندروید استفاده کردیم
        list_patient.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(PatientsListActivity.this,PatientDetailsActivity.class);
                intent.putExtra("index",i);
                startActivity(intent);
            }
        });
        // ان ایتم کلیک گذاشتیم که وقتی روی اسم بیمارا کلیک شد صفحه اطلاعات بیمار رو باز کنیم و ایندکس بیمار رو به اون صفحه بفرستیم

    }
}