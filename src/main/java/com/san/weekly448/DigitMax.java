package com.san.weekly448;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

public class DigitMax {
    public int maxProduct(int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        if(n==0) return 0;
        while(n>0) {
            int digit = n%10;
            n = n/10;
            maxHeap.add(digit);
        }
        System.out.println(maxHeap.size());
        if(maxHeap.size()==1) {
            return maxHeap.poll();
        }
        return maxHeap.poll() * maxHeap.poll();
    }

    public static void main(String[] args) {
        DigitMax dm = new DigitMax();
        assertEquals(3, dm.maxProduct(31));
        assertEquals(4, dm.maxProduct(22));
        assertEquals(0, dm.maxProduct(0));
        assertEquals(1, dm.maxProduct(1));
        assertEquals(0, dm.maxProduct(100));
    }
}
