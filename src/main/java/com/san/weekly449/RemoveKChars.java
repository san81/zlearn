package com.san.weekly449;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class RemoveKChars {

    public int minDeletion(String s, int k) {
        Map<Character, Integer> charCnt = new HashMap<>();
        for(char c:s.toCharArray()) {
            int cnt = charCnt.getOrDefault(c, 0);
            charCnt.put(c, cnt+1);
        }

        int charsToDelete = charCnt.keySet().size() - k;
        if(charsToDelete<=0) return 0;
        ArrayList<Integer> cnts = new ArrayList<>(charCnt.values());
        Collections.sort(cnts);
        int totalCharsToDelete = 0;
        for(int i=0;i<charsToDelete; i++) {
            totalCharsToDelete += cnts.get(i);
        }
        return totalCharsToDelete;
    }

    public static void main(String[] args) {
        RemoveKChars removeKChars = new RemoveKChars();
        assertEquals(1, removeKChars.minDeletion("abc", 2));
        assertEquals(0, removeKChars.minDeletion("aabb", 2));
        assertEquals(2, removeKChars.minDeletion("yyyzz", 1));
    }
}
