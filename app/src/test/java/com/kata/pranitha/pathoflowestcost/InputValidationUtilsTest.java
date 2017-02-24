package com.kata.pranitha.pathoflowestcost;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by bh00992 on 2/24/17.
 */

public class InputValidationUtilsTest {
    @Test
    public void validateEmptyInputTest(){
        assertFalse(InputValidationUtils.validateInput(""));
    }
    @Test
    public void validateDifferentNumberOfColumnsInvalidInputTest(){
        assertFalse(InputValidationUtils.validateInput("1 2\n3"));
    }
    @Test
    public void validateSingleInputTest(){
        assertTrue(InputValidationUtils.validateInput("1"));
    }
    @Test
    public void validateSingleRowInputTest(){
        assertTrue(InputValidationUtils.validateInput("1 2 3"));
    }
    @Test
    public void validateSingleColumnInputTest(){
        assertTrue(InputValidationUtils.validateInput("1\n2\n3"));
    }
    @Test
    public void validateMultipleRowsInputTest(){
        assertTrue(InputValidationUtils.validateInput("1 2 3\n4 5 6\n3 -1 3\n2 1 0"));
    }
    @Test
    public void getInputMatrixTest(){
        int[][] resultArray = {{1,2,3},{1,0,0},{-1,0,2}};
        assertArrayEquals(resultArray,InputValidationUtils.getInputMatrix("1 2 3\n1 0 0\n-1 0 2"));
    }
}
