package com.san.amazon;

public class MatrixRotation {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int n = matrix.length-1;
        int cols = matrix[0].length;
        for(int i=0; i<(rows+1)/2; i++) {
            for (int j=0; j<cols/2; j++) {
                if((i+j)==n || (i-j)==0) {
                    //Exclude diagonal
                    continue;
                }
                int tmp = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n-j];
                matrix[n-i][n-j] = matrix[j][n-i];
                matrix[j][n-i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }

    public void printMat(int[][] matrix) {
        for(int i=0;i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("--------------");
    }

    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        MatrixRotation matrixRotation = new MatrixRotation();
        matrixRotation.printMat(matrix);
        matrixRotation.rotate(matrix);
        matrixRotation.printMat(matrix);
        System.out.println(matrix);
    }
}
