package com.atguigu.spring.beans.autowire;

public class Address {

    private String city;
    private String street;

    public Address() {
        System.out.println("Address constor..");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void init_method(){
        System.out.println("init_method...");
    }

    public void destroy_method(){
        System.out.println("destroy_method...");
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
