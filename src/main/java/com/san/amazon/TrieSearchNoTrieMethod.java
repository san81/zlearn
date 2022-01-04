package com.san.amazon;


import java.util.*;

/**
 * Google's auto suggest kind of a feature where a user is typing and your algorithm should find out all the
 * matching strings from the given dictionary and return the results. Assume that the user is not erasing the letters
 * that he typed in.
 *
 * String[] words = {"bags", "baggage", "banner", "box","cloths"};
 * String searchWord = "bags"
 * Expected output: List of Lists of strings at each letter typed
 *
 * [ ["bags", "baggage", "banner", "box"] // with b
 *   ["bags", "baggage", "banner" ] // with ba
 *   ["bags", "baggage" ] //with bag
 *   ["bags"] // with bags
 *  ]
 *
 *
 */

class TrieDSNoTrie {

    public static void main(String[] args) {
//        String[] words = {"mobile","mouse", "moneypot", "monitor", "mousepad"};
        String[] words = {"bags", "baggage", "banner", "box","cloths"};
        Arrays.sort(words);
        List<List<String>> finalResults = new ArrayList<>();
        String searingWord = "bags";
        List<String> wordsToSearch = Arrays.asList(words);
        for(int i=0;i<searingWord.length();i++) {
            List<String> thisIterationResults = new ArrayList<>();
            for(String word:wordsToSearch) {
                if(searingWord.charAt(i) == word.charAt(i))
                    thisIterationResults.add(word);
            }
            wordsToSearch = thisIterationResults;
            finalResults.add(thisIterationResults);
        }
        for(List<String> resultrow:finalResults){
            System.out.println(resultrow);
        }
    }
}
