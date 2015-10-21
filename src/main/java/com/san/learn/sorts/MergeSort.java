
package com.san.learn.sorts;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] ar=new int[]{6,4,8,2,9,3,10,9,15,12,13};
        mergeSort(ar,0,ar.length-1);
        System.out.println(Arrays.toString(ar));
    }

    public static void mergeSort(int[] ar, int start, int end){
        if(start==end){
            return;
        }
        if(start+1==end){
            if(ar[end]<ar[start]){
                int temp=ar[start];
                ar[start]=ar[end];
                ar[end]=temp;
            }
            return;
        }
        
        int mid=(start+end)/2;
        mergeSort(ar,start,mid);
        mergeSort(ar,mid+1,end);
        merge(ar,start,mid,end);
    }
    
    public static void merge(int[] ar, int start, int mid, int end){
        int arcp[] = new int[ar.length];
        int ar1=start;
        int ar2=mid+1;
        int i =start;
        for( ;  ar1<=mid && ar2<=end;i++){
            if(ar[ar2]<ar[ar1]){
                arcp[i]=ar[ar2];
                ar2++;
            }else {
                arcp[i]=ar[ar1];
                ar1++;
            }
        }
       
        if(ar1<=mid){
            for(;ar1<=mid;ar1++){
                arcp[i++]=ar[ar1];
            }
        }else if(ar2<=end){
            for(;ar2<=end;ar2++){
                arcp[i++]=ar[ar2];
            }
        }
        
        for( i=start;i<=end;i++){
            ar[i]=arcp[i];
        }
    }
}
