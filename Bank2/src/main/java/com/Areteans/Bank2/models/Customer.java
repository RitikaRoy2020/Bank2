package com.Areteans.Bank2.models;

public class Customer {
    private String firstName;

    public Customer(String firstName) {
        this.firstName = firstName;
    }

    public Customer() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


}
