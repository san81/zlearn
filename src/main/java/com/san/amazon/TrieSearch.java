package com.san.amazon;

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
import java.util.*;

class Trie {
    char character;
    boolean isLast;
    Map<Character, Trie> map;
    String prefix;

    public Trie(char character, String prefix) {
        this.character = character;
        this.prefix = prefix;
        map = new LinkedHashMap<>();
    }

    public Trie(char character, boolean isLast,  Map<Character, Trie> map) {
        this.character=character;
        this.isLast = isLast;
        this.map = map;
    }

}

class TrieDS {

    Trie root;

    public TrieDS() {
        this.root = new Trie(' ', false, new LinkedHashMap<>());
    }

    public void insertString(String word) {
        Trie tmpNode = this.root;
        String pr = "";

        for(char c:word.toCharArray()) {
            pr += c;
            if(!tmpNode.map.containsKey(c)) {
                tmpNode.map.put(c, new Trie(c, pr));
            }
            tmpNode = tmpNode.map.get(c);
        }
        tmpNode.isLast = true;
    }

    public List<String> searchString(String searchWord) {
        List<String> results = new ArrayList<>();
        Trie tmpNode = root;
        boolean found = false;
        for(char c:searchWord.toCharArray()) {
            if(tmpNode.map.containsKey(c)) {
                found = true;
                tmpNode = tmpNode.map.get(c);
            }
        }

        //from tmpNode traverse further
        if(found) {
            if(tmpNode.isLast) {
                results.add(searchWord);
            }else
                results = recursiveExtract(tmpNode, results);
        }
        return results;
    }

    public List<String> recursiveExtract(Trie node, List<String> result) {
        if(result.size()==3) {
            return result;
        }

        for(Trie n: node.map.values()) {
            if(!n.isLast) {
                recursiveExtract(n, result);
            }else{
                result.add(n.prefix);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TrieDS trieDS = new TrieDS();
//        String[] words = {"mobile","mouse", "moneypot", "monitor", "mousepad"};
        String[] words = {"bags", "baggage", "banner", "box","cloths"};
        Arrays.sort(words);
        System.out.println(Arrays.toString(words));
        for(String word:words) {
            trieDS.insertString(word);
        }

        List<List<String>> finalResults = new ArrayList<>();
        String pr = "";
        for(char c:"bags".toCharArray()) {
            pr += c;
            finalResults.add(trieDS.searchString(pr));
        }
        for(List<String> resultrow:finalResults){
            System.out.println(resultrow);
        }
    }
}
