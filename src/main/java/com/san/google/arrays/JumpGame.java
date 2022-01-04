package com.san.google.arrays;

public class JumpGame {
    /*public boolean canJump(int[] nums) {
        if(nums.length<=1){
            return true;
        }

        int nextJump = 0;
        int soFar = 0;
        while(soFar<nums.length-1){
            nextJump = nums[soFar];
            if(nextJump==0 && soFar!=nums.length-1){
                return false;
            }
            if((nextJump+soFar)>=nums.length-1){
                return true;
            }
            soFar += nextJump;
        }
        return false;
    }*/

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max = 0;
        for(int i=0; i<=max; i++){
            max = Math.max(max, i+nums[i]);
            if(max >= len-1)  return true;
        }
        return false;
    }

    public static void main(String[] args) {
        //int[] nums = {2,2,1,0,4}; //false
        //int[] nums = {2,2,1,1,4}; //true
        //int[] nums = {1,2}; //true
        //int[] nums = {0, 1}; //false
        //int[] nums = {2, 0}; //true
        int[] nums = {2, 5, 0, 0}; // true
        System.out.println(new JumpGame().canJump(nums));
    }
}
