package com.chocolatestore.test;

import com.chocolatestore.delegate.PurchaseCandyImpl;
import com.chocolatestore.domain.CandyType;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
/**
 * Created by cbeasle on 2/10/18.
 */
public class PurchaseCandyImplTest {

    PurchaseCandyImpl impl;
    @Before
    public void setUp() throws Exception {
        impl = new PurchaseCandyImpl();
    }

    @Test
    public void getCandyBag() throws Exception {
        assertNotNull(impl);

        assertEquals(impl.getCandyBag().getBagCandy(CandyType.MILK).getBagCount(),0);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.DARK).getBagCount(),0);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.WHITE).getBagCount(),0);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.SUGAR_FREE).getBagCount(),0);

        assertEquals(impl.getCandyBag().displayBag(),"milk 0, dark 0, white 0, sugar free 0");
    }

    @Test
    public void processPurchaseMilk() throws Exception {
        impl.processPurchase(12,2,5,"milk");

        assertEquals(impl.getCandyBag().getBagCandy(CandyType.MILK).getBagCount(),7);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.DARK).getBagCount(),0);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.WHITE).getBagCount(),0);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.SUGAR_FREE).getBagCount(),1);

        assertEquals(impl.getCandyBag().displayBag(),"milk 7, dark 0, white 0, sugar free 1");

    }

    @Test
    public void processPurchaseDark() throws Exception {
        impl.processPurchase(12,4,4,"dark");

        assertEquals(impl.getCandyBag().getBagCandy(CandyType.MILK).getBagCount(),0);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.DARK).getBagCount(),3);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.WHITE).getBagCount(),0);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.SUGAR_FREE).getBagCount(),0);

        assertEquals(impl.getCandyBag().displayBag(),"milk 0, dark 3, white 0, sugar free 0");

    }

    @Test
    public void processPurchaseSugarFree() throws Exception {
        impl.processPurchase(6,2,2,"sugar free");

        assertEquals(impl.getCandyBag().getBagCandy(CandyType.MILK).getBagCount(),0);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.DARK).getBagCount(),3);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.WHITE).getBagCount(),0);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.SUGAR_FREE).getBagCount(),5);

        assertEquals(impl.getCandyBag().displayBag(),"milk 0, dark 3, white 0, sugar free 5");

    }

    @Test
    public void processPurchaseWhite() throws Exception {
        impl.processPurchase(6,2,2,"white");

        assertEquals(impl.getCandyBag().getBagCandy(CandyType.MILK).getBagCount(),0);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.DARK).getBagCount(),1);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.WHITE).getBagCount(),5);
        assertEquals(impl.getCandyBag().getBagCandy(CandyType.SUGAR_FREE).getBagCount(),3);

        assertEquals(impl.getCandyBag().displayBag(),"milk 0, dark 1, white 5, sugar free 3");

    }

}