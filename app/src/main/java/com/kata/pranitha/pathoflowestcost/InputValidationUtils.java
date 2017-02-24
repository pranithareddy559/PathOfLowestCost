package com.kata.pranitha.pathoflowestcost;

/**
 * Created by bh00992 on 2/24/17.
 */

public class InputValidationUtils {
    public static Boolean validateInput(String inputText)
    {
        Boolean isVaildInput=true;
        int columnsCount=-1;
        String rows[] = inputText.split("\n+");
        if (inputText.length()==0)
        {
            return false;
        }
        for (String row:rows)
        {
            if(columnsCount==-1)
            {
                columnsCount=row.split(" +").length;
            }
            if(columnsCount!=row.split(" +").length)
            {
                return false;
            }
        }
        return isVaildInput;
    }
    public static int[][] getInputMatrix(String inputText)
    {
        String rows[] = inputText.split("\n+");
        int columnsCount=rows[0].split(" +").length;
        int[][] inputMatrix= new int[rows.length][columnsCount];
        int rowIndex=0;
        for (String row:rows)
        {
            String[] rowValues = row.split(" +");
            for (int i=0;i<rowValues.length;i++)
            {
                inputMatrix[rowIndex][i] = Integer.parseInt(rowValues[i]);
            }
            rowIndex=rowIndex+1;
        }
        return inputMatrix;
    }
}
