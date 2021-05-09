package com.example.prohelpr.workersProfiles;

public class WorkersDatabase {

    String role;
    String w_name;
    String w_contact;
    String w_address;
    String w_place;
    String w_category;
    String w_postalcode;
    String w_amount;
    String w_status;





    public String getW_name() {
        return w_name;
    }

    public void setW_name(String w_name) {
        this.w_name = w_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getW_contact() {
        return w_contact;
    }

    public void setW_contact(String w_contact) {
        this.w_contact = w_contact;
    }

    public String getW_address() {
        return w_address;
    }

    public void setW_address(String w_address) {
        this.w_address = w_address;
    }

    public String getW_status() {
        return w_status;
    }

    public void setW_status(String w_status) {
        this.w_status = w_status;
    }

    public String getW_amount() {
        return w_amount;
    }

    public void setW_amount(String w_amount) {
        this.w_amount = w_amount;
    }

    public String getW_postalcode() {
        return w_postalcode;
    }

    public void setW_postalcode(String w_postalcode) {
        this.w_postalcode = w_postalcode;
    }

    public String getW_place() {
        return w_place;
    }

    public void setW_place(String w_place) {
        this.w_place = w_place;
    }

    public String getW_category() {
        return w_category;
    }

    public void setW_category(String w_category) {
        this.w_category = w_category;
    }

    public WorkersDatabase(String role,String w_name,String w_contact,String w_address,String w_place,String w_category,String w_postalcode,String w_amount,String w_status) {
        this.w_name = w_name;
        this.role = role;
        this.w_contact = w_contact;
        this.w_address = w_address;
        this.w_status = w_status;
        this.w_amount = w_amount;
        this.w_postalcode = w_postalcode;
        this.w_place = w_place;
        this.w_category = w_category;
    }


    public WorkersDatabase(){

    }

}
