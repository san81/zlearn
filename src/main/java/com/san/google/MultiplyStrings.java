package com.san.google;

import java.util.Arrays;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] ans = new int[num1.length()+num2.length()];
        int startPoint = 0;
        int carry = 0;
        for(int i=num1.length()-1;i>=0;i--) {
            int curDigit = num1.charAt(i)-'0';
            int idx = startPoint;
            for(int j=num2.length()-1; j>=0; j--) {
                int curVal = ((num2.charAt(j) - '0')*curDigit)+carry+ans[idx];
                carry = curVal / 10;
                ans[idx] = curVal % 10;
                idx++;
            }
            if(carry!=0){
                ans[idx] = carry;
                carry = 0;
            }
            startPoint++;
        }
        StringBuilder sb = new StringBuilder();
        boolean digitStart = false;
        for(int i=ans.length-1;i>=0;i--){
            if(!digitStart && ans[i]!=0){
                digitStart = true;
            }
            if(digitStart) {
                sb.append(ans[i]);
            }
        }
        if(!digitStart){
            sb.append("0");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "0", num2 = "0";
        System.out.println(new MultiplyStrings().multiply(num1, num2));
    }
}
