package com.san.weekly274;

import org.junit.Assert;

public class CheckIfAllAsBeforeB {
    public boolean checkString(String s) {
        boolean seenB = false;
        for(char c:s.toCharArray()){
            if(!seenB && c=='b'){
                seenB=true;
            }
            if(seenB && c=='a'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfAllAsBeforeB ciab = new CheckIfAllAsBeforeB();
        Assert.assertEquals(ciab.checkString("aaabbb"),true);
        Assert.assertEquals(ciab.checkString("abab"),false);
        Assert.assertEquals(ciab.checkString("bbb"),true);
    }
}
