package com.service.backend.BK.Pojo;

import com.google.gson.Gson;

public class Address {

    private String country;
    private String state;
    private String city;
    private String adress1;
    private String note;
    private String cap;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdress1() {
        return adress1;
    }

    public void setAdress1(String adress1) {
        this.adress1 = adress1;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String toDocumentFormat(Address address){
        return new Gson().toJson(address);
    }
    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", City='" + city + '\'' +
                ", adress1='" + adress1 + '\'' +
                ", adress2='" + note + '\'' +
                ", cap='" + cap + '\'' +
                '}';
    }
}
