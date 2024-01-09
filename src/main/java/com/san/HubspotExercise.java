package com.san;

import java.util.HashMap;
import java.util.Map;

/**
 * Q: Give the candidate a string (e.g. "inengineering")
 * and ask them to write a method of signature (string str, int n) -> string that returns the most frequently occurring substring of length n in str.
 *
 * For example, with str equal to "inengineering" and n = 2, the substrings would be:
 * `in, ne, en, ng, gi, in, ne, ee, er, ri, in, ng`
 *
 * output: in
 *  O(s*(n)) where n is the number of letters in the string
 *
 *  n
 *  additional space of size s/n
 *  Average case and best case will get better with HashMap
 */
public class HubspotExercise {

    public static String findMostOccuringSubstring(String str, int n){

        if(n>str.length() || n<=0){
            return "";
        }

        String maxOccuredSubString = "";
        int maxCount = 0;
        Map<String, Integer> substringCount = new HashMap<>();
        for(int i=0;i<str.length()-(2*n);i++) {
            String source = str.substring(i, i+n);
            if(substringCount.containsKey(source)) {
                continue;
            }
            int localCount = 0;
            for(int j=(i+n+1);j<str.length()-n-1;j++) {
                String compareWith = str.substring(j, j+n);
                if(compareWith.equals(source)) {
                    localCount++;
                    if(localCount>maxCount) {
                        maxCount = localCount;
                        maxOccuredSubString = compareWith;
                    }
                }
            }
            substringCount.put(source, localCount);
        }
        return maxOccuredSubString;
    }

    public static void main(String[] args) {
        String output = HubspotExercise.findMostOccuringSubstring("inengineerine", 2);
        System.out.printf("Output = "+output);
    }

   /* public static String findMostOccuringSubstring(String str, int n){

        if(n>str.length() || n==0){
            return "";
        }

        String maxOccuredSubString = "";
        int maxCount = 0;
        Map<String, Integer> substringCount = new HashMap<>();
        for(int i=0;i<str.length()-(2*n);i++) {
            String source = str.substring(i, i+n);
            int localCount = 0;
            for(int j=(i+n+1);j<str.length()-n-1;j++) {
                String compareWith = str.substring(j, j+n);
                if(compareWith.equals(source)) {
                    localCount++;
                    if(localCount>=maxCount) {
                        maxCount = localCount;
                        maxOccuredSubString = compareWith;
                    }
                }
            }
        }
        return maxOccuredSubString;
    }*/



}
