package com.example.medicalproject.Models;

public class AppointmentModel {

  // with this class AppointmentModel, we fill appointment list and it's information

    public AppointmentModel() {
    }

    public AppointmentModel(int id, int is_reserved, String day, String month, String year, String description) {
        this.id = id;
        this.is_reserved = is_reserved;
        this.day = day;
        this.month = month;
        this.year = year;
        this.description = description;
    }

    private int id;
    private int is_reserved;
    // 1 = reserved , 0 = not reserved
    private String day,month,year,description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIs_reserved() {
        return is_reserved;
    }

    public void setIs_reserved(int is_reserved) {
        this.is_reserved = is_reserved;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AppointmentModel{" +
                "  id=" + id +
                ", is_reserved=" + is_reserved +
                ", day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
