package com.san.google.graphs;

import org.junit.Assert;

import java.util.Stack;

/**
 * Decode String
 *
 * Solution
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 *
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 *
 */
public class Decode {

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(char ch:s.toCharArray()) {
            if(ch!=']') {
                stack.push(ch+"");
            }
            else {
                String tmp = stack.pop();
                String str = "";
                while(!tmp.equals("[") && !stack.empty()) {
                    str = tmp + str;
                    tmp = stack.pop();
                }
                if(!stack.isEmpty()) {
                    String dStr = "";
                    while(!stack.empty() && stack.peek().toCharArray()[0]>='0' && stack.peek().toCharArray()[0]<='9') {
                        dStr = stack.pop().toCharArray()[0]+dStr;
                    }
                    if(!"".equals(dStr)) {
                        int digit = Integer.parseInt(dStr);
                        String nextStr = "";
                        for(int i=0;i<digit;i++){
                            nextStr+= str;
                        }
                        stack.push(nextStr);
                    }
                }
            }
        }
        String result = "";
        while(!stack.isEmpty()) {
            result = stack.pop()+result;
        }
        return result;
    }

    public static void main(String[] args) {
        Assert.assertEquals(new Decode().decodeString("100[leetcode]"), "leetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcodeleetcode");
        Assert.assertEquals("aaabcbc", new Decode().decodeString("3[a]2[bc]"));
        Assert.assertEquals("abccdcdcdxyz", new Decode().decodeString("abc3[cd]xyz"));
        Assert.assertEquals("accaccacc", new Decode().decodeString("3[a2[c]]"));
        Assert.assertEquals("abcabccdcdcdef", new Decode().decodeString("2[abc]3[cd]ef"));
    }
}
