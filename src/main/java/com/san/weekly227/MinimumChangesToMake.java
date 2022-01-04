package com.san.weekly227;

public class MinimumChangesToMake {

    public int minOperations(String s) {

        int countIfZero = 0;
        int countIfOne = 0;
        for(int i=0;i<s.length();i++){
            if(i%2==0) {
                if(s.charAt(i)=='0'){
                    countIfOne++;
                }else{
                    countIfZero++;
                }
            }else{
                if(s.charAt(i)=='0'){
                    countIfZero++;
                }else{
                    countIfOne++;
                }
            }
        }
        return Math.min(countIfZero, countIfOne);
    }

    public static void main(String[] args) {
        String s = "0100";
        s = "10";
        s = "1111";
        System.out.println(new MinimumChangesToMake().minOperations(s));
    }

}
