package org.baltimorecityschools.restaurantappbs;

public class Tibs {
    // 1. Instance variables
    private String name;
    private String size;
    private String extra;
    private int quantity;
    private double basePrice;


    // 2. Default constructor
    public Tibs() {
        name = "Tibs";
        size = "Regular";
        extra = "No Extra";
        quantity = 1;
        basePrice = 0.00;

}



    // 3. Pass-through constructor
    public Tibs(String newName, String newSize, String newExtra, int newQuantity, double newBasePrice) {
        name = newName;
        size = newSize;
        extra = newExtra;
        quantity = newQuantity;
        basePrice = newBasePrice;
    }

    // 4a. Getters

    public String getName() {
        return name;
    }
    public double getBasePrice() {

        return basePrice;
    }
    public String getSize() {
        return size;
    }
    public String getExtra() {
        return extra;
    }
    public int getQuantity() {
        return quantity;
    }


    // 4b. Setters

    public void setName(String newName) {
        name = newName;
    }

    public void setSize(String newSize) {
        size = newSize;
    }

    public void setExtra(String newExtra) {
        extra = newExtra;
    }

    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }


    @Override
    public String toString() {

        return name + " " + size + " " + extra + " Quantity: " + quantity;
    }
}



















