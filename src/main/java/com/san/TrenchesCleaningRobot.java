package com.san;

/**
 * Created by santhoshgandhe on 9/3/18.
 */
import java.util.ArrayList;
import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class TrenchesCleaningRobot
{


    public static int findOutMaxSourounding(int rowNum, int colNum, int[][] distMat, int numColumns, int numRows) {

        int maxSoFar = Integer.MIN_VALUE;
        if(rowNum-1>=0){
            if(colNum-1>=0){
                if(distMat[rowNum-1][colNum-1]>maxSoFar)
                    maxSoFar=distMat[rowNum-1][colNum-1];
            }

            if(distMat[rowNum-1][colNum]>maxSoFar){
                maxSoFar=distMat[rowNum-1][colNum];
            }

            if(colNum+1<numColumns){
                if(distMat[rowNum-1][colNum+1]>maxSoFar){
                    maxSoFar=distMat[rowNum-1][colNum+1];
                }
            }
        }

        //Compare in the current row
        if(colNum-1>=0 && distMat[rowNum][colNum-1]>maxSoFar){
            maxSoFar=distMat[rowNum][colNum-1];
        }
        if(colNum+1<numColumns && distMat[rowNum][colNum+1]>maxSoFar){
            maxSoFar=distMat[rowNum][colNum+1];
        }

        //Compare with below cells

        if(rowNum+1<numRows){
            if(colNum-1>0){
                if(distMat[rowNum+1][colNum-1]>maxSoFar)
                    maxSoFar=distMat[rowNum+1][colNum-1];
            }

            if(distMat[rowNum+1][colNum]>maxSoFar){
                maxSoFar=distMat[rowNum+1][colNum];
            }

            if(colNum+1<numColumns){
                if(distMat[rowNum+1][colNum+1]>maxSoFar){
                    maxSoFar=distMat[rowNum+1][colNum+1];
                }
            }
        }

        return maxSoFar;
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static int removeObstacle(int numRows, int numColumns, List<List<Integer>> lot)
    {
        // WRITE YOUR CODE HERE

        int[][] distMat = new int[numRows][numColumns];
        int rowNum=0;
        for(List<Integer> rows:lot){
            int colNum=0;
            for(Integer cell:rows){
                //logic to calculate the distance
                if(rowNum==0 && colNum==0) {
                    //robo starting here. Nothing to move
                    distMat[rowNum][colNum]=0;
                }

                 if(cell==9){
                    //we reached to the abstacle.  Pick the lowest of all the cells round.
                     //We have to pick the lowest of all 8 soroudings
                    return findOutMaxSourounding(rowNum, colNum, distMat, numColumns, numRows);

                 }

                 if(cell==1){
                     //Compute the distance from around the 8 cells.
                    int minSoFar=findOutMaxSourounding(rowNum, colNum, distMat, numColumns, numRows);
                    distMat[rowNum][colNum]=minSoFar+1;
                 }

                colNum++;
            }
            rowNum++;
        }
        return 0;
    }
    // METHOD SIGNATURE ENDS


    public static void main(String ar[]){

        List<List<Integer>>  flatArea = new ArrayList<List<Integer>>();
        ArrayList<Integer> l1 = new ArrayList<>(2);
        l1.add(1); l1.add(0); l1.add(0);
        flatArea.add(l1);

        ArrayList<Integer> l2 = new ArrayList<>(2);
        l2.add(1); l2.add(0); l2.add(0);
        flatArea.add(l2);

        ArrayList<Integer> l3 = new ArrayList<>(2);
        l3.add(1); l3.add(9); l3.add(1);
        flatArea.add(l3);

        int i = removeObstacle(3, 3, flatArea);
        System.out.print(i);
    }
}