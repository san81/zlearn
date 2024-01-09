package com.san.weekly376;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {

    List<String> ans = new ArrayList<>();


    public void bakTrack(char[] numArr, int idx, int sumNeeded, String exp) {
        if((idx+1)==numArr.length-1) {
            //We are in two digits case
            int first = numArr[idx]-'0';
            int second = numArr[idx+1]-'0';
            if((first+second)==sumNeeded) {
                ans.add(exp+first+"+"+second);
            }
            if((first-second)==sumNeeded) {
                ans.add(exp+first+"-"+second);
            }

            if((first*second)==sumNeeded) {
                ans.add(exp+first+"*"+second);
            }

            return;
        }

        for(int i=idx;i<numArr.length-1;i++){
            int curDigit = numArr[i]-'0';
            bakTrack(numArr, i+1, sumNeeded-curDigit, exp+curDigit+"+");
            bakTrack(numArr, i+1, sumNeeded+curDigit, exp+curDigit+"-");
            if(curDigit!=0)
                bakTrack(numArr,  i+1, sumNeeded/curDigit, exp+curDigit+"*");
        }
    }

    /*public void backTrack(char[] numArr, int target, int idx, int sumSoFar, String exp) {
        if(sumSoFar>target) {
            return;
        }

        if(sumSoFar==target) {
            System.out.println("sumSoFar: "+sumSoFar+" exp: "+exp);
        }

        if(idx==numArr.length) {
            if(sumSoFar==target){
                this.ans.add(exp);
                return;
            }
            return;
        }

        for(int i=idx;i<numArr.length;i++) {
            int curDigit = numArr[i]-'0';
            backTrack(numArr, target, i+1, sumSoFar+curDigit, exp+"+"+curDigit);
            backTrack(numArr, target, i+1, sumSoFar-curDigit, exp+"-"+curDigit);
            if(curDigit!=0)
                backTrack(numArr, target, i+1, sumSoFar/curDigit, exp+"/"+curDigit);
            backTrack(numArr, target, i+1, sumSoFar*curDigit, exp+"*"+curDigit);
        }
    }*/

    public List<String> addOperators(String num, int target) {
        char[] numArr = num.toCharArray();
        int firstDigit = numArr[0]-'0';
        //backTrack(numArr, target, 1, firstDigit, firstDigit+"");
        bakTrack(numArr, 0, target, "");
        return this.ans;
    }

    public static void main(String[] args) {
        System.out.println(new ExpressionAddOperator().addOperators("123", 6));
        System.out.println(new ExpressionAddOperator().addOperators("232", 8));

    }

}
