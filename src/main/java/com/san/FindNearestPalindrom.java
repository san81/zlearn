package com.san;

import org.junit.Assert;

public class FindNearestPalindrom {

    public int nearestPalindrom(int n){
        String strN = n + "";
        if(strN.length()==1){
            return n;
        }
        if(strN.equals(new StringBuffer(strN).reverse().toString())) {
            return n;
        }

        char[] chars = strN.toCharArray();
        int center = strN.length()/2;
        int left=center-1;
        int right=center+1;
        if(strN.length()%2==0){
            left = center-1;
            right = center;
        }

        while(left>=0) {
            if(chars[left]!=chars[right]){
                chars[right]=chars[left];
            }
            left--;
            right++;
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        FindNearestPalindrom fnp = new FindNearestPalindrom();
//        Assert.assertEquals(1, fnp.nearestPalindrom(1));
        Assert.assertEquals(11, fnp.nearestPalindrom(13));
//        Assert.assertEquals(121, fnp.nearestPalindrom(123));
//        Assert.assertEquals(727, fnp.nearestPalindrom(723));
        Assert.assertEquals(123321, fnp.nearestPalindrom(123456));
    }

}
