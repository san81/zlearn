package com.san;

import java.util.Stack;

public class AlternatRemoval {

    public String solution(String s) {
        if(null==s || "".equals(s)) {
            return s;
        }
        char[] chars = s.toCharArray();
        Stack<Character> charStack = new Stack<>();

        charStack.push(chars[0]);

        for(int i=1; i<chars.length; i++){
            char lastC = charStack.peek();
            if((chars[i]=='B' && lastC == 'A') || (chars[i]=='A' && lastC == 'B') ||
                (chars[i]=='D' && lastC == 'C') || (chars[i]=='C' && lastC == 'D')
                ){
                charStack.pop();
            }else {
                charStack.push(chars[i]);
            }
        }

        String result = "";
        while(!charStack.empty()){
            result = charStack.pop()+result;
        }
        return result;
    }

    public static void main(String args[]){
        //String s = "CBACD";
        String s = "CABABD";
        //String s = "";
        // String s = "ACBDACBD";
        AlternatRemoval ar = new AlternatRemoval();
        System.out.println(ar.solution(s));
    }
}
