package com.san.amazon;

import java.util.HashMap;
import java.util.Map;

/**
 * Length of longest substring without repeating characters
 */
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if("".equals(s)){
            return 0;
        }
        Map<Character, Integer> charSoFar = new HashMap<>();
        int start = 0;
        int end = 0;
        int lenSoFar = 0;
        for(int i=0;i<s.length(); i++){
            char currentChar = s.charAt(i);
            if(null==charSoFar.get(currentChar) || charSoFar.get(currentChar) < start ) {
                //We didn't see this letter before
                end = i;
            }else{
                if(lenSoFar<(end - start)+1){
                    lenSoFar = end - start +1;
                }
                int nextStart = charSoFar.get(currentChar)+1;
                if(start < nextStart){  start = nextStart; }
            }
            charSoFar.put(currentChar, i);
        }
        if(lenSoFar<(end - start)+1){
            lenSoFar = end - start +1;
        }
        return lenSoFar;
    }

    public static void main(String[] args) {
        String s ="pwwkew"; //expected 3
        //s = "bbbbb"; //expected 1
        //s = "abcabcbb"; //expected 3
        s = "au";
        s = "aabaab!bb";
        s = "tmmzuxt";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
