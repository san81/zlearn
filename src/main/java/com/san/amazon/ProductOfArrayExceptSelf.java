package com.san.amazon;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int[] fprod = new int[n];
        int[] bprod = new int[n];
        int j= n -1;
        int fsum = 1, bsum=1;
        for(int i = 0; i< n; i++){
            fsum *= nums[i];
            bsum *= nums[j];
            fprod[i] = fsum;
            bprod[j] = bsum; j--;
        }
        for(int i = 0; i< n; i++){
            int lsum = i==0? 1 :fprod[i-1];
            int rsum = i+1==n? 1 :bprod[i+1];
            output[i] = lsum * rsum;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] answer = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        System.out.println(Arrays.toString(answer));
    }
}
