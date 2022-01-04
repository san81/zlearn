package com.san.amazon;

import java.util.*;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z09 ]", " ").toLowerCase();
        String[] words = paragraph.split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> bannedWords = new HashSet<>();
        for(String word: banned){
            bannedWords.add(word);
        }
        for(String word:words){
            if(!bannedWords.contains(word))
                wordCount.put(word, wordCount.getOrDefault(word, 1)+1);
        }
        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = new String[]{"hit"};
        System.out.println(new MostCommonWord().mostCommonWord(paragraph, banned));
    }
}
