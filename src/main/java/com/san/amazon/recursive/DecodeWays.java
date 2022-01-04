package com.san.amazon.recursive;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    Map<Integer, Integer> memo = new HashMap<>();

    public int calculateWays(int index, String s) {
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        if(index == s.length()) {
            return 1;
        }
        if(s.charAt(index)=='0'){
            return 0;
        }
        if(index == s.length() -1){
            return 1;
        }
        int ans = calculateWays(index+1, s);
        if(Integer.parseInt(s.substring(index, index+2))<=26) {
            ans += calculateWays(index+2, s);
        }
        memo.put(index, ans);
        return ans;
    }

    public int numDecodings(String s) {
        return calculateWays(0, s);
    }

    public static void main(String[] args) {
        String s = "123";
//        s = "1"; // expected answer 1
//        s = "12";
//        s = "06";
//        s = "27";
//        s = "226";
        s = "10"; //Expected 1
        s ="123123"; //Expected 9
        System.out.println(new DecodeWays().numDecodings(s));
    }
}
