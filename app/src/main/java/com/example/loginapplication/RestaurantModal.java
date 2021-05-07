package com.example.loginapplication;

public class RestaurantModal {

    // variables for our first name,
    // last name, email and avatar
    private String restaurant_name;
    private String phone_number;
    private String address;
    private String latitude;
    private String longitude;
    private String web_source;
    private String diet_tags;
    private String image_URL;

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getWeb_source() {
        return web_source;
    }

    public void setWeb_source(String web_source) {
        this.web_source = web_source;
    }

    public String getDiet_tags() {
        return diet_tags;
    }

    public void setDiet_tags(String diet_tags) {
        this.diet_tags = diet_tags;
    }

    public String getImage_URL() {
        return image_URL;
    }

    public void setImage_URL(String image_URL) {
        this.image_URL = image_URL;
    }

    public RestaurantModal(String restaurant_name, String phone_number, String address, String latitude,
                           String longitude, String web_source, String diet_tags, String image_URL) {
        this.restaurant_name = restaurant_name;
        this.phone_number = phone_number;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.web_source = web_source;
        this.diet_tags = diet_tags;
        this.image_URL = image_URL;

    }
}
