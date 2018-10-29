package com.hoonstudio.springbootstarter.topic;

public class Location {
    private String country;

    public Location(String country) {
        this.country = country;
    }

    public Location() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
