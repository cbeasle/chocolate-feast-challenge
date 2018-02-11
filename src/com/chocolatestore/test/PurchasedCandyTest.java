package com.chocolatestore.test;

import com.chocolatestore.domain.PurchasedCandy;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cbeasle on 2/10/18.
 */
public class PurchasedCandyTest {
    @Test
    public void getPrice() throws Exception {
        PurchasedCandy c = new PurchasedCandy("milk",2.34);
        assertEquals(2.34,c.getPrice(),0);
    }

    @Test
    public void setPrice() throws Exception {
        PurchasedCandy c = new PurchasedCandy("milk",2.34);
        c.setPrice(4.32);
        assertEquals(4.32,c.getPrice(),0);

    }

}