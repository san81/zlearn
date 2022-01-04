package com.san.google.arrays;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are in the inclusive range.
 *
 * A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
 *
 * Return the smallest sorted list of ranges that cover every missing number exactly. That is, no element of nums is in any of the ranges, and each missing number is in one of the ranges.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,3,50,75], lower = 0, upper = 99
 * Output: ["2","4->49","51->74","76->99"]
 * Explanation: The ranges are:
 * [2,2] --> "2"
 * [4,49] --> "4->49"
 * [51,74] --> "51->74"
 * [76,99] --> "76->99"
 * Example 2:
 *
 * Input: nums = [], lower = 1, upper = 1
 * Output: ["1"]
 * Explanation: The only missing range is [1,1], which becomes "1".
 * Example 3:
 *
 * Input: nums = [], lower = -3, upper = -1
 * Output: ["-3->-1"]
 * Explanation: The only missing range is [-3,-1], which becomes "-3->-1".
 * Example 4:
 *
 * Input: nums = [-1], lower = -1, upper = -1
 * Output: []
 * Explanation: There are no missing ranges since there are no missing numbers.
 * Example 5:
 *
 * Input: nums = [-1], lower = -2, upper = -1
 * Output: ["-2"]
 *
 *
 * Constraints:
 *
 * -109 <= lower <= upper <= 109
 * 0 <= nums.length <= 100
 * lower <= nums[i] <= upper
 * All the values of nums are unique.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();
        int lastSeen = lower;
        if(nums.length==0){
            if(upper==lower)
                ranges.add(upper+"");
            else
                ranges.add(lower+"->"+upper);
            return ranges;
        }
        if(lower!=nums[0]){
            if(nums[0]-lower==1){
                ranges.add(lower+"");
            }else {
                ranges.add(lower+"->"+(nums[0]-1));
            }
            lastSeen = nums[0];
        }
        for(int n: nums){
            if(n!=lastSeen && !(n==lastSeen+1)) {
                //Crate a range
                if(n-lastSeen==2){
                    ranges.add((lastSeen+1)+"");
                }else{
                    ranges.add((lastSeen+1)+"->"+(n-1));
                }
            }
            lastSeen = n;
        }

        if((upper==lower && lower==lastSeen) || lastSeen==upper) {
            return ranges;
        }
        if(lastSeen+1==upper){
            ranges.add((lastSeen+1)+"");
        }else{
            ranges.add((lastSeen+1)+"->"+(upper));
        }
        return ranges;
    }

    public static void main(String[] args) {
        MissingRanges mr = new MissingRanges();
//        System.out.println(mr.findMissingRanges(new int[]{0,1,3,50,75}, 0, 99));
        Assert.assertEquals(mr.findMissingRanges(new int[]{0,1,3,50,75}, 0, 99), Arrays.asList("2","4->49","51->74","76->99"));
        Assert.assertEquals(mr.findMissingRanges(new int[]{}, 1, 1), Arrays.asList("1"));
        Assert.assertEquals(mr.findMissingRanges(new int[]{}, -3, -1), Arrays.asList("-3->-1"));
        Assert.assertEquals(mr.findMissingRanges(new int[]{-1}, -1, -1), new ArrayList<>());
        Assert.assertEquals(mr.findMissingRanges(new int[]{-1}, -2, -1), Arrays.asList("-2"));
        Assert.assertEquals(mr.findMissingRanges(new int[]{-1}, -1, 0), Arrays.asList("0"));
        Assert.assertEquals(mr.findMissingRanges(new int[]{7}, 0, 9), Arrays.asList("0->6","8->9"));
    }
}
