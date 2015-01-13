
package com.san.learn.logical;

/**
 * Rotate a given matric by 90 Degrees
 * 
 * [1][2][3][4]
[5][6][7][8]
[9][0][1][2]
[3][4][5][6]

Becomes:

[3][9][5][1]
[4][0][6][2]
[5][1][7][3]
[6][2][8][4]
 * 
 * @author <a href="santhosh.g@leantaas.com">Santhosh Gandhe</a>
 * @version $Revision: 1.0 $, $Date: Jan 13, 2015
 */
public class MatricRotateBy90Degrees {

    public static void main(String ar[]){
        int[][] mat=new int[4][4];
        mat[0]=new int[]{1,2,3,4};
        mat[1]=new int[]{5,6,7,8};
        mat[2]=new int[]{9,10,11,12};
        mat[3]=new int[]{13,14,15,16};
        
        int size=4;
        int[][] ret = new int[][]{ {0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                ret[i][j]=mat[size-j-1][i];
            }
        }
        
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(ret[i][j]+", ");
            }
            System.out.println();
        }
        
    }
    
    
}
