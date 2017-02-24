package com.kata.pranitha.pathoflowestcost;

/**
 * Created by bh00992 on 2/23/17.
 */

public  class Coordinates{
    int x,y;
    public Coordinates(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
    public boolean equals(Coordinates coordinates)
    {
        return (this.x==coordinates.x)&&(this.y==coordinates.y);
    }
}