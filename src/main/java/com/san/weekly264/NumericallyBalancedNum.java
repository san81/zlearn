package com.san.weekly264;

import java.util.*;

/**
 * 2048. Next Greater Numerically Balanced Number
 * User Accepted:1993
 * User Tried:2658
 * Total Accepted:2081
 * Total Submissions:6468
 * Difficulty:Medium
 * An integer x is numerically balanced if for every digit d in the number x, there are exactly d occurrences of that digit in x.
 *
 * Given an integer n, return the smallest numerically balanced number strictly greater than n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 1
 * Output: 22
 * Explanation:
 * 22 is numerically balanced since:
 * - The digit 2 occurs 2 times.
 * It is also the smallest numerically balanced number strictly greater than 1.
 * Example 2:
 *
 * Input: n = 1000
 * Output: 1333
 * Explanation:
 * 1333 is numerically balanced since:
 * - The digit 1 occurs 1 time.
 * - The digit 3 occurs 3 times.
 * It is also the smallest numerically balanced number strictly greater than 1000.
 * Note that 1022 cannot be the answer because 0 appeared more than 0 times.
 * Example 3:
 *
 * Input: n = 3000
 * Output: 3133
 * Explanation:
 * 3133 is numerically balanced since:
 * - The digit 1 occurs 1 time.
 * - The digit 3 occurs 3 times.
 * It is also the smallest numerically balanced number strictly greater than 3000.
 *
 *
 * Constraints:
 *
 * 0 <= n <= 106
 */
public class NumericallyBalancedNum {

    public int len(int n) {
        Map<Integer, Integer> digits = new HashMap<>();
        int len = 0;
        int startDigit = -1;
        while(n>0){
            int d = n%10;
            int cnt = digits.getOrDefault(d,0);
            digits.put(d, ++cnt);
            n/=10;
            len++;
            startDigit = d;
        }
        return len;
//        System.out.println(digits);
//        System.out.println(len);
//        System.out.println(startDigit);
//
//        int sum = 0;
//        for(int k : digits.keySet()){
//            sum += k;
//        }
//        if(len == sum) {
//            System.out.println("already balanced");
//        }
    }

    public void getMultiples(int cnt) {

        Set<Set> muls = new HashSet<>();
        for(int i=9;i>0;i--){
            int copy = cnt;
            Set<Integer> curSet = new HashSet<>();
            while(copy>0 && i<=copy && !curSet.contains(i)){
                curSet.add(i);
                copy-=i;
            }
            if(copy!=0 && copy!=cnt && !curSet.contains(copy)) {
                curSet.add(copy);
                muls.add(curSet);
            }
        }
        System.out.println(muls);
    }



//    public int nextBeautifulNumber(int n) {
//        int target = n+1;
//        while(!isBalanced(target)) {
//
//        }
//        return target;
//    }

    public static void main(String[] args) {
        NumericallyBalancedNum numericallyBalancedNum = new NumericallyBalancedNum();
        numericallyBalancedNum.getMultiples(250);
    }
}
