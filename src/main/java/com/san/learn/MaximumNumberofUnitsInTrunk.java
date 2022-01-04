package com.san.learn;

import java.util.*;

public class MaximumNumberofUnitsInTrunk {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (box1, box2) -> box2[1] - box1[1]);
        int sum = 0;
        int idx = 0;
        while(truckSize > 0){
            if(truckSize > boxTypes[idx][0]) {
                sum += boxTypes[idx][0] * boxTypes[idx][1];
                truckSize -= boxTypes[idx][0];
                idx++;
                if(idx == boxTypes.length) break;
            } else{
                sum += boxTypes[idx][1] * truckSize;
                truckSize = 0;
            }

        }
        return sum;
    }

    public static void main(String ar[]){
        int[][] boxTypes = new int[][]{{1,3},{2,2},{3,1}};
        int trunkSize = 4;
        System.out.println(new MaximumNumberofUnitsInTrunk().maximumUnits(boxTypes, trunkSize));
    }

}
