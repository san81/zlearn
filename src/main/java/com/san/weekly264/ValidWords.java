package com.san.weekly264;

import org.junit.Assert;

/**
 * 5906. Number of Valid Words in a Sentence
 * User Accepted:1541
 * User Tried:2621
 * Total Accepted:1553
 * Total Submissions:5862
 * Difficulty:Easy
 * A sentence consists of lowercase letters ('a' to 'z'), digits ('0' to '9'), hyphens ('-'), punctuation marks ('!', '.', and ','), and spaces (' ') only. Each sentence can be broken down into one or more tokens separated by one or more spaces ' '.
 *
 * A token is a valid word if:
 *
 * It only contains lowercase letters, hyphens, and/or punctuation (no digits).
 * There is at most one hyphen '-'. If present, it should be surrounded by lowercase characters ("a-b" is valid, but "-ab" and "ab-" are not valid).
 * There is at most one punctuation mark. If present, it should be at the end of the token.
 * Examples of valid words include "a-b.", "afad", "ba-c", "a!", and "!".
 *
 * Given a string sentence, return the number of valid words in sentence.
 *
 *
 *
 * Example 1:
 *
 * Input: sentence = "cat and  dog"
 * Output: 3
 * Explanation: The valid words in the sentence are "cat", "and", and "dog".
 * Example 2:
 *
 * Input: sentence = "!this  1-s b8d!"
 * Output: 0
 * Explanation: There are no valid words in the sentence.
 * "!this" is invalid because it starts with a punctuation mark.
 * "1-s" and "b8d" are invalid because they contain digits.
 * Example 3:
 *
 * Input: sentence = "alice and  bob are playing stone-game10"
 * Output: 5
 * Explanation: The valid words in the sentence are "alice", "and", "bob", "are", and "playing".
 * "stone-game10" is invalid because it contains digits.
 * Example 4:
 *
 * Input: sentence = "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."
 * Output: 6
 * Explanation: The valid words in the sentence are "he", "bought", "pencils,", "erasers,", "and", and "pencil-sharpener.".
 *
 *
 * Constraints:
 *
 * 1 <= sentence.length <= 1000
 * sentence only contains lowercase English letters, digits, ' ', '-', '!', '.', and ','.
 * There will be at least 1 token.
 */
public class ValidWords {
    public int countValidWords(String sentence) {
        String[] words = sentence.split(" ");
        int validCnt = 0;
        for(String word:words){
            int hyphenCnt = 0;
            char[] chars = word.toCharArray();
            boolean isValid = true;
            for(int i=0;i<word.length();i++) {
                boolean isPunctuation = chars[i] == '!' || chars[i] == '.' || chars[i] == ',';
                if(isPunctuation && i+1!=chars.length) {
                    isValid = false;
                    break;
                }

                if(chars[i]>='0' && chars[i]<='9') {
                    isValid =false;
                    break;
                }

                if(chars[i]=='-') {
                    hyphenCnt++;
                    if(hyphenCnt>1 || chars.length==1|| i+1 == chars.length) {
                        isValid = false;
                        break;
                    }
                }
                else if(i+1==chars.length && isPunctuation) {
                    continue;
                }else if(!(chars[i]>='a' && chars[i]<='z')) {
                    isValid = false;
                    break;
                }
            }
            if(!"".equals(word) && isValid){
                validCnt++;
            }
        }
        return validCnt;
    }

    public static void main(String[] args) {
        ValidWords validWords = new ValidWords();
//        Assert.assertEquals(3, validWords.countValidWords("cat and  dog"));
//        Assert.assertEquals(0, validWords.countValidWords("!this  1-s b8d!"));
//        Assert.assertEquals(5, validWords.countValidWords("alice and  bob are playing stone-game10"));
//        Assert.assertEquals(6, validWords.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
//        Assert.assertEquals(0, validWords.countValidWords("-"));
//        Assert.assertEquals(1, validWords.countValidWords("!"));
        Assert.assertEquals(4, validWords.countValidWords(". ! 7hk  al6 l! aon49esj35la k3 7u2tkh  7i9y5  !jyylhppd et v- h!ogsouv 5"));
    }
}
