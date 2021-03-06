/*
 * Any use of the Material is governed by the terms of the actual license
 * agreement between LeanTaaS Inc. and the user. Copyright 2010 LeanTaaS Inc.,
 * LOS GATOS CA USA. All rights reserved. Any rights not expressly granted
 * herein are reserved.
 */
package com.san.learn;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] a) {
        String s1 = "abcxdefgh";
        String s2 = "abcdefgefgabcdemnop";
        LongestSubString sub = new LongestSubString();
        System.out.println(sub.findLCS(s1, s2));
        System.out.println(sub.findLCSDynamic(s1, s2));
    }

    private String findLCS(String s1, String s2) {
        // find all substrings of smaller string
        int fl = s1.length();
        int sl = s2.length();
        String smaller = fl <= sl ? s1 : s2;
        String larger = fl > sl ? s1 : s2;
        Set<String> substrs = findSubstrs(smaller);
        // check if the substring is part of the other string
        String maxSub = null;
        int max = 0;
        for (String s : substrs) {
            if (s.length() > max) {
                if (larger.indexOf(s) != -1) {
                    maxSub = s;
                    max = s.length();
                }
            }
        }
        // return the longest substring
        return maxSub;
    }

    private Set<String> findSubstrs(String smaller) {
        Set<String> substrs = new HashSet<String>();
        for (int i = 0; i < smaller.length(); i++) {
            for (int j = i + 1; j <= smaller.length(); j++) {
                String sub = smaller.substring(i, j);
                substrs.add(sub);
            }
        }
        return substrs;
    }

    private String findLCSDynamic(String s1, String s2) {
        // here, we need to fill out a matrix[s1.length][s2.length] such that
        // matrix[i][j] => matrix[i-1][j-1] + 1, if s1[i] = s2[j], otherwise 0
        int[][] matrix = new int[s1.length() - 1][s2.length() - 1];
        int max = 0;
        int lastMaxIndex = 0;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    if(i == 0 || j == 0) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = matrix[i-1][j-1] + 1;
                        if(max < matrix[i][j]) {
                            max = matrix[i][j];
                            lastMaxIndex = j;
                        }
                    }
                }
            }
        }
        if(max == 0) {
            return "";
        }
        return s2.substring(lastMaxIndex-max+1, lastMaxIndex + 1);
    }
}
