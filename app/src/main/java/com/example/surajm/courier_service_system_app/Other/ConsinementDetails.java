package com.example.surajm.courier_service_system_app.Other;

/**
 * Created by Suraj m on 25-01-2017.
 */

public class ConsinementDetails {

    String reqId,companyname,date,pickupStatus,paymentStatus,amount;

    public ConsinementDetails(String reqId, String companyname, String date, String pickupStatus, String paymentStatus, String amount) {
        this.reqId = reqId;
        this.companyname = companyname;
        this.date = date;
        this.pickupStatus = pickupStatus;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReqId() {
        return reqId;
    }

    public String getDate() {
        return date;
    }

    public String getPickupStatus() {
        return pickupStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPickupStatus(String pickupStatus) {
        this.pickupStatus = pickupStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}
