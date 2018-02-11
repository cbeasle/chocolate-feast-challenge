package com.chocolatestore.test;

import com.chocolatestore.domain.BaggedCandy;
import com.chocolatestore.domain.CandyBag;
import com.chocolatestore.domain.CandyType;
import com.chocolatestore.domain.PurchasedCandy;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by cbeasle on 2/10/18.
 */
public class CandyBagTest {
    @Test
    public void displayBag() throws Exception {
        CandyBag bag = new CandyBag();
        assertEquals(bag.displayBag(),"milk 0, dark 0, white 0, sugar free 0");

    }

    @Test
    public void getBaggedCadies() throws Exception {
        CandyBag bag = new CandyBag();
        HashMap<CandyType,BaggedCandy> baggedCandies = bag.getBaggedCadies();
        assertEquals(baggedCandies.keySet().size(),4);
    }

    @Test
    public void getBagCandy() throws Exception {
        CandyBag bag = new CandyBag();
        BaggedCandy baggedCandy = bag.getBagCandy(CandyType.DARK);
        assertNotNull(baggedCandy);
        assertEquals(baggedCandy.getType(),CandyType.DARK);
    }

    @Test
    public void getPurchasedCandy() throws Exception {
        CandyBag bag = new CandyBag();
        bag.setPurchasedCandy(new PurchasedCandy(CandyType.MILK,2.34));
        assertEquals(bag.getPurchasedCandy().getPrice(),2.34,0);
    }

    @Test
    public void setPurchasedCandy() throws Exception {
        CandyBag bag = new CandyBag();
        bag.setPurchasedCandy(new PurchasedCandy(CandyType.MILK,2.34));
        assertEquals(bag.getPurchasedCandy().getPrice(),2.34,0);

    }

}