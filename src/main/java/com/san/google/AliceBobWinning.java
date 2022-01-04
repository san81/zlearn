package com.san.google;

public class AliceBobWinning {

    public boolean divisorGame(int N) {
        boolean aliceWin = false;
        if(N==1) return false;
        while(N>0){
            if(N%2==0){
                //it is even so we can go with half
                N =- N/2;
            }else{
                int half = (N-1)/2;
                while(N%half!=0){
                    half--;
                }
                if(half==0) {
                    N = 0;
                }else{
                    N -= half;
                }
            }
            aliceWin =!aliceWin;
        }
        return aliceWin;
    }

    public static void main(String[] args) {
        int N = 1;
        System.out.println(new AliceBobWinning().divisorGame(N));
    }
}
