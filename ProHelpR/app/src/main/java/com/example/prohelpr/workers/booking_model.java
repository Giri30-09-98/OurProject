package com.example.prohelpr.workers;

import android.widget.TextView;

public class booking_model {
    String w_name,w_category,charge,contact;

    public booking_model() {
    }

    public String getW_name() {
        return w_name;
    }

    public void setW_name(String w_name) {
        this.w_name = w_name;
    }

    public String getW_category() {
        return w_category;
    }

    public void setW_category(String w_category) {
        this.w_category = w_category;
    }
    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }



    public booking_model(String w_name, String w_category, String charge, String contact) {
        this.w_name = w_name;
        this.w_category = w_category;
        this.charge = charge;
        this.contact = contact;

    }
}

