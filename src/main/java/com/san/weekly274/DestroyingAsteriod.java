package com.san.weekly274;

import org.junit.Assert;

import java.util.Arrays;

public class DestroyingAsteriod {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long lmass = mass;
        for(int as:asteroids){
            if(as<=lmass)
                lmass+=as;
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        DestroyingAsteriod da = new DestroyingAsteriod();
//        Assert.assertEquals(da.asteroidsDestroyed(10, new int[]{3,9,19,5,21}), true);
//        Assert.assertEquals(da.asteroidsDestroyed(5, new int[]{4,9,23,4}), false);
        Assert.assertEquals(da.asteroidsDestroyed(1, new int[]{1}), true);
    }
}
