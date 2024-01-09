package com.san.weekly376;

import java.util.*;

/**
 *
 Code

 Testcase
 Test Result
 Test Result

 625. Minimum Factorization
 Medium
 Topics
 Companies
 Given a positive integer num, return the smallest positive integer x whose multiplication of each digit equals num. If there is no answer or the answer is not fit in 32-bit signed integer, return 0.



 Example 1:

 Input: num = 48
 Output: 68
 Example 2:

 Input: num = 15
 Output: 35


 Constraints:

 1 <= num <= 231 - 1
 */
public class MinimumFactorization {


        public Set<Integer> findFactors(int n) {
            Set<Integer> factors = new HashSet<Integer>();
            for(int i=2;i<=n/2;i++){
                if(n%i==0) {
                    factors.add(i);
                }
            }
            return factors;
        }

        public int smallestFactorization(int num) {
            if(num<10) {
                return num;
            }
            Set<Integer> factors = new TreeSet<Integer>();
            for(int i=2;i<=num/2;i++) {
                if(num%i==0) {
                    factors.add(i);
                    factors.add(num / i);
                    factors.addAll(findFactors(i));
                    factors.addAll(findFactors(num / i));
                }
            }

            if(factors.size()==0) {
                return 0;
            }

            System.out.println(factors);
            List<Integer> lfactors = new ArrayList<>(factors);
            int center = factors.size()/2;
            //Start at the center and expand
            int ans = Integer.MAX_VALUE;
            while(center>=0) {
                int first = lfactors.get(center);
                int second = num/first;
                int tmp=0;
                if(first<second){
                    tmp = Integer.parseInt(first+""+second);
                }else{
                    tmp = Integer.parseInt(second+""+first);
                }
                if(ans>tmp){
                    ans=tmp;
                }
                center--;
            }

            return ans;
        }

    public static void main(String[] args) {
        MinimumFactorization mf = new MinimumFactorization();
        System.out.println(mf.smallestFactorization(48));
        System.out.println(mf.smallestFactorization(15));
        System.out.println(mf.smallestFactorization(12));
        System.out.println((int)Math.floor(0.4));
    }

}
