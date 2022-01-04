package com.san;

public class AlternateCoinFaces {

    public boolean isValid(int[] A) {
        if(A.length==1){
            return true;
        }
        for(int i=1;i<A.length; i++){
            if(A[i-1]==A[i]){
                return false;
            }
        }
        return true;
    }

    public void swap(int[] A, int i){
        if(A[i]==0){
            A[i] = 1;
        }
        else {
            A[i] = 0;
        }
    }

    public int minSwaps(int[] A, int l, int cnt, int minm) {

        if(isValid(A)){
            return cnt;
        }

        for(int i=l; i<A.length; i++){
            swap(A, i);
            cnt++;

            int x = minSwaps(A, i+1, cnt, minm);

            //Backtrack
            swap(A, i);
            cnt--;

            int y = minSwaps(A, i+1, cnt, minm);

            minm = Math.min(minm, Math.min(x, y));
        }
        return minm;
    }

    public int solution(int[] A) {
        if(isValid(A)){
            return 0;
        }
        int minm = Integer.MAX_VALUE;
        return minSwaps(A, 0, 0, minm);
    }

    public static void main(String ar[]){
        //int[] A = {1, 0, 1, 0, 1, 1};
        //int[] A = { 1, 1, 0, 1, 1};
        //int[] A = { 0, 1, 0};
        //int[] A = { 0,1,1,0 };
        int[] A = { 0,1,1,1,1,1,0,1,1,0 };

        AlternateCoinFaces acf = new AlternateCoinFaces();
        System.out.println(acf.solution(A));
    }
}
