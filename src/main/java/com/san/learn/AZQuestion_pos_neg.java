
package com.san.learn;

import java.util.Arrays;

/**
 * [ 1 , 3 , -2 , 0 , 4 , -2 , -1 , 8 ] ==> [ 1 , 3 , 0 , 4, 8 , -2 , -2 , -1]
  0   1    2   3   4   5    6    7

counter = 3


 * 
 * @author <a href="santhosh.g@leantaas.com">Santhosh Gandhe</a>
 * @version $Revision: 1.0 $, $Date: Jul 30, 2014
 */
public class AZQuestion_pos_neg {
    
    public static void main(String arg[]){
        
        int[] ar= new int[]{ 1 , 3 , -2 , 0 , 4 , -2 , -1 , 8,9 } ;
        
       
        int negCount=3;
        int negIndex =(ar.length-negCount)-1;
        int numOfIterations =ar.length-1;
        
        int posIndex=0;
        
        
       for(int i=0;i<=numOfIterations && negIndex<ar.length;i++){
           while(negIndex+1<ar.length && ar[negIndex]<0){
               negIndex++;
           }
           while(posIndex<ar.length && ar[posIndex]>0){
               posIndex++;
           }
           System.out.println(i+" before "+ar[i]+Arrays.toString(ar));
         
               //swap with positive index location.
               int tmp=ar[posIndex];
               ar[posIndex]=ar[negIndex];
               ar[negIndex]=tmp;
         
           System.out.println(i+" after "+ar[i]+Arrays.toString(ar));
       }
        
        System.out.println(Arrays.toString(ar));
        
        
    }
    

   
    
}
