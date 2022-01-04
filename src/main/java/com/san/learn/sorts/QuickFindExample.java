
package com.san.learn.sorts;

import java.util.Arrays;

public class QuickFindExample {

    public static void main(String ar[]){
        int[] input=new int[]{4,6,2,8,1,9,3,5};
        System.out.println("Source Array :: "+Arrays.toString(input));
        boolean found = quickFind(input,0,input.length-1, 8);
        System.out.println("Given element found? "+found);
    }
    
    public static boolean quickFind(int[] input, int start, int end, int numToFind) {
        if(start>=end){
            return false;
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
        if(numToFind==pivot) {
            return true;
        }
        if(numToFind<pivot)
            return quickFind(input, start, right-1, numToFind);
        if(numToFind>pivot)
            return quickFind(input, right+1,end, numToFind);
        return false;
    }
}
