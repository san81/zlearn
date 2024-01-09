package com.san.amazon.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWords {
  public List<Integer> findSubstring(String s, String[] words) {
    if (words[0].equals(s) && words.length == 1) {
      return List.of(0);
    }
    Map<String, Integer> wordIdx = new HashMap<>();
    int totalLen = 0;
    for (int i = 0; i < words.length; i++) {
      wordIdx.put(words[i], wordIdx.getOrDefault(words[i], 0) + 1);
      totalLen += words[i].length();
    }

    if (totalLen > s.length()) {
      return List.of();
    }

    int wlen = words[0].length();
    int subStrLen = wlen * words.length;
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < s.length() - wlen; i++) {
      String cw = s.substring(i, i + wlen);
      if (wordIdx.get(cw) != null && s.length() - i >= subStrLen - wlen) {
        boolean foundSubStr = seeIfThereIsSubstring(s, i, wlen, new HashMap<>(wordIdx), words.length);
        if(foundSubStr) {
          ans.add(i);
        }
      }
    }
    return ans;
  }

  public boolean seeIfThereIsSubstring(String s, int i, int wlen, Map<String, Integer> wordIdx, int nofWords) {
    for (int j = 1; j <= nofWords; j++) {
      if (i + (j * wlen) > s.length()) {
        return false;
      }
      String cw = s.substring(i + ((j - 1) * wlen), i + (j * wlen));
      if (wordIdx.get(cw) != null && 0 != wordIdx.get(cw)) {
        wordIdx.put(cw, wordIdx.get(cw) - 1);
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    SubstringWords sw = new SubstringWords();
   /* String s = "barfoothefoobarman";
    String[] words = new String[] {"foo", "bar"};
    List<Integer> ans = sw.findSubstring(s, words);
    System.out.println(ans);

    s = "wordgoodgoodgoodbestword";
    words = new String[] {"word", "good", "best", "word"};
    ans = sw.findSubstring(s, words);
    System.out.println(ans);

    s = "barfoofoobarthefoobarman";
    words = new String[] {"bar", "foo", "the"};
    ans = sw.findSubstring(s, words);
    System.out.println(ans);*/

    String s = "wordgoodgoodgoodbestword";
    String[] words = new String[] {"word", "good", "best", "good"};
    List<Integer> ans = sw.findSubstring(s, words);

//    String s = "aaa";
//    String[] words = new String[] {"a", "a"};
//    List<Integer> ans = sw.findSubstring(s, words);

    System.out.println(ans);
  }
}
