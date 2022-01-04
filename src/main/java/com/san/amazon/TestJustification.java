package com.san.amazon;


import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 * Example 1:
 *
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Example 2:
 *
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be", because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 *
 * Input: words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class TestJustification {
    public String spaceString(int spaceLen) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<spaceLen;i++){
            sb.append(" ");
        }
        return sb.toString();
    }
    public String adjust(List<String> words, int maxWidth) {
        int count = 0;
        int size = words.size()-1;
        for(String word: words){
            count += word.length();
        }
        StringBuilder sb = new StringBuilder();

        if(size==0){
            //Single word row
            sb.append(words.get(0)).append(spaceString(maxWidth-count));
            return sb.toString();
        }

        int minLen = maxWidth - words.get(0).length();
        if(size>0){
            minLen = (maxWidth-count)/size;
        }
        int extraLeft = 0;
        if(minLen*size!=maxWidth-count){
            extraLeft = maxWidth-count - (minLen*size);
        }

        int[] spaceArr = new int[size];
        int spaceArrCnt = 0;
        while(extraLeft>0){
            spaceArr[spaceArrCnt]++;
            extraLeft--;
            spaceArrCnt++;
            if(spaceArrCnt==size){
                spaceArrCnt=0;
            }
        }

        for(int i=0;i<words.size();i++){
            sb.append(words.get(i));
            if(i!=words.size()-1 || size==0){
                sb.append(spaceString(minLen+spaceArr[i]));
            }
        }
        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret = new ArrayList<String>();
        List<String> curRow = new ArrayList<>();
        int lenSoFar = 0;
        for(String word: words){
            if(word.length()+lenSoFar <= maxWidth){
                lenSoFar += 1+ word.length();
                curRow.add(word);
            }else{
                String adjustWords = adjust(curRow, maxWidth);
                ret.add(adjustWords);
                curRow = new ArrayList<>();
                curRow.add(word);
                lenSoFar = word.length()+1;
            }
        }
        StringBuilder lastRow = new StringBuilder();
        for(int i=0;i<curRow.size();i++){
            lastRow.append(curRow.get(i));

            if(i==curRow.size()-1) {
                lastRow.append(spaceString(maxWidth-lastRow.length()));
            }else {
                lastRow.append(" ");
            }
        }
        ret.add(lastRow.toString());
        return ret;
    }

    public static void main(String ar[]){
//        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
//        int maxWidth = 16;

//        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
//        int maxWidth = 16;
//          String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
//          int maxWidth = 20;

//        String[] words = new String[]{"What","must","be","acknowledgment","shall","be"};
//        int maxWidth =  16;

        String[] words = new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth=20;

        List<String> answer = new TestJustification().fullJustify(words, maxWidth);
        System.out.println(answer.toString());
    }
}
