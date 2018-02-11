package com.chocolatestore.delegate;

import com.chocolatestore.domain.CandyBag;

/**
 * Created by cbeasle on 2/10/18.
 */
public interface PurchaseCandy {
    public CandyBag getCandyBag();
    public void processPurchase(double cash, double purchasePrice, int wrappersNeeded, String purchaseCandyType);
}
