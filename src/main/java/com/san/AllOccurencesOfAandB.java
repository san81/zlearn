package com.san;

public class AllOccurencesOfAandB {
    public int solution(String S) {
        // write your code in Java SE 8
        int firstA = -1;
        int firstB = -1;
        int lastA = -1;
        int lastB = -1;
        char[] letters = S.toCharArray();
        for(int i=0;i<letters.length; i++){
            if(letters[i]=='A') {
                lastA = i;
                if(firstA == -1){
                    firstA = i;
                }
            }
            else if(letters[i] == 'B'){
                lastB = i;
                if(firstB==-1){
                    firstB = i;
                }
            }
        }

        int remove = -1;
        if(firstB>lastA) {
            //Nothing to do
            remove = 0;
        }else if(firstB<lastA) {
            remove = firstA;
        }

        System.out.println(remove);
        return 0;

    }

    public static void main(String ar[]){
        AllOccurencesOfAandB oc = new AllOccurencesOfAandB();
        oc.solution("BAAABAB");
    }
}
