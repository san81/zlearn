package com.san.amazon;

import java.util.*;

/**
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String str:strs){
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String key = String.valueOf(strChars);
            if(!anagrams.containsKey(key)) {
                anagrams.put(key, new ArrayList<>())    ;
            }
            anagrams.get(key).add(str);

        }
        return new ArrayList(anagrams.values());
    }

    public static void main(String ar[]) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ret = new GroupAnagrams().groupAnagrams(strs);
        System.out.println(ret);
    }
}



