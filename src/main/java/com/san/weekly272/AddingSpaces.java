package com.san.weekly272;

import org.junit.Assert;

public class AddingSpaces {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int c = 0;
        for(int i:spaces) {
            sb.insert(i+c, " ");
            c++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddingSpaces addingSpaces = new AddingSpaces();
        Assert.assertEquals(addingSpaces.addSpaces("LeetcodeHelpsMeLearn",new int[]{8,13,15}),"Leetcode Helps Me Learn");
        Assert.assertEquals(addingSpaces.addSpaces("icodeinpython",new int[]{1,5,7,9}),"i code in py thon");
        Assert.assertEquals(addingSpaces.addSpaces("spacing",new int[]{0,1,2,3,4,5,6})," s p a c i n g");

    }
}
