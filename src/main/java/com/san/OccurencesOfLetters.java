package com.san;

public class OccurencesOfLetters {

    public String solution(int N) {
        // write your code in Java SE 8
        boolean isOdd = Boolean.FALSE;
        int lstIdx = N-1;
        if(N%2!=0){
            isOdd = true;
            lstIdx = N;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<lstIdx;i++){
            sb.append('a');
        }
        if(!isOdd){
            sb.append('b');
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String ar[]){
        OccurencesOfLetters oc = new OccurencesOfLetters();
        oc.solution(5);
    }

}
