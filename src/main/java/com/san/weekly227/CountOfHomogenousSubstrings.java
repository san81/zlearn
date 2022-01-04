package com.san.weekly227;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountOfHomogenousSubstrings {
    public int countHomogenous(String s) {
        char current = s.charAt(0);
        long currentCharCount = 0;
        int subStringCount = 0;
        int mod = 1_000_000_007;
        for(int i=0;i<s.length();i++){
            if(current==s.charAt(i)){
                currentCharCount++;
            }else{
                subStringCount += ((currentCharCount * (currentCharCount+1))/2) % mod;
                currentCharCount = 1;
                current=s.charAt(i);
            }
        }
        //To account for the last letter
        subStringCount += ((currentCharCount * (currentCharCount+1))/2) % mod;
        return subStringCount;
    }

    public static void main(String[] args) {
        String s = "abbcccaa";
//        s="xy";
        s = "zzzzz";
        String fileName = "input.txt";
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }
        s = list.get(0);
        System.out.println(new CountOfHomogenousSubstrings().countHomogenous(s));
    }
}
