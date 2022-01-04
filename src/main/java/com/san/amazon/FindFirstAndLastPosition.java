package com.san.amazon;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 *
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 */

public class FindFirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        if (nums.length == 0) {

            return ret;
        }
        int low = 0;
        int high = (nums.length)-1;
        int mid = (low+high)/2;

        while(low<=high){
            mid = (low+high)/2;
            if(nums[mid] == target){
                break;
            }
            if(nums[mid]<target) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }

        if(nums[mid] == target){
            int first = mid;
            int last = mid;
            while(first-1>=0 && nums[first-1]==target){
                first--;
            }
            while(last+1<nums.length && nums[last+1]==target){
                last++;
            }
            return new int[]{first, last};
        }

        return ret;

    }

    public static void main(String ar[]){
//        int[] nums = new int[]{5,7,7,8,8,10};
//        int target = 8;

//        int[] nums = new int[]{5,7,7,8,8,10};
//        int target = 6;

//        int[] nums = new int[]{1};
//        int target = 1;

//        int[] nums = new int[]{1,4};
//        int target = 4;


        int[] nums = new int[]{1, 1, 2};
        int target = 1;

        System.out.println(Arrays.toString(new FindFirstAndLastPosition().searchRange(nums, target)));

    }

}
