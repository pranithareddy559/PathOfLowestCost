package com.kata.pranitha.pathoflowestcost;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by bh00992 on 2/24/17.
 */

public class PathResultUnitTest {
    @Test
    public void equalsTest(){
        PathResult path1=new PathResult(true,5,new ArrayList<Integer>(Arrays.asList(1,2)));
        PathResult path2=new PathResult(true,5,new ArrayList<Integer>(Arrays.asList(1,2)));
        PathResult path3=new PathResult(true,5,new ArrayList<Integer>(Arrays.asList(4,2)));
        assertTrue(path1.equals(path2));
        assertFalse(path1.equals(path3));
    }
}
