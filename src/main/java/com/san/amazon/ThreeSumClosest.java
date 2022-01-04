package com.san.amazon;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE;
        int dist = Integer.MAX_VALUE;
        for(int i=0;i<nums.length-1;i++){
            int l = i+1;
            int r = nums.length-1;
            while(l<r) {
                int tripletSum = nums[l]+nums[r]+nums[i];
                int curDist;
                if(tripletSum>target){
                    curDist = tripletSum-target;
                }else if(tripletSum<target){
                    curDist = target-tripletSum;
                }else{
                    return target;
                }

                if(curDist<dist){
                    closestSum = tripletSum;
                    dist = curDist;
                }
                if(tripletSum>target){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{-1,2,1,-4};
//        int target = 1;

        int[] nums = new int[]{1,1,-1,-1,3};
        int target = -1;
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, target));
    }
}
