package com.san.amazon;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        Set<Integer> dups = new HashSet<>();

        for(int i=0;i<nums.length-1;i++){
            if(dups.add(nums[i])){
                Set<Integer> seen = new HashSet<>();
                for(int j=i+1;j<nums.length;j++){
                    int compliment = 0 - (nums[i] + nums[j]);
                    if(seen.contains(compliment)){
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], compliment);
                        Collections.sort(triplet);
                        ans.add(triplet);
                    }
                    seen.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        //nums = new int[]{0};
        System.out.println(new ThreeSum().threeSum(nums));
    }
}
