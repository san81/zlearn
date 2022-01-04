package com.san.practice;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by santhoshgandhe on 4/24/19.
 */
public class Isogram {
    public static boolean  isIsogram(String str) {
        // One liner solution
        // return str.toLowerCase().chars().distinct().count() == str.length();

        // ...
        if(null==str){
            return false;
        }

        if("".equals(str)) return true;

        char ch[] = str.toCharArray();

        int[] charCount = new int[26];
        for(int i=0;i<ch.length;i++){
            int index=-1;
            if(ch[i]>='a' && ch[i]<='z'){
                index=ch[i]-'a';
            }else if(ch[i]>='A' && ch[i]<='Z'){
                index=ch[i]-'A';
            }else {
                //it is not an alphabet
                //What to do?
            }
            if(charCount[index]==0){
                charCount[index]++;
            }else{
                return false;

            }
        }
        return true;
    }

    public static boolean countOfChars(String str) {
        HashMap<Integer,Integer> countPerchar = new HashMap<>();
        str.toLowerCase().chars().forEach(value -> {
                    countPerchar.computeIfAbsent(value, (k)->0);
                    int i = countPerchar.get(value);
                    countPerchar.put(value,i++);
                }
        );
        return false;
    }
}
