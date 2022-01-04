package com.san.weekly233;

public class MaxAscSubArraySum {
    public int maxAscendingSum(int[] nums) {
        if(nums.length==0) {
            return 0;
        }
        int maxSum = 0;
        int lastVal=nums[0];
        int curSum = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>lastVal) {
                curSum+= nums[i];
            }else{
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
                curSum = nums[i];
            }
            lastVal = nums[i];
        }
        if (curSum > maxSum) {
            maxSum = curSum;
        }
        return maxSum;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{10,20,30,5,10,50}; //Expected Ans = 65
//        int[] nums = new int[]{10,20,30,40,50}; //Expected Ans = 150
//        int[] nums = new int[]{12,17,15,13,10,11,12}; //Expected Ans = 33
//        int[] nums = new int[]{100,10,1}; //Expected Ans = 100
        int[] nums = new int[]{3,6,10,1,8,9,9,8,9};
        System.out.println(new MaxAscSubArraySum().maxAscendingSum(nums));
    }
}
