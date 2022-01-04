package com.san.amazon.dp;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    Map<Integer, Integer> memo = new HashMap<>();

    public int maxRob(int index, int [] nums) {

        if(memo.containsKey(index)) return memo.get(index);
        if(index >= nums.length) return 0;
        if(index == nums.length-1) return nums[index];
        if(index == nums.length-2) return Math.max(nums[index], nums[index+1]);
        int profit = Math.max(
                nums[index] + maxRob(index+2, nums),
                 maxRob(index+1, nums)
        );
        memo.put(index, profit);
        return profit;
    }

    public int rob(int[] nums) {
        return maxRob(0, nums);
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,1};
        int[] nums = new int[]{2,7,9,3,1};
        System.out.println(new HouseRobber().rob(nums));
    }

}
