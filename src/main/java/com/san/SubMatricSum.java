package com.san;

public class SubMatricSum {

   // DP mem table holds results
   private int[][] sum;

   // Pre computing is of order M*N
   public SubMatricSum(int[][] matrix) {

      int rows = matrix.length;
      int cols = matrix[0].length;


      this.sum = new int[rows + 1][cols + 1];

      for (int i = 1; i <= rows; i++) {
         for (int j = 1; j <= cols; j++) {

            int subsum = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1];

            sum[i][j] = subsum + matrix[i - 1][j - 1];
         }

      }
   }

   public void print_sub_sum() {
      for(int i=0; i<sum.length; i++) {
         System.out.println(" ");
         for(int j=0; j<sum[i].length; j++) {
            System.out.print(" "+sum[i][j]);
         }
      }
   }

   public int subMax(int sRow, int sCol, int eRow, int eCol) {

      return sum[eRow + 1][eCol + 1] - sum[eRow + 1][sCol] - sum[sRow][eCol + 1] + sum[sRow][sCol];

   }

   public static void main(String[] args) {

      int[][] matrix = new int[][]{
            {0, 1, 0, 1},
            {1, 1, 0, 1},
            {1, 0, 1, 1},
            {0, 1, 0, 1}
      };

      SubMatricSum metrixSum = new SubMatricSum(matrix);
      metrixSum.print_sub_sum();

      int subSum = metrixSum.subMax(1, 1, 2, 2);

      System.out.println("\n"+subSum);
   }

}
