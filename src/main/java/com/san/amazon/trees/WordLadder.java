package com.san.amazon.trees;

import java.util.*;

public class WordLadder {


    public int wDiff(String first, String second){
        int diff = 0;
        for(int i=0;i<first.length(); i++){
            if(first.charAt(i)!=second.charAt(i)){
                diff++;
            }
        }
        return diff;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjNodes = new HashMap<>();
        wordList = new ArrayList<>(wordList);
        wordList.add(beginWord);
        for(String word: wordList) {
            if(adjNodes.get(word)==null){
                adjNodes.put(word, new ArrayList<>());
            }
            for(String key: wordList) {
                if(wDiff(word, key)==1) {
                    adjNodes.get(word).add(key);
                }
            }
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            level++;
            for(int i=0;i<qSize; i++){
                String nextWord = queue.poll();
                if(nextWord.equals(endWord)) return level;
                //visited.add(nextWord);
                for(String neighborWord:adjNodes.get(nextWord)) {
                    if(!visited.contains(neighborWord)) {
                        visited.add(neighborWord);
                        queue.add(neighborWord);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));

    }
}
