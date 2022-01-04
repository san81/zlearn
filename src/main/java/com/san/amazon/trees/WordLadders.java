package com.san.amazon.trees;

import java.util.*;

class WordChain {
    String word;
    WordChain fromWord;

    public WordChain(String word, WordChain fromWord){
        this.word = word;
        this.fromWord = fromWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordChain wordChain = (WordChain) o;
        return word.equals(wordChain.word) && Objects.equals(fromWord, wordChain.fromWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, fromWord);
    }
}

public class WordLadders {

    public int wDiff(String first, String second){
        int diff = 0;
        for(int i=0;i<first.length(); i++){
            if(first.charAt(i)!=second.charAt(i)){
                diff++;
            }
        }
        return diff;
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<List<String>> ladders = new HashSet<>();
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

        Queue<WordChain> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(new WordChain(beginWord, null));
        int level = 0;
        int shortestLevel = -1;
        while(!queue.isEmpty()) {
            int qSize = queue.size();
            level++;
            for(int i=0;i<qSize; i++){
                WordChain nextWord = queue.poll();
                visited.add(nextWord.word);
                if(nextWord.word.equals(endWord)) {
                    if(shortestLevel==-1) shortestLevel=level;
                    if(level<=shortestLevel)
                        ladders.add(extractTheLadder(nextWord));
                }

                for(String neighborWord:adjNodes.get(nextWord.word)) {
                    WordChain chain = new WordChain(neighborWord, nextWord);
                    if(!visited.contains(chain.word)) {
                        queue.add(chain);
                    }
                }
            }
        }
        return new ArrayList<>(ladders);
    }

    public List<String> extractTheLadder(WordChain endWord) {
        List<String> ladder = new ArrayList<>();
        while(endWord!=null) {
            ladder.add(endWord.word);
            endWord = endWord.fromWord;
        }
        Collections.reverse(ladder);
        return ladder;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        String beginWord = "hit";
        String endWord = "cog";
//        List<String> wordList = Arrays.asList(new String[]{"a","b","c"});
//        String beginWord = "a";
//        String endWord = "c";
        List<List<String>> ladders = new WordLadders().findLadders(beginWord, endWord, wordList);
        System.out.println(ladders);
    }
}
