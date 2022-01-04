package com.san.learn;

import java.util.Arrays;

/**
 * Created by santhoshgandhe on 7/20/19.
 *
 * 1
 *
 * O(log n)
 *
 *
 *
 */
public class TestSorting {

    public static void main(String arg[]) {

        //int a[] = new int[]{5,2,7,3,9,10,1};   //O(n * n)

        int a[] = new int[]{1,2,3,5,7,9,10};

        //binary search O(log n)

        for(int i=0;i<a.length-1;i++){   //O(n)
            if(a[i]>a[i+1]){
                System.out.println("it is not sorted");
                break;
            }
          }

          //Linear sort

        //final sorted output [1,2,3,5,7,9,10]
        int tmp=0;
        for(int i=0; i<a.length-1;i++) {
            tmp=a[i];
            for(int j=i+1; j<a.length; j++) {
                if(tmp>a[j]){
                    int temp=tmp;
                    tmp=a[j];
                    a[j]=temp;
                }
            }
            a[i]=tmp;
        }
         System.out.print(Arrays.toString(a));
    }

    // 1,1,2,3,5, 8, 13.

}
