package com.san.biweekly46;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 5668. Longest Nice Substring
 * User Accepted:0
 * User Tried:6
 * Total Accepted:0
 * Total Submissions:7
 * Difficulty:Easy
 * A string s is nice if, for every letter of the alphabet that s contains, it appears both in uppercase and lowercase. For example, "abABB" is nice because 'A' and 'a' appear, and 'B' and 'b' appear. However, "abA" is not because 'b' appears, but 'B' does not.
 *
 * Given a string s, return the longest substring of s that is nice. If there are multiple, return the substring of the earliest occurrence. If there are none, return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "YazaAay"
 * Output: "aAa"
 * Explanation: "aAa" is a nice string because 'A/a' is the only letter of the alphabet in s, and both 'A' and 'a' appear.
 * "aAa" is the longest nice substring.
 * Example 2:
 *
 * Input: s = "Bb"
 * Output: "Bb"
 * Explanation: "Bb" is a nice string because both 'B' and 'b' appear. The whole string is a substring.
 * Example 3:
 *
 * Input: s = "c"
 * Output: ""
 * Explanation: There are no nice substrings.
 * Example 4:
 *
 * Input: s = "dDzeE"
 * Output: "dD"
 * Explanation: Both "dD" and "eE" are the longest nice substrings.
 * As there are multiple longest nice substrings, return "dD" since it occurs earlier.
 *
 */
public class LongestNiceString {
//    public String longestNiceSubstring(String s) {
//        if("".equals(s)) return "";
//        String input = s.toUpperCase();
//        int start = -1;
//        int lastSeen = input.charAt(0);
//        int maxLen = 0;
//        for(int i=1;i<input.length(); i++) {
//            int tmpStart = i-1;
//            Set<Character> charsInNiceString = new HashSet<>();
//            charsInNiceString.add((char)lastSeen);
//            while(i<input.length() && input.charAt(i)==lastSeen) {
//                i++;
//            }
//            if(tmpStart>0 && i<s.length() && input.charAt(tmpStart-1)==input.charAt(i)){
//                charsInNiceString.add(input.charAt(tmpStart-1));
//                while(tmpStart>0 && charsInNiceString.contains(input.charAt(i))) {
//                    charsInNiceString.add(input.charAt(tmpStart));
//                    tmpStart--;
//                }
//            }
//
//            if(tmpStart!=i && maxLen < i-tmpStart){
//                maxLen = i-tmpStart+1;
//                start = tmpStart;
//            }
//            if(i<s.length())
//                lastSeen = input.charAt(i);
//        }
//        if(start==-1) return "";
//        return s.substring(start, start+maxLen);
//    }


    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char c: arr) set.add(c);
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (set.contains(Character.toUpperCase(c)) && set.contains(Character.toLowerCase(c))) continue;
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i+1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }


    public static void main(String[] args) {
        // difference between 'a'-'A' is 32
//        System.out.println('b'-'B');
        String s = "YazaAay";
//        s = "bB";
//        s = "c";
//        s = "dDzeE";
//        s = "HcCh";
//        s = "cChH";
        System.out.println(new LongestNiceString().longestNiceSubstring(s));
    }
}
