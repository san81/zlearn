package com.san.learn;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        Set<String> triplet_strs = new HashSet<>();
        for(int i=0;i<nums.length-3; i++){
            for(int j=i+1; j<nums.length-2; j++){
                int k = nums.length-1;
                while(k<j) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        String str_to_check = nums[i] + ":" + nums[j] + ":" + nums[k];
                        if (!triplet_strs.contains(str_to_check)) {
                            List l = new ArrayList<Integer>();
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[k]);
                            result.add(l);
                        }
                    }
                    k--;
                    j++;
                }
            }
        }
        return result;
    }
}

public class ThreeSum {
    public static void main(String ar[]){
        int[] nums = new int[]{1, 0, -1, 2, 3, -5, 4};
        List<List<Integer>> result = new Solution().threeSum(nums);
        System.out.print(result);
    }
}