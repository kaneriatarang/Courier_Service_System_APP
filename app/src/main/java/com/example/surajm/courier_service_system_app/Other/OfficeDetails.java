package com.example.surajm.courier_service_system_app.Other;

/**
 * Created by Suraj m on 23-01-2017.
 */

public class OfficeDetails {
    String companyName,branchName,contectNumber,address,pincode;
    double latitude,longitude;

    public OfficeDetails(String companyName, String branchName, String contectNumber, String address, String pincode, double latitude, double longitude) {
        this.companyName = companyName;
        this.branchName = branchName;
        this.contectNumber = contectNumber;
        this.address = address;
        this.pincode = pincode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getContectNumber() {
        return contectNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPincode() {
        return pincode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
