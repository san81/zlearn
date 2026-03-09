package com.san.weekly449;

public class EqualSumGripPartition {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if( m==1 && n==1 ) {
                return true;
        }

        long[] rowSum = new long[m];
        long[] colSum = new long[n];

        for(int i=0;i<m;i++) {
            long sum = 0;
            for(int j=0;j<n;j++) {
                sum+=grid[i][j];
            }
            rowSum[i] = sum;
        }

        for(int i=0;i<m;i++) {
            long sum = 0;
            for(int j=0;j<n;j++) {
                sum+=grid[j][i];
            }
            colSum[i] = sum;
        }

        int i=0, j=m;
        long diff = rowSum[i];
        while(i<j) {

        }

        return false;
    }

    public static void main(String[] args) {

    }
}
