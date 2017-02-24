package com.kata.pranitha.pathoflowestcost;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by bh00992 on 2/24/17.
 */

public class CoordinatesUnitTest {
    @Test
    public void equalsTest(){
        Coordinates coordinates1=new Coordinates(1,2);
        Coordinates coordinates2=new Coordinates(1,2);
        Coordinates coordinates3=new Coordinates(1,3);
        assertTrue(coordinates1.equals(coordinates2));
        assertFalse(coordinates1.equals(coordinates3));
    }
}
