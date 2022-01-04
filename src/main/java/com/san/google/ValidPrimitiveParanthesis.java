package com.san.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidPrimitiveParanthesis {
    public String removeOuterParentheses(String S) {
        List<String> decomposed = new ArrayList<>();
        String runningString = "";
        int openCount = 0;
        for(char c:S.toCharArray()){
            runningString += c;
            if(c==')') {
                openCount--;
            }else{
                openCount++;
            }
            if(openCount==0) {
                decomposed.add(runningString);
                runningString = "";
            }

        }
        System.out.println(decomposed);
        String result = "";
        for(String prim:decomposed) {
            if(prim.length()>=2)
                result += prim.substring(1, prim.length()-1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s ="(()())(())"; //expected "()()()"
        s = "(()())(())(()(()))"; // expected "()()()()(())"
        //s = "()()";  // expected empty string output
        System.out.println(new ValidPrimitiveParanthesis().removeOuterParentheses(s));
    }
}
