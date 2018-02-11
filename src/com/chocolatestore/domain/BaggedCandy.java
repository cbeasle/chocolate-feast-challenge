package com.chocolatestore.domain;

/**
 * Created by cbeasle on 2/9/18.
 */
public class BaggedCandy extends Candy {
    private int bagCount;

    public BaggedCandy(String type){
        super(type);
        this.setBagCount(0);
    }
    public BaggedCandy(CandyType type){
        super(type);
        this.setBagCount(0);
    }

    public void addQuantityToBag(int qty){
        this.bagCount += qty;
    }

    //getters and setters
    public int getBagCount() {
        return bagCount;
    }

    public void setBagCount(int bagCount) {
        this.bagCount = bagCount;
    }

}
