package com.san.amazon;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FirstNonUniqueChar {
    public int firstUniqChar(String s) {
        Map<Character, Integer> uChars = new LinkedHashMap<>();
        Set<Character> dChars = new HashSet<>();
        for(int i=0;i<s.length(); i++){
            char c = s.charAt(i);
            if(dChars.contains(c)){
                continue;
            }else{
                if(uChars.containsKey(c)){
                    dChars.add(c);
                    uChars.remove(c);
                }else{
                    uChars.put(c, i);
                }
            }
        }
        return uChars.size()>0? uChars.entrySet().iterator().next().getValue():-1;
    }

    public static void main(String[] args) {
        String s = "lettcode";
        s = "loveleetcode";
        System.out.println(new FirstNonUniqueChar().firstUniqChar(s));
    }
}
