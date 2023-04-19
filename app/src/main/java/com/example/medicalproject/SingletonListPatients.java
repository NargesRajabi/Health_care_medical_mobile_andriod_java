package com.example.medicalproject;

import com.example.medicalproject.Models.PatientModel;

import java.util.ArrayList;


// این کلاس یک کلاس سینگلتون می باشد
//  این کلاس تنها یک بار نیو میشود(ازش  ان شیی ساخته میشود) و برای اسفاده های بعدی از همان شی ساخته شده قبلی استفاده میشود چون ان را ذخیره میکند
// ما در این کلاس یه لیست از بیمار ها درست کردیم که فقط یک بار ساخته میشود و در کل پروژه به همین کلاس دسترسی داریم
    // In this class we create list of patients  that create just once and will save and add and remove
    //By using a Singleton, we can ensure that these resources are only created once
    //and can be accessed throughout the application.
public class SingletonListPatients {
    private static SingletonListPatients mInstance;
    private ArrayList<PatientModel> patients = null;

    public static SingletonListPatients getInstance() {
        if (mInstance == null)
            mInstance = new SingletonListPatients();
        return mInstance;
    }

    private SingletonListPatients() {
        patients = new ArrayList<PatientModel>();
    }
    public ArrayList<PatientModel> getPatients() {
        // return the patients list
        return this.patients;
    }
    public void addToPatients(PatientModel value) {
        // add patient to the list
        patients.add(value);
    }

    public void replacePatient(int index, PatientModel value) {
        //  we delete the previous patient information and add the new information
        patients.remove(index);
        patients.add(index, value);
    }
}


