package com.san.weekly232;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaximumScoreOfaSubArray {

    Integer[][] minValMem = null;

    public int maxScore(int[] nums, int i, int j, int k) {
        if(i==k && k==j) {
            return nums[i];
        }

        if(minValMem[i][j]!=null) {
            return minValMem[i][j];
        }else if(i+1<=k && minValMem[i+1][j]!=null) {
             int min = Math.min(minValMem[i+1][j], nums[i]);
             minValMem[i][j] = min;
             return min*(j-i+1);
        }else if(minValMem[i][j-1]!=null) {
            int min = Math.min(minValMem[i][j-1], nums[j]);
            minValMem[i][j] = min;
            return min*(j-i+1);
        }

        int minInCurrentCycle = nums[i];
        for(int c = i; c<=j; c++) {
            if(minInCurrentCycle>nums[c]){
                minInCurrentCycle = nums[c];
            }
        }
        int maxScore = minInCurrentCycle * (j - i + 1);

        for(int ci=i; ci<=k;ci++){
            for(int cj=k; cj<=j && k!=j;cj++){
                int score = maxScore(nums, ci, cj, k);
                if(score>maxScore){
                    maxScore = score;
                }
            }
        }
        minValMem[i][j] = minInCurrentCycle;
        return maxScore;
    }
    public int maximumScore(int[] nums, int k) {
        int maxScore = -1;

        Map<Integer, Integer> iMinArray = new HashMap<>();
        Map<Integer, Integer> jMinArray = new HashMap<>();
        int size = nums.length;
        int minVal = nums[k];
        for(int i=k;i>=0;i--){
            if(minVal>nums[i]){
                minVal = nums[i];
            }
            iMinArray.put(i, minVal);
        }
        minVal = nums[k];
        for(int j = k; j< size; j++){
            if(minVal>nums[j]){
                minVal = nums[j];
            }
            jMinArray.put(j, minVal);
        }

        int i=k, j=k;

        while(i>=0 && j< size) {

            int min = Math.min(iMinArray.get(i), jMinArray.get(j));
            int score = min * (j - i + 1);
            if(score>maxScore) {
                maxScore = score;
            }
            if(i==0 && j== size -1) {
                break;
            }
            if(i==0) {
                // we can only move j
                j++;
            }else if(j== size -1){
                i--;
            }else{
                if(iMinArray.get(i-1)>jMinArray.get(j+1)){
                    i--;
                }else{
                    j++;
                }
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,7,4,5};
        int k = 3;
        System.out.println(new MaximumScoreOfaSubArray().maximumScore(nums, k));

    }
}
