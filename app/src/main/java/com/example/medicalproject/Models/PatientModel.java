package com.example.medicalproject.Models;

public class PatientModel {

    // with this class PatientModel, we fill patients information
    public PatientModel() {
    }

    public PatientModel(int id, String fname, String lname, String appointment_date, String description, String tracking_code) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.appointment_date = appointment_date;
        this.description = description;
        this.tracking_code = tracking_code;
    }

    private int id;
    private String fname,lname,appointment_date,description,tracking_code;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTracking_code() {
        return tracking_code;
    }

    public void setTracking_code(String tracking_code) {
        this.tracking_code = tracking_code;
    }

    @Override
    public String toString() {
        return "PatientModel{" +
                "  id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", appointment_date='" + appointment_date + '\'' +
                ", description='" + description + '\'' +
                ", tracking_code='" + tracking_code + '\'' +
                '}';
    }


}
