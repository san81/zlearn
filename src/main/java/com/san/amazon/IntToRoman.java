package com.san.amazon;

/**
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class IntToRoman {
    public String intToRoman(int num) {
        String ans = "";
        int[] arr = new int[]       {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = new String[]{"M", "CM","D", "CD","C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int startIdx = 0;
        while(num>0){
            while(num<arr[startIdx]) startIdx++;
            ans += roman[startIdx];
           num = num - arr[startIdx];
        }
        return ans;
    }

    public static void main(String[] args) {
        int num = 691;
        System.out.println(new IntToRoman().intToRoman(num));
    }
}
