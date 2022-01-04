package com.san.weekly272;

import org.junit.Assert;

public class FindFirstPalindrom {
    public String firstPalindrome(String[] words) {
        for(String str:words) {
            if(str.equals(new StringBuffer(str).reverse().toString())){
                return str;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        FindFirstPalindrom findFirstPalindrom = new FindFirstPalindrom();
        Assert.assertEquals(findFirstPalindrom.firstPalindrome(new String[]{"abc","car","ada","racecar","cool"}),"ada");
        Assert.assertEquals(findFirstPalindrom.firstPalindrome(new String[]{"notapalindrome","racecar"}),"racecar");
        Assert.assertEquals(findFirstPalindrom.firstPalindrome(new String[]{"def","ghi"}),"");


    }
}
