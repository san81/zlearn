package com.san.learn;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * 5643. Ways to Split Array Into Three Subarrays
 * User Accepted:1
 * User Tried:4
 * Total Accepted:1
 * Total Submissions:7
 * Difficulty:Medium
 * A split of an integer array is good if:
 *
 * The array is split into three non-empty contiguous subarrays - named left, mid, right respectively from left to right.
 * The sum of the elements in left is less than or equal to the sum of the elements in mid, and the sum of the elements in mid is less than or equal to the sum of the elements in right.
 * Given nums, an array of non-negative integers, return the number of good ways to split nums. As the number may be too large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1]
 * Output: 1
 * Explanation: The only good way to split nums is [1] [1] [1].
 * Example 2:
 *
 * Input: nums = [1,2,2,2,5,0]
 * Output: 3
 * Explanation: There are three good ways of splitting nums:
 * [1] [2] [2,2,5,0]
 * [1] [2,2] [2,5,0]
 * [1,2] [2,2] [5,0]
 * Example 3:
 *
 * Input: nums = [3,2,1]
 * Output: 0
 * Explanation: There is no good way to split nums.
 */
class WaysToSplitArray {
        public int waysToSplit(int[] nums) {
            int MOD = 1000000007;
            int n = nums.length;
            int presum[] = new int[n + 1];
            for (int i = 0; i < n; i++) {
                presum[i + 1] = presum[i] + nums[i];
            }
            // transform into a TreeMap {{ presum[i], i }: i}
            TreeMap<Integer[], Integer> tree = new TreeMap<>(new Comparator<Integer[]>() {
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    if (o1[0].compareTo(o2[0]) != 0) {
                        return o1[0].compareTo(o2[0]);
                    } else {
                        return o1[1].compareTo(o2[1]);
                    }
                }
            });
            for (int i = 0; i < n + 1; i++) {
                tree.put(new Integer[] { presum[i], i }, i);
            }
            long result = 0;
            for (int i = 0; i < n - 2; i++) {
                // nums[0],...,nums[i] | nums[i+1], nums[i+2], ...
                int leftSum = presum[i + 1];
                int remain = presum[n] - leftSum;
                if (remain < leftSum * 2) {
                    break;
                }
                // search first & last in presum[i+2],..., presum[n-1]
                int first = Math.max(i + 2, tree.ceilingEntry(new Integer[] { leftSum * 2, i + 2 }).getValue());
                int last = Math.min(n - 1, tree.floorEntry(new Integer[] { leftSum + remain / 2, n - 1 }).getValue());
                result += Math.max(last - first + 1, 0);
            }
            return (int) (result % MOD);
        }

    public static void main(String ar[]){
        //int[] nums = new int[]{1,1,1};
        //int[] nums = new int[] {1,2,2,2,5,0};
        //int[] nums = new int[] {3,2,1};
        int[] nums = new int[] {7,2,5,5,6,2,10,9};

        System.out.println(new WaysToSplitArray().waysToSplit(nums));
    }
}
