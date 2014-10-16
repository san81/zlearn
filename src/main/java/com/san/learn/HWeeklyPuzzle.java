
package com.san.learn;

import java.math.BigInteger;
import java.util.Scanner;

public class HWeeklyPuzzle {
    
    public static BigInteger ONE=new BigInteger("1");
    public static BigInteger NEGATIVE_ONE=new BigInteger("-1");
    public static BigInteger TWO=new BigInteger("2");
    
    public static BigInteger hsolve(BigInteger value){
        Double sqrt=Math.sqrt(value.doubleValue());
        if(sqrt*sqrt==value.doubleValue()){
            return value.divide(TWO);
        }else{
           
            do{
                    value=value.subtract(ONE);
                    sqrt=Math.sqrt(value.doubleValue());
                    if(sqrt*sqrt==value.doubleValue()){
                        return  value;
                    }
            }while(value.compareTo(ONE)!=0 );
        }
        return NEGATIVE_ONE;
    }
    
    public static void solve(BigInteger value){
        int iterationCounter=0;
        while(value.compareTo(ONE)!=0){
            value=value.subtract(hsolve(value));
            iterationCounter++;
        }
        if(iterationCounter%2==0){
            System.out.println("Richard");
        }else{
            System.out.println("Louise");
        }
        
    }

    public static void main(String ar[]) {
        Scanner in = new Scanner(System.in);
        int testCaseCnt= in.nextInt();
        BigInteger[] inputVals = new BigInteger[testCaseCnt];
        int counter=0;
        
       while( testCaseCnt>0){
           inputVals[counter]=in.nextBigInteger();
           solve(inputVals[counter]);
           counter++;
           testCaseCnt--;
       }
    }
    /*public static void main1(String ar[]) throws IOException{
        FileReader fr = new FileReader(new File("input.txt"));
        BufferedReader br=new BufferedReader(fr);
        String lineStr;
        lineStr=br.readLine();
        int testCaseCnt=Integer.parseInt(lineStr);
        int[] inputVals = new int[testCaseCnt];
        int counter=0;
        lineStr=br.readLine();
       while( lineStr!=null){
           inputVals[counter]=Integer.parseInt(lineStr);
           solve(inputVals[counter]);
           counter++;
           lineStr=br.readLine();
       }
       br.close();
    }*/
}
