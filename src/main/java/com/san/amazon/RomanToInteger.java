package com.san.amazon;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String r) {
        int ans = 0;
        Map<String, Integer> rtoI = new HashMap<>();
        rtoI.put("M", 1000);
        rtoI.put("CM", 900);
        rtoI.put("D", 500);
        rtoI.put("CD", 400);
        rtoI.put("C", 100);
        rtoI.put("XC", 90);
        rtoI.put("L", 50);
        rtoI.put("XL", 40);
        rtoI.put("X", 10);
        rtoI.put("IX", 9);
        rtoI.put("V", 5);
        rtoI.put("IV", 4);
        rtoI.put("I", 1);
        int[] arr = new int[]       {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM","D", "CD","C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int startIdx = 0;
        for(int i=0;i<r.length();i++){
            String oneCharLookup = r.charAt(i)+"";
            String twoCharLookup = "";
            if(i+1<r.length()){
                twoCharLookup = r.charAt(i)+""+r.charAt(i+1);
            }
            if(rtoI.get(twoCharLookup)!=null){
                i++;
                ans += rtoI.get(twoCharLookup);
            }else{
                ans += rtoI.get(oneCharLookup);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String roman = "DCXCI";
        System.out.println(new RomanToInteger().romanToInt(roman));
    }
}
