
package com.san.learn;

import java.util.Arrays;

/**
 * 
class SingleTonExample {

   private static SingTonExample instance =new SingleTonExample();
   
   private SingleTonExample(){
   
   }
   
   public static SingleTonExample getInstance(){
      
       return instance;
   }
}


n      0   1   2   3    4    5
f(n)   1   1   2   3    5    8

n      0   1   2   3    4    5    6
f(n)   1   1   1   3    5    9    17


public int fibonnacci ( int n ) {

    int i=1,j=1,k=1,sum=0;
    int counter=2;
    if(n<=2){
        return 1;
    }
    while(counter<n){
        sum=i+j+k;
        i=j;j=k;k=sum;
        counter++;
    }
    return sum;

}

            25           0,0
          10  99         + 1,0        1,2 
        55  67  24       + 2,0 2,1 
      68  20  78  62 
      
    x0  x1  x2   x3  x4   
y0   1
y1   1   2
y2   1   2   2
y3   99  99  99   99 
y4   99  99   1   1    1  

     [1]->[(0,0),(1,0),(2,0),(3,2),(3,3)]
     [2]->[(1,1),(2,1),(2,3)]
     [99]->[(3,0),(3,1)]
     
     
     JCetkovsky@walmartlabs.com
     
     
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
     
     [101, 102, 102, 100, 0]
     [198, 100, 100, 100, 0]
     
     ramati
 * 
 * @author <a href="santhosh.g@leantaas.com">Santhosh Gandhe</a>
 * @version $Revision: 1.0 $, $Date: Aug 6, 2014
 */
public class CopyOfTriangleTraversalSolution {

    public static void main(String ar[]){
        
        int height=5;
        int[][] mat = new int[height][height];
        mat[0]=new int[]{1,0,0,0,0};
        mat[1]=new int[]{1,2,0,0,0};
        mat[2]=new int[]{1,2,2,0,0};
        mat[3]=new int[]{99,99,99,99,0};
        mat[4]=new int[]{99,99,1,1,1};
        
        //Initialized 
        int[] sum = new int[]{99,99,1,1,1};
        
        for(int i=height-2;i>=0;i--){
            for(int counter=0;counter<i+1;counter++) {
            if(mat[i][counter]+sum[counter] < mat[i][counter]+sum[counter+1]){
                sum[counter]=mat[i][counter]+sum[counter];
            }else{
                sum[counter]=mat[i][counter]+sum[counter+1];
            }
          }
           
         
       }
        System.out.println(sum[0]);
    }
}
