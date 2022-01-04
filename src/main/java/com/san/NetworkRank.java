package com.san;

import java.util.Arrays;

public class NetworkRank {
    public int solution(int[] A, int[] B, int N) {
        // write your code in Java SE 8
        int nodeRank[] = new int[N+1];

        int firstMax = 0;
        int secondMax = 0;

        for(int i=0; i<A.length; i++) {
            nodeRank[A[i]]++;
            nodeRank[B[i]]++;
        }

        firstMax = nodeRank[1];
        secondMax = nodeRank[1];
        int firstNodeIdx = 1;
        int secondNodeIdx = 1;

        for(int i=1; i<=N; i++) {
            if(firstMax<= nodeRank[i]) {
                firstMax = nodeRank[i];
                firstNodeIdx = i;
            }

            if(secondMax <= nodeRank[i] && nodeRank[i]<firstMax){
                secondMax = nodeRank[i];
                secondNodeIdx = i;
            }
        }
        System.out.println(Arrays.toString(nodeRank));
        System.out.println(firstMax+" "+secondMax);
        System.out.println(firstNodeIdx+" "+secondNodeIdx);

        boolean subtractOne = Boolean.FALSE;
        for(int i=0; i<A.length; i++) {
            if((A[i] == firstNodeIdx && B[i] == secondNodeIdx) || (A[i] == secondNodeIdx && B[i] == firstNodeIdx))  {
                subtractOne = true;
                break;
            }
        }

        if(subtractOne) {
            return firstMax + secondMax - 1;
        } else {
            return firstMax + secondMax;
        }

    }

    public static void main(String ar[]) {
        NetworkRank nr = new NetworkRank();
        int[] A = new int[]{1,2,3,3};
        int[] B = new int[]{2,3,1,4};
        System.out.println(nr.solution(A, B, 4));
    }

}
