package com.san.algorithms.strings;

public class LongestSubseqPalindrom {

    public class HelloWorld {

        public static void main(String[] args){
            //Prints "Hello, World" to the terminal
            System.out.println("Hello, World");
        }

    }

// Problem: Given a sequence, find the length of the longest palindromic subsequence in it.

//s: String = "abkbc" -> bkb = 3
//s: String = "bacfghagqhab" -> bagagab

//abkbc


    public int longestSeqPolindrom(String s) { //abkbc
        int n = s.length();  //n=5
        int[][] cache=new int[n][n];
        int ans =  dp(cache, s, 0, n-1);  //abkbc, 0 , 5
        if(ans==0) {
            return 1;
        }else {
            return ans;
        }
    }

    public int dp(int[][] cache, String s, int i, int j) {  //abkbc, 0, 4   //i=1, j=4

        if(cache[i][j]!=0) {
            return cache[i][j];
        }

        if(i>j){
            return 0;
        }

        if(i==j) {
            return 1;
        }

        if(s.charAt(i)==s.charAt(j)) {
            cache[i][j] = 2 + dp(cache, s, i+1, j-1);
        }else {
            int iIncrease = dp(cache, s, i+1, j);  //i=1, j=4. //i=2, j=4.  2
            int jDecrease = dp(cache, s, i, j-1);  //i=0, j=3. //
            cache[i][j] = Math.max(iIncrease, jDecrease);
        }
        return cache[i][j];
    }



// bacjkhcjhkfab. (n * n)

// a1, a2, a2,.....an

//  O(2*n)




// i=0 j=5. match 2
// i=1 j=4. match 4

// i=1 j=4. match 4



}
