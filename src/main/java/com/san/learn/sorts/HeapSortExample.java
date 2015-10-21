package com.san.learn.sorts;

import java.util.Arrays;


public class HeapSortExample {
    
    public static void main(String ar[]){
        int[] input=new int[]{4,6,2,8,1,9,3,5};
        System.out.println("Source Array :: "+Arrays.toString(input));
        int end=input.length-1;
        heapify(input);
        System.out.println("After heapify :: "+Arrays.toString(input));
        int tmp;
        while(end>=0){
            tmp=input[end];
            input[end]=input[0];
            input[0]=tmp;
            end--;
            siftDown(input, 0, end);
            System.out.println("When end="+end+" :: "+Arrays.toString(input));
        }
        System.out.println(Arrays.toString(input));
    }

    public static void heapify(int[] input){
        int length=input.length;
        int start = (length-2)/2;
        
        while(start>=0){
            siftDown(input, start, length-1);
            System.out.println("After sift Down start="+start+" :: "+Arrays.toString(input));
            start=start-1;
        }
    }
    
    public static void siftDown(int[] input, int root,  int end ){
       // int root=start;
        int swap;
        int child;
        while(root*2+1<=end){
             swap=root;
             child=root*2+1;
             
             if(input[swap]<input[child]) {
                 swap=child;
             }
             if(child+1<end && input[swap]<input[child+1]){
                 swap=child+1;
             }
             if(swap!=root){
                 int tmp=input[swap];
                 input[swap]=input[root];
                 input[root]=tmp;
                 root=swap;
             }else{
                 return;
             }
        }
    }
}
