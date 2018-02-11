package com.chocolatestore.test;

import com.chocolatestore.domain.BaggedCandy;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cbeasle on 2/10/18.
 */
public class BaggedCandyTest {
    @Test
    public void addQuantityToBag() throws Exception {
        BaggedCandy c = new BaggedCandy("milk");
        c.setBagCount(4);
        c.addQuantityToBag(6);
        assertEquals(10,c.getBagCount());
    }

    @Test
    public void getBagCount() throws Exception {
        BaggedCandy c = new BaggedCandy("milk");
        assertEquals(0,c.getBagCount());

    }

    @Test
    public void setBagCount() throws Exception {
        BaggedCandy c = new BaggedCandy("milk");
        c.setBagCount(4);
        assertEquals(4,c.getBagCount());

    }

}