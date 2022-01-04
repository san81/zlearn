package com.san;
/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 *
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 *
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 *
 * In addition to the mapping above, an encoded message may contain the '*' character, which can represent any digit from '1' to '9' ('0' is excluded). For example, the encoded message "1*" may represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19". Decoding "1*" is equivalent to decoding any of the encoded messages it can represent.
 *
 * Given a string s consisting of digits and '*' characters, return the number of ways to decode it.
 *
 * Since the answer may be very large, return it modulo 109 + 7.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "*"
 * Output: 9
 * Explanation: The encoded message can represent any of the encoded messages "1", "2", "3", "4", "5", "6", "7", "8", or "9".
 * Each of these can be decoded to the strings "A", "B", "C", "D", "E", "F", "G", "H", and "I" respectively.
 * Hence, there are a total of 9 ways to decode "*".
 * Example 2:
 *
 * Input: s = "1*"
 * Output: 18
 * Explanation: The encoded message can represent any of the encoded messages "11", "12", "13", "14", "15", "16", "17", "18", or "19".
 * Each of these encoded messages have 2 ways to be decoded (e.g. "11" can be decoded to "AA" or "K").
 * Hence, there are a total of 9 * 2 = 18 ways to decode "1*".
 * Example 3:
 *
 * Input: s = "2*"
 * Output: 15
 * Explanation: The encoded message can represent any of the encoded messages "21", "22", "23", "24", "25", "26", "27", "28", or "29".
 * "21", "22", "23", "24", "25", and "26" have 2 ways of being decoded, but "27", "28", and "29" only have 1 way.
 * Hence, there are a total of (6 * 2) + (3 * 1) = 12 + 3 = 15 ways to decode "2*".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a digit or '*'.
 */

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DecodeWaysII {

    class Key {
        String s;
        int index;

        public Key(int index, String s) {
            this.index=index;
            this.s = s;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return index == key.index && Objects.equals(s, key.s);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, index);
        }
    }

    Map<Key, Integer> memo = new HashMap<>();

    public int calculateWays(int index, String s) {
        Key key = new Key(index, s);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        if(index == s.length()) {
            return 1;
        }
        if(s.charAt(index)=='0'){
            return 0;
        }
        if(s.charAt(index)=='*' && s.length()==1){
            return 9;
        }
        if(index == s.length() -1){
            return 1;
        }

        char nextChar = s.charAt(index);
        char nextToNextChar = s.charAt(index+1);

        int ans = 0;
        if(nextChar!='*' && nextToNextChar!='*')
            ans = calculateWays(index+1, s);


        if(nextChar=='*') {
            for(int i=1;i<=9;i++) {
                ans += calculateWays(index, s.substring(0, index)+i+s.substring(index+1));
            }
        }
        else if(nextToNextChar=='*') {
            for(int i=1;i<=9;i++) {
                ans += calculateWays(index, s.substring(0, index+1)+i+s.substring(index+2));
            }
        }else {
            if(Integer.parseInt(s.substring(index, index+2))<=26) {
                ans += calculateWays(index+2, s);
            }
        }

        memo.put(key, ans);
        return ans;
    }

    public int numDecodings(String s) {
        return calculateWays(0, s);
    }

    public static void main(String[] args) {
        DecodeWaysII dwii = new DecodeWaysII();
        Assert.assertEquals(9,dwii.numDecodings("*"));
        Assert.assertEquals(18,dwii.numDecodings("1*"));
        Assert.assertEquals(15,dwii.numDecodings("2*"));
        Assert.assertEquals(999,dwii.numDecodings("***"));

    }
}
