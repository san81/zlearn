
package com.san.learn;

import java.util.Arrays;

/**
 * [ 1 , 3 , -2 , 0 , 4 , -2 , -1 , 8 ] ==> [ 1 , 3 , 0 , 4, 8 , -2 , -2 , -1]
  0   1    2   3   4   5    6    7

counter = 3

pos = 2 val = -2
int temp;
int lastSwapPos;

for(int i=length;i>length-counter;i--){
    if(ar[i]>0){
      temp=ar[i-1];
      ar[i-1]=ar[i];
      ar[i]=temp;
      lastSwapPos=i;
    }
}

for(int i=length-counter;i>=0;i--){
    if(ar[i]<0){
      for(int j=i;j<lastSwapPos;j++){
          temp=ar[j];
          ar[j+1]=ar[j];
          ar[j]=temp;
      } 
      ar[lastSwapPos]=ar[i];
      lastSwapPos--;
    }
}
 * 
 * @author <a href="santhosh.g@leantaas.com">Santhosh Gandhe</a>
 * @version $Revision: 1.0 $, $Date: Jul 30, 2014
 */
public class CopyOfAZQuestion_pos_neg {
    
    public static void main(String arg[]){
        int[] ar= new int[]{ 1 , 3 , -2 , 0 , 4 , -2 , -1 , 8,9 } ;
        
       
        int negCount=3;
        int negIndex =(ar.length-negCount)-1;
        int posIndexEnd =negIndex;
        
        
       for(int i=0;i<=posIndexEnd;i++){
           if(ar[i]<0){
               System.out.println(i+" before "+ar[i]+Arrays.toString(ar));
               //swap with negative location.
               int tmp=ar[i];
               ar[i]=ar[negIndex];
               ar[negIndex]=tmp;
               negIndex++;
               if(ar[i]<0){
                   i--;
               }
               System.out.println(i+" after "+ar[i]+Arrays.toString(ar));
           }
       }
        
        System.out.println(Arrays.toString(ar));
        
        
    }
    

    public static void main1(String arg[]){
        int[] ar= new int[]{ 1 , 3 , -2 , 0 , 4 , -2 , -1 , 8,9 } ;
        
        int lastSwapPos=5;
        int temp;
        int length=ar.length-1;
        int counter=3;
        
        
        for(int i=length;i>length-counter+1;i--){
            if(ar[i]>0){
              temp=ar[i-1];
              ar[i-1]=ar[i];
              ar[i]=temp;
              lastSwapPos=i;
              
              System.out.println(Arrays.toString(ar));
            }
        }
        
        System.out.println(Arrays.toString(ar));

        for(int i=length-counter;i>=0;i--){
            if(ar[i]<0){
                temp=ar[i];
              for(int j=i;j<lastSwapPos;j++){
                 ar[j]=ar[j+1];
              } 
              ar[lastSwapPos]=temp;
              lastSwapPos--;
            }
        }
        
        System.out.println(Arrays.toString(ar));
        
        
    }
    
    
    
    public static void main__(String arg[]){
        int[] ar= new int[]{ -12,1 , 3 , -2 , 0 , 4 , -2 , -1 , 8,9,-4 } ;
        
        int lastSwapPos=5;
        int temp;
        int length=ar.length-1;
        int counter=5;
        
        
       for(int i=0;i<=length-counter+1;i++){
           if(ar[i]<0){
               System.out.println(i+" before "+ar[i]+Arrays.toString(ar));
               temp=ar[i];
               for(int j=i;j<length;j++){
                   ar[j]=ar[j+1];
               }
               ar[ar.length-1]=temp;
               System.out.println(i+" after "+ar[i]+Arrays.toString(ar));
               
               if(ar[i]<0 && i<length-counter){
                   i--;
               }
              /* if(i>length-counter-1){
                   break;
               }*/
           }
       }
        
        System.out.println(Arrays.toString(ar));
        
        
    }
    
}
