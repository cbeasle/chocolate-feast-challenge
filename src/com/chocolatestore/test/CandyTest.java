package com.chocolatestore.test;

import com.chocolatestore.domain.Candy;
import com.chocolatestore.domain.CandyType;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by cbeasle on 2/10/18.
 */
public class CandyTest {
    @Test
    public void goodCandyTypeString() throws Exception {
        IllegalArgumentException iae = null;
        try{
            Candy goodCandy = new Candy("milk");
        }
        catch (IllegalArgumentException e){
            iae = e;
        }
        assertNull(iae);
    }

    @Test
    public void badCandyTypeString() throws Exception {
        IllegalArgumentException iae = null;
        try{
            Candy badCandy = new Candy("foo");
        }
        catch (IllegalArgumentException e){
            iae = e;
        }
        assertNotNull(iae);
    }

    @Test
    public void getType() throws Exception {
        Candy c = new Candy(CandyType.MILK);
        assertEquals(CandyType.MILK,c.getType());
    }

    @Test
    public void setType() throws Exception {
        Candy c = new Candy(CandyType.MILK);
        c.setType(CandyType.DARK);
        assertEquals(CandyType.DARK,c.getType());

    }

    @Test
    public void setTypeString() throws Exception {
        Candy c = new Candy("white");
        c.setType("sugar free");
        assertEquals(CandyType.SUGAR_FREE,c.getType());

    }

    @Test
    public void getPromoCandyType() throws Exception {
        Candy c = new Candy(CandyType.MILK);
        assertEquals(CandyType.SUGAR_FREE,c.getPromoCandyType());

        c = new Candy(CandyType.SUGAR_FREE);
        assertEquals(CandyType.DARK,c.getPromoCandyType());

        c = new Candy(CandyType.WHITE);
        assertEquals(CandyType.SUGAR_FREE,c.getPromoCandyType());

        c = new Candy(CandyType.DARK);
        assertNull(c.getPromoCandyType());
    }

}