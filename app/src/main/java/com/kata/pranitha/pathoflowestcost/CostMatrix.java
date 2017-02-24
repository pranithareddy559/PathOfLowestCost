package com.kata.pranitha.pathoflowestcost;

import android.content.Context;

import java.lang.reflect.Array;

/**
 * Created by bh00992 on 2/22/17.
 */

public class CostMatrix {
    private int[][] matrix;


    public CostMatrix(int[][] costMatrix) {
        this.matrix=costMatrix;
    }
    public int getNumberOfRows()
    {
        return matrix.length;
    }
    public int getNumberOfColumns()
    {
        return matrix[0].length;
    }
    public Integer getItem(Coordinates c)
    {
        if (c.x>=0 && c.x<getNumberOfRows() && c.y>=0 && c.y<getNumberOfColumns())
        return matrix[c.x][c.y];
        else
        return null;
    }
    public Coordinates getRightNextCoordinates(Coordinates c)
    {
        if(c.y>getNumberOfColumns()-2)
        {
            return null;
        }
        else
        {
            return new Coordinates(c.x,c.y+1);
        }
    }
    public Coordinates getRightAboveCoordinates(Coordinates c)
    {
        if(c.y>getNumberOfColumns()-2)
        {
            return null;
        }
        else
        {
            Coordinates coordinates = new Coordinates(c.x -1,c.y+1);
            if(coordinates.x==-1)
            {
                coordinates.x=getNumberOfRows()-1;
            }
            return coordinates;
        }
    }
    public Coordinates getRightBelowCoordinates(Coordinates c)
    {
        if(c.y>getNumberOfColumns()-2)
        {
            return null;
        }
        else
        {
            Coordinates coordinates = new Coordinates(c.x +1,c.y+1);
            if(coordinates.x==getNumberOfRows())
            {
                coordinates.x=0;
            }
            return coordinates;
        }
    }


}
