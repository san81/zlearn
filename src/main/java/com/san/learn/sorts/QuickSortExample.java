
package com.san.learn.sorts;

import java.util.Arrays;

public class QuickSortExample {

    public static void main(String ar[]){
        int[] input=new int[]{4,6,2,8,1,9,3,5};
        System.out.println("Source Array :: "+Arrays.toString(input));
        quickSort(input,0,input.length-1);
        System.out.println("After sort :: "+Arrays.toString(input));
    }
    
    public static void quickSort(int[] input, int start, int end) {
        if(start>=end){
            return;
        }
        int pivot=input[start];
        int left=start+1;
        int right=end;
        int tmp;
        while(left<right) {
            while(input[left]<pivot){
                ++left;
            }
            while(input[right]>pivot){ 
                --right;
            }
            
            if(left<right){
                tmp=input[left];
                input[left]=input[right];
                input[right]=tmp;
            }
        }
        
        //swap pivot element
        input[start]=input[right];
        input[right]=pivot;
        
        System.out.println("before recursive call left="+left+",right="+right+" :: "+Arrays.toString(input));
        
        quickSort(input, start, right-1);
        quickSort(input, right+1,end);
    }
}
