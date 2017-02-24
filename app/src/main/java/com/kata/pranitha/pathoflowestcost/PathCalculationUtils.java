package com.kata.pranitha.pathoflowestcost;

import java.util.ArrayList;

/**
 * Created by bh00992 on 2/24/17.
 */

public class PathCalculationUtils {
    public static PathResult calculateLowestCostPath(String input)
    {
        if(InputValidationUtils.validateInput(input))
        {
            int[][] inputArray = InputValidationUtils.getInputMatrix(input);
            return PathCalculationUtils.findLowestCostPath(inputArray);
        }
        else
            return null;
    }
    public static PathResult findLowestCostPath(int[][] inputMatrix)
    {
        CostMatrix costMatrix= new CostMatrix(inputMatrix);
        PathResult pathResult=null;
        for(int i=0;i<costMatrix.getNumberOfRows();i++)
        {
            PathResult rowPathResult = findPathForCoordinates(costMatrix,new Coordinates(i,0),0,new ArrayList<Integer>());
            if (pathResult==null||pathResult.lowestCost>rowPathResult.lowestCost)
            {
                if (rowPathResult.lowestCostPath.size()!=0)
                    pathResult = rowPathResult;
            }
        }
        if (pathResult==null)
        {
            pathResult=new PathResult(false,0,new ArrayList<Integer>());
        }
        return pathResult;
    }
    public static PathResult findPathForCoordinates(CostMatrix costMatrix, Coordinates coordinates, int previousCost, ArrayList<Integer> previousPath)
    {
        int cost = previousCost+costMatrix.getItem(coordinates);
        ArrayList<Integer> costPath = new ArrayList<>();
        for (int pathIndex:previousPath) {
            costPath.add(pathIndex);
        }
        costPath.add(coordinates.x+1);
        if (cost > 50) {
            return new PathResult(false,previousCost,previousPath);
        } else if (coordinates.y == costMatrix.getNumberOfColumns()-1) {
            return new PathResult(true,cost,costPath);
        }
        PathResult rightAbovePath = findPathForCoordinates(costMatrix,costMatrix.getRightAboveCoordinates(coordinates),cost,costPath);
        PathResult rightbelowPath = findPathForCoordinates(costMatrix,costMatrix.getRightBelowCoordinates(coordinates),cost,costPath);
        PathResult rightPath = findPathForCoordinates(costMatrix,costMatrix.getRightNextCoordinates(coordinates),cost,costPath);
        if (compareResult(rightPath,rightAbovePath) && compareResult(rightPath,rightbelowPath))
        {
            return rightPath;
        } else if (compareResult(rightAbovePath,rightbelowPath)) {
            return rightAbovePath;
        } else {
            return rightbelowPath;
        }
    }
    public static Boolean compareResult(PathResult pathResult1, PathResult pathResult2)
    {
        if (pathResult1.lowestCostPath.size()==pathResult2.lowestCostPath.size())
        {
            return pathResult2.lowestCost>=pathResult1.lowestCost;
        }
        else
        {
            return pathResult2.lowestCostPath.size()<pathResult1.lowestCostPath.size();
        }
    }
}
