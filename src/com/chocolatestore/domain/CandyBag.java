package com.chocolatestore.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cbeasle on 2/9/18.
 */
public class CandyBag {
    private HashMap<CandyType,BaggedCandy> baggedCandies;
    PurchasedCandy purchasedCandy;
    private List<CandyType> displayOrder;

    public CandyBag() {
        this.baggedCandies = new HashMap<CandyType,BaggedCandy>();
        baggedCandies.put(CandyType.MILK,new BaggedCandy(CandyType.MILK));
        baggedCandies.put(CandyType.DARK,new BaggedCandy(CandyType.DARK));
        baggedCandies.put(CandyType.WHITE,new BaggedCandy(CandyType.WHITE));
        baggedCandies.put(CandyType.SUGAR_FREE,new BaggedCandy(CandyType.SUGAR_FREE));

        this.displayOrder = new ArrayList<CandyType>();
        this.displayOrder.add(CandyType.MILK);
        this.displayOrder.add(CandyType.DARK);
        this.displayOrder.add(CandyType.WHITE);
        this.displayOrder.add(CandyType.SUGAR_FREE);
    }

    public String displayBag(){
        StringBuilder display =  new StringBuilder();

        for (CandyType type : this.displayOrder) {
            display.append(type.value());
            display.append(" ");
            display.append(this.baggedCandies.get(type).getBagCount());
            display.append(", ");
        }

        //remove unnecessary concatenation sequence at the end of the string
        display.setLength(display.length()-2);

        return display.toString();
    }

    //getters and setters
    public HashMap<CandyType,BaggedCandy> getBaggedCadies(){
        return baggedCandies;
    }

    public BaggedCandy getBagCandy(CandyType type){
        if (type != null){
            return this.baggedCandies.get(type);
        } else {
            return null;
        }
    }

    public PurchasedCandy getPurchasedCandy() {
        return purchasedCandy;
    }
    public void setPurchasedCandy(PurchasedCandy purchasedCandy) {
        this.purchasedCandy = purchasedCandy;
    }

}
