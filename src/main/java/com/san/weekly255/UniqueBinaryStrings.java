package com.san.weekly255;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 5851. Find Unique Binary String
 * Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = ["01","10"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "00" would also be correct.
 * Example 2:
 *
 * Input: nums = ["00","01"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "10" would also be correct.
 * Example 3:
 *
 * Input: nums = ["111","011","001"]
 * Output: "101"
 * Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 *
 */
public class UniqueBinaryStrings {


    public List<String> permutations(int len) {
        List<String> result = new ArrayList<>();
        if(len==1) {
            result.add("0");
            result.add("1");
            return result;
        }
        List<String> childResult = permutations(len-1);
        for(String res:childResult) {
            result.add("0"+res);
            result.add("1"+res);
        }
        return result;
    }

    public String iToB(int i, int len) {
        String ans = "";
        while(i>0) {
            ans = (i%2)+ans;
            i /= 2;
        }
        while(ans.length()<len) {
            ans = "0"+ans;
        }
        return ans;
    }
    public String findDifferentBinaryString(String[] nums) {
        int len = nums.length;
        Set<String> numSet = new HashSet<>();
        for(String i:nums) {
            numSet.add(i);
        }
        int possibilities = (int) Math.pow(2,len);
        for(int i=0;i<possibilities;i++) {
            String curItr = iToB(i, len);
            if(!numSet.contains(curItr)) {
                return curItr;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        UniqueBinaryStrings ubs = new UniqueBinaryStrings();
        //System.out.println(ubs.permutations(4));
        //System.out.println(ubs.iToB(5,5));
        ubs.findDifferentBinaryString(new String[]{"01","10"});
        System.out.println(ubs.findDifferentBinaryString(new String[]{"111","011","001"}));
    }
}
