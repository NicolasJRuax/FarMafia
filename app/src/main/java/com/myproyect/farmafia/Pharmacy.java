package com.myproyect.farmafia;


import java.io.Serializable;

public class Pharmacy implements Serializable {
    private String name;
    private String phone;
    private double latitude;
    private double longitude;

    public Pharmacy() {
        // Required for Firestore
    }

    public Pharmacy(String name, String phone, double latitude, double longitude) {
        this.name = name;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
