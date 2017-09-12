package com.san.learn;


/**
 * [10,    2,4,5, 8, 9]
 * [9,10,   2,4, 5, 8]
 *
 * [8,9,10,  2,4,5]
 * [8,9,10,  2,4,5]
 */

public class RotatedSortedArrayBinarySearch {

    public static void main(String ar[]){
        int[] arr = {40,50,60,70,1,2,12,31,34};
        System.out.print("*****: "+find(arr,1));
    }



    static int find(int[] arr, int target) {

        int max=arr.length-1;
        int mid=max/2;
        int splitIndex = findSplitIndex(arr, 0,max);
        if (splitIndex < 0) {
            splitIndex = arr.length / 2;
        }

        int foundIndex = findUsingBS(arr, target, 0, splitIndex - 1);
        if (foundIndex==-1) {
            foundIndex = findUsingBS(arr, target, splitIndex, arr.length);
        }
        return foundIndex;
    }

    static int findUsingBS(int[] arr, int target, int min, int max) {

        if (min == max) {
            return -1;
        }

        int mid = (min + max)/ 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return findUsingBS(arr, target, min, mid);
        } else {
            return findUsingBS(arr, target, mid+1, max);
        }
    }


    static int findSplitIndex(int[] arr, int min, int max) {

        if (min == max) {
            return -1;
        } else if(max==min+1){
            return arr[min]-arr[max];
        }


        int mid = (min+max)/2;
        //compare the edges of each half
        if (arr[mid] < arr[mid-1]) {
            //this is the splitting point
            return mid;
        } else {
            int splitIndex = findSplitIndex(arr, 0, mid );
            if (splitIndex < 0) {
                splitIndex = findSplitIndex(arr, mid+1, max);
            }
            return splitIndex;
        }

    }
}
