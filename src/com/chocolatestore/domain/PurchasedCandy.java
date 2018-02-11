package com.chocolatestore.domain;

/**
 * Created by cbeasle on 2/9/18.
 */
public class PurchasedCandy extends Candy {
    private double price;

    public PurchasedCandy(String type, double price) {
        super(type);
        this.setPrice(price);
    }
    public PurchasedCandy(CandyType type, double price) {
        super(type);
        this.setPrice(price);
    }

    //getters and setters
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
