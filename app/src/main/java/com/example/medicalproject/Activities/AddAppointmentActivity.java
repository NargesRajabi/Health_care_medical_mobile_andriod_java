package com.example.medicalproject.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.medicalproject.R;

public class AddAppointmentActivity extends AppCompatActivity {

    //bellow I explain page views to use in Java code
    private ImageView img_back;
    private TextView txt_reservation_status;
    private CheckBox chb_reservation;
    private LinearLayout layout_reserves_patient;


    Boolean isReserved = false;
   //in this Boolean , appointment reservation situation will be save

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_appointment);
        initViews();
    }
   //bellow, with Id, find views and connected to before variables
    private void initViews() {
        layout_reserves_patient = findViewById(R.id.layout_reserves_patient);
        txt_reservation_status = findViewById(R.id.txt_reservation_status);
        chb_reservation = findViewById(R.id.chb_reservation);
        img_back = findViewById(R.id.img_back);

        //each time that will click on CheckBox , save it's situation and update the page
        chb_reservation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            //for CheckBox, put OnCheckedChangeListener to inform or return the situation of CheckBox

            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                isReserved = checked;
                UpdateUi(isReserved);

            }
        });
        //یک ان کلیک برای فلش بالای صفحه گذاشتیم که با کلیک روش متد خود اندروید برای برگشت به صفحه قبلی فراخوانی شود
       //put OnClick for page that with click on it , with android method , will back to previous page
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    //when use checkBox , text in reservation_status is equal reserve and the color get green
    //also show layout which should get the information of reserved patient
    private void UpdateUi(Boolean isReserved){
        if (isReserved){
            txt_reservation_status.setText("Reserved");
            txt_reservation_status.setTextColor(Color.rgb(10,218,3));
            layout_reserves_patient.setVisibility(View.VISIBLE);

            //when Not use checkBox , text in reservation_status is equal NOT reserve and the color get red and hidden the layout
        }else{
            txt_reservation_status.setText("Not Reserved");
            txt_reservation_status.setTextColor(Color.RED);
            layout_reserves_patient.setVisibility(View.GONE);
        }
    }
}