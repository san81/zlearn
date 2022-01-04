package com.san.weekly229;

/**
 * 5685. Merge Strings Alternately
 * User Accepted:0
 * User Tried:0
 * Total Accepted:0
 * Total Submissions:0
 * Difficulty:Easy
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
 *
 * Return the merged string.
 *
 *
 *
 * Example 1:
 *
 * Input: word1 = "abc", word2 = "pqr"
 * Output: "apbqcr"
 * Explanation: The merged string will be merged as so:
 * word1:  a   b   c
 * word2:    p   q   r
 * merged: a p b q c r
 * Example 2:
 *
 * Input: word1 = "ab", word2 = "pqrs"
 * Output: "apbqrs"
 * Explanation: Notice that as word2 is longer, "rs" is appended to the end.
 * word1:  a   b
 * word2:    p   q   r   s
 * merged: a p b q   r   s
 * Example 3:
 *
 * Input: word1 = "abcd", word2 = "pq"
 * Output: "apbqcd"
 * Explanation: Notice that as word1 is longer, "cd" is appended to the end.
 * word1:  a   b   c   d
 * word2:    p   q
 * merged: a p b q c   d
 */
public class MergeStringAlternately {
    public String mergeAlternately(String word1, String word2) {
        int word1Idx = 0;
        int word2Idx = 0;
        int word1Len = word1.length();
        int word2Len = word2.length();
        int minLen = Math.min(word1Len, word2Len);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<minLen*2; i++) {
            if(i%2==0){
                sb.append(word1.charAt(word1Idx++));
            }else{
                sb.append(word2.charAt(word2Idx++));
            }
        }
        if(word1Len>word2Len) {
             sb.append(word1.substring(word1Idx));
        }else if(word2Len>word1Len){
             sb.append(word2.substring(word2Idx));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        word1 = "ab"; word2 = "pqrs";
        System.out.println(new MergeStringAlternately().mergeAlternately(word1, word2));
    }
}
