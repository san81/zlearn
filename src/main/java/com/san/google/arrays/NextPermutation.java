package com.san.google.arrays;

import org.junit.Assert;

import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {

        if(nums.length<2) return;
        int last = nums[nums.length-1];
        int previous = nums[nums.length-1];
        int i=nums.length-2;
        for( ;i>0;i--) {
            if(nums[i]<last) {
                int tmp = nums[i];
                nums[i] = last;
                nums[nums.length-1] = tmp;
                return;
            }else {
                nums[i] = previous;
                previous = nums[i];
            }
        }
        if(i==0) {
            int tmp = nums[0];
            nums[0] = last;
            nums[nums.length-1] = tmp;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{3, 2, 1};
        nextPermutation.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1, 2, 3}, nums);
        nums = new int[]{1,2,3};
        nextPermutation.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1,3,2}, nums);
        nums = new int[]{1,1,5};
        nextPermutation.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1,5,1}, nums);
        nums = new int[]{1};
        nextPermutation.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{1}, nums);
        nums = new int[]{1, 3, 2};
        nextPermutation.nextPermutation(nums);
        Assert.assertArrayEquals(new int[]{2, 1, 3}, nums);
    }
}
