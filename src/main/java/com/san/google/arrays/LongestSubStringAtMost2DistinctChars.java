package com.san.google.arrays;

import org.junit.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "eceba"
 * Output: 3
 * Explanation: The substring is "ece" which its length is 3.
 * Example 2:
 *
 * Input: s = "ccaabbb"
 * Output: 5
 * Explanation: The substring is "aabbb" which its length is 5.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of English letters.
 */
public class LongestSubStringAtMost2DistinctChars {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxSoFar = 0;
        int curLen = 0;

        Map<Character, int[]> distChars = new LinkedHashMap<>();

        int idx = 0;
        Character lastSeen = ' ';
        int nexIdxToStart = 0;
        for(char ch:s.toCharArray()) {
            if(distChars.get(ch)!=null) {
                //updating the end index
                distChars.get(ch)[1] = idx;
                curLen++;
            }

            if(distChars.get(ch)==null) {
                if(distChars.size()<2){
                    distChars.put(ch, new int[]{idx, idx});
                    curLen++;
                }else{
                    if(maxSoFar<curLen){
                        maxSoFar = curLen;
                    }
                    //figure out which char to remove
                    Character charToRemove = null;

                    for(Map.Entry<Character, int[]> entry: distChars.entrySet()){
                        if(entry.getKey()!=lastSeen) {
                            charToRemove = entry.getKey();
                        }
                    }
                    nexIdxToStart = distChars.get(charToRemove)[1]+1;
                    curLen = idx - nexIdxToStart+1;
                    distChars.remove(charToRemove);
                    distChars.put(ch,new int[]{idx, idx});
                    distChars.get(lastSeen)[0] = nexIdxToStart;
                }
            }
            idx++;
            lastSeen = ch;
        }
        if(maxSoFar<curLen){
            maxSoFar = curLen;
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        LongestSubStringAtMost2DistinctChars lsa = new LongestSubStringAtMost2DistinctChars();
//        System.out.println(lsa.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        Assert.assertEquals(lsa.lengthOfLongestSubstringTwoDistinct("eceba"), 3);
        Assert.assertEquals(lsa.lengthOfLongestSubstringTwoDistinct("ccaabbb"), 5);
    }
}
