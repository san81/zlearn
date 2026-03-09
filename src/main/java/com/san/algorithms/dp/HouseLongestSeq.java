package com.san.algorithms.dp;

import java.util.ArrayList;
import java.util.List;

public class HouseLongestSeq {

    public static void main(String[] args) {
        ///int[] minMax = new int[2];
        List<int[]> segments = new ArrayList<>();
        int[] queries = new int[]{1, 3, 0, 4};

        List<Integer> answer = new ArrayList<>();
        int max = 0;
        for(int query: queries) {
            boolean found = false;
            for(int[] minMax: segments) {
                if(minMax[0]-1==query) {
                    found = true;
                    minMax[0] = minMax[0]-1;
                    max = Math.max(max, minMax[1]-minMax[0]+1);
                    answer.add(max);
                    break;
                }else if(minMax[1]+1==query) {
                    found = true;
                    minMax[1] = minMax[1]+1;
                    max = Math.max(max, minMax[1]-minMax[0]+1);
                    answer.add(max);
                    break;
                }
            }

            if(!found) {
                segments.add(new int[]{query, query});
                if(max==0) {
                    max = 1;
                    answer.add(max);
                }else {
                    answer.add(max);
                }
            }
        }

        System.out.println(answer);

    }
}
