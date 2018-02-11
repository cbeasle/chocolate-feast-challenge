package com.chocolatestore.delegate;

import com.chocolatestore.domain.BaggedCandy;
import com.chocolatestore.domain.CandyBag;
import com.chocolatestore.domain.PurchasedCandy;

/**
 * Created by cbeasle on 2/10/18.
 */
public class PurchaseCandyImpl implements PurchaseCandy{
    private CandyBag candyBag;
    private int wrappersNeeded;
    private int bonusCandyCount;

    public PurchaseCandyImpl(){
        this.candyBag = new CandyBag();
        this.wrappersNeeded = 0;
        this.bonusCandyCount = 0;

        this.candyBag = new CandyBag();
    }
    public CandyBag getCandyBag(){
        return this.candyBag;
    }

    public void processPurchase(double cash, double purchasePrice, int wrappersNeeded, String purchaseCandyType){
        this.wrappersNeeded = wrappersNeeded;

        candyBag.setPurchasedCandy(new PurchasedCandy(purchaseCandyType,purchasePrice));

        int purchaseCount = (int)( cash / candyBag.getPurchasedCandy().getPrice() );

        BaggedCandy baggedCandyPurchased = candyBag.getBaggedCadies().get(candyBag.getPurchasedCandy().getType());
        baggedCandyPurchased.setBagCount(purchaseCount);

        //run Promotion 1 with the purchased candy
        int promoBonusCount = wrapperPromotion1(baggedCandyPurchased);

        //run Promotion 2 with candy added from promotions until all added types from promos are considered
        BaggedCandy baggedCandyPromo = candyBag.getBaggedCadies().get(candyBag.getPurchasedCandy().getPromoCandyType());
        promoBonusCount = wrapperPromotion2(baggedCandyPromo, promoBonusCount);
        while (promoBonusCount > 0){
            baggedCandyPromo = candyBag.getBaggedCadies().get(baggedCandyPromo.getPromoCandyType());
            promoBonusCount = wrapperPromotion2(baggedCandyPromo, promoBonusCount);
        }
    }

    //Promotion: for every wrappersNeeded number of wrappers, add one chocolate of purchased type to bag for free
    private int wrapperPromotion1(BaggedCandy baggedCandy){
        int bonusCandyCount = 0;
        if (baggedCandy != null) {
            int remainingWrapperCount = baggedCandy.getBagCount();
            while (remainingWrapperCount >= this.wrappersNeeded) {
                baggedCandy.addQuantityToBag(1);
                bonusCandyCount++;
                remainingWrapperCount++;
                remainingWrapperCount -= this.wrappersNeeded;
            }
        }
         return bonusCandyCount;
    }

    //Promotion:
    //  - if baggedCandy provided
    //      * add a promo candy type to bag for every bonus candy
    //      * re-run promotion 1
    //  - otherwise, add nothing to bag and stop
    private int wrapperPromotion2(BaggedCandy baggedCandy, int bonusCandyCount){
        int promoBonusCount = 0;

        if (baggedCandy != null){
            baggedCandy.addQuantityToBag(bonusCandyCount);
            promoBonusCount = wrapperPromotion1(baggedCandy);
        }

        return promoBonusCount;
    }
}
