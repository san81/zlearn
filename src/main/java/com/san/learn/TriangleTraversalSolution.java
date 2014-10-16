
package com.san.learn;

import java.util.Arrays;

/**
 *         1
          1   2
       1   2   2
   99  99  99   99 
 99  99   1   1    1 
 
 
 
             1
          1   2
       1   2   2
   99  99  99   99 
 99  99   1   1    1 
 
            1
          1   2
       1   2   2
    198 100 100
    
             1
          1   2
       101 102 102
       
            1
         102,104
         
         103  - is the minimum sum.
 
 
 75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 
 
 * 
 *
 */
public class TriangleTraversalSolution {

    public static void main(String ar[]){
        
        int height=15;
        int[][] mat = new int[height][height];
       /* mat[0]=new int[]{1,0,0,0,0};
        mat[1]=new int[]{1,2,0,0,0};
        mat[2]=new int[]{1,2,2,0,0};
        mat[3]=new int[]{99,99,99,99,0};
        mat[4]=new int[]{99,99,1,1,1};*/
        
        mat[0]=new int[]{75};
        mat[1]=new int[]{95,64};
        mat[2]=new int[]{17,47,82};
        mat[3]=new int[]{18,35,87,10};
        mat[4]=new int[]{20,04,82,47,65};
        mat[5]=new int[]{19,01,23,75,03,34};
        mat[6]=new int[]{88,02,77,73,07,63,67};
        mat[7]=new int[]{99,65,04,28,06,16,70,92};
        mat[8]=new int[]{41,41,26,56,83,40,80,70,33};
        mat[9]=new int[]{41,48,72,33,47,32,37,16,94,29};
        mat[10]=new int[]{53,71,44,65,25,43,91,52,97,51,14};
        mat[11]=new int[]{70,11,33,28,77,73,17,78,39,68,17,57};
        mat[12]=new int[]{91,71,52,38,17,14,91,43,58,50,27,29,48};
        mat[13]=new int[]{63,66,04,68,89,53,67,30,73,16,69,87,40,31};
        mat[14]=new int[]{04,62,98,27,23,9,70,98,73,93,38,53,60,04,23};
        
        //Initialized with last row
        int[] sum = new int[]{04,62,98,27,23,9,70,98,73,93,38,53,60,04,23};
      
        for(int i=height-2;i>=0;i--){
            for(int counter=0;counter<i+1;counter++) {
            if(mat[i][counter]+sum[counter] > mat[i][counter]+sum[counter+1]){
                sum[counter]=mat[i][counter]+sum[counter];
            }else{
                sum[counter]=mat[i][counter]+sum[counter+1];
            }
          }
            System.out.println(Arrays.toString(sum));
       }
        System.out.println(sum[0]);
    }
}
