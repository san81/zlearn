package com.san.weekly229;

import java.util.Arrays;

/**
 * 5686. Minimum Number of Operations to Move All Balls to Each Box
 * User Accepted:1207
 * User Tried:1261
 * Total Accepted:1211
 * Total Submissions:1287
 * Difficulty:Medium
 * You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
 *
 * In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. Note that after doing so, there may be more than one ball in some boxes.
 *
 * Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
 *
 * Each answer[i] is calculated considering the initial state of the boxes.
 *
 *
 *
 * Example 1:
 *
 * Input: boxes = "110"
 * Output: [1,1,3]
 * Explanation: The answer for each box is as follows:
 * 1) First box: you will have to move one ball from the second box to the first box in one operation.
 * 2) Second box: you will have to move one ball from the first box to the second box in one operation.
 * 3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
 * Example 2:
 *
 * Input: boxes = "001011"
 * Output: [11,8,5,4,3,4]
 */
public class MinOperationsToMoveAllBallsToEachBox {
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        int[] leftToRight = new int[boxes.length()];
        int[] rightToLeft = new int[boxes.length()];
        int nofOnes = 0;
        int lastValue = 0;
        for(int i=0;i<boxes.length();i++) {
            leftToRight[i] = lastValue+nofOnes;
            lastValue = leftToRight[i];
            if(boxes.charAt(i)=='1'){
                nofOnes++;
            }
        }

        lastValue = 0;
        nofOnes = 0;
        for(int i=boxes.length()-1;i>=0;i--) {
            rightToLeft[i] = lastValue+nofOnes;
            lastValue = lastValue+nofOnes;
            if(boxes.charAt(i)=='1'){
                nofOnes++;
            }
        }

        for(int i=0;i<boxes.length();i++){
            result[i] = leftToRight[i] + rightToLeft[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String boxes = "110";
        boxes = "001011";
        int[] x = new MinOperationsToMoveAllBallsToEachBox().minOperations(boxes);
        System.out.println(Arrays.toString(x));
    }
}
