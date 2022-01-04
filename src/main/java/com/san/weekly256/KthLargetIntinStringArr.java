package com.san.weekly256;

import org.junit.Assert;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargetIntinStringArr {
    public int compare(String o1, String o2) {
        if(o1.length()==o2.length()) {
            return o1.compareTo(o2);
        }
        return o1.length()-o2.length();
    }
    public int quickSort(String[] input, int start, int end, int k) {
        if (start >= end) {
            return end;
        }
        String pivot = input[start];
        int left = start + 1;
        int right = end;
        String tmp;
        while (left < right) {
            while (left<input.length && compare(input[left], pivot)<0) {
                ++left;
            }
            while (right>0 && compare(input[right], pivot)>0) {
                --right;
            }

            if (left < right) {
                tmp = input[left];
                input[left] = input[right];
                input[right] = tmp;
            }
        }
        //swap pivot element
        input[start]=input[right];
        input[right]=pivot+"";

        System.out.println("before recursive call left="+left+",right="+right+" :: "+ Arrays.toString(input));

        if(k<right) {
            return quickSort(input, start, right-1, k);
        }else if(k>right){
            return quickSort(input, right+1,end, k);
        }
        return right;
    }



    public String kthLargestNumber(String[] nums, int k) {
        Queue<String> queue = new PriorityQueue<>(k, (o1, o2) -> {
            if(o1.length()==o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length()-o2.length();
        });


        for(String s:nums) {
            queue.offer(s);
            if(queue.size()>k){
                queue.poll();
            }
        }
        return queue.poll();

//        int pivot = quickSort(nums, 0, nums.length-1, nums.length-k);
//        return nums[pivot];

    }

    public static void main(String[] args) {
        KthLargetIntinStringArr klis = new KthLargetIntinStringArr();
        Assert.assertEquals("6", klis.kthLargestNumber(new String[]{"3","6","7","10"}, 3));
        Assert.assertEquals("695", klis.kthLargestNumber(new String[]{"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"}, 11));
    }
}
