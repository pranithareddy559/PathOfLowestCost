package com.kata.pranitha.pathoflowestcost;

import java.util.ArrayList;

/**
 * Created by bh00992 on 2/23/17.
 */

public class PathResult {
    ArrayList<Integer> lowestCostPath;
        Boolean isValidPath;
        int lowestCost;

        public PathResult(Boolean isValidPath,int lowestCost,ArrayList<Integer> lowestCostPath)
        {
            this.isValidPath=isValidPath;
            this.lowestCost=lowestCost;
            this.lowestCostPath=lowestCostPath;
        }
        public boolean equals(PathResult pathResult)
        {
            return (isValidPath==pathResult.isValidPath)&&(lowestCost==pathResult.lowestCost)&&(lowestCostPath.toString().equalsIgnoreCase(pathResult.lowestCostPath.toString()));
        }
}
