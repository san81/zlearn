package com.san;

import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;

public class MinimumWindowSubString {

  public boolean allCharsExists(Map<Character, Integer> source, Map<Character, Integer> target) {
    for (Map.Entry<Character, Integer> entry : target.entrySet()) {
      Character key = entry.getKey();
      Integer value = entry.getValue();
      if (source.get(key) < value) {
        return false;
      }
    }
    return true;
  }

  public String minWindow(String s, String t) {

    if (t.length() > s.length()) {
      return "";
    }


    int start = 0;
    int end = 0;

    Map<Character, Integer> chars = new HashMap<>();
    Map<Character, Integer> foundChars = new HashMap<>();
    for (char c : t.toCharArray()) {
      int count = chars.getOrDefault(c, 0);
      chars.put(c, ++count);
      foundChars.put(c, 0);
    }

    char[] sCharArray = s.toCharArray();
    String answer = null;
    for (int i = 0; i < s.length(); i++) {
      if (chars.get(sCharArray[i]) != null) {
        if (i != 0 && start == 0 && chars.get(sCharArray[0]) == null) {
          start = i;
        }
        int count = foundChars.getOrDefault(sCharArray[i], 0);
        foundChars.put(sCharArray[i], ++count);
        //See if we found all the chars
        if (allCharsExists(foundChars, chars)) {
          String newAnswer = s.substring(start, end + 1);
          if (answer == null || newAnswer.length() < answer.length()) {
            answer = newAnswer;
          }
          if (null != foundChars.get(sCharArray[start])) {
            int startCounter = foundChars.get(sCharArray[start]);
            foundChars.put(sCharArray[start], --startCounter);
          }
          if (start < s.length() - 1) {
            start++;
          }
          while (chars.get(sCharArray[start]) == null && start <= end) {
            start++;
          }
        }
      }
      end++;
    }
    //Check one last time to see if the substring exists
    end--;
    if (allCharsExists(foundChars, chars)) {
      String newAnswer = s.substring(start, end + 1);
      if (answer == null || newAnswer.length() < answer.length()) {
        answer = newAnswer;
      }
    }
    return answer != null ? answer : "";
  }

  public static void main(String[] args) {
    MinimumWindowSubString mws = new MinimumWindowSubString();
    Assert.assertEquals("BANC", mws.minWindow("ADOBECODEBANC", "ABC"));
    Assert.assertEquals("abc", mws.minWindow("abc", "cba"));
    Assert.assertEquals("baa", mws.minWindow("bbaac", "aba"));

  }
}
