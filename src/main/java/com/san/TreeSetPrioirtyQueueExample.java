package com.san;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeSet;

public class TreeSetPrioirtyQueueExample {

    /**
     * Red-black tree algo based self balancing Binary Tree.
     * add, remove and contains operations are of O(log n) time complexity.
     * Best and Worst case time complexity is O(log n) as well.
     *
     * Use TreeSet when you need elements to be sorted as you add or removed.
     * Your interest is to maintain an order in how the elements are retrieved.
     */
    public static void treeSetOperations() {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(10);
        ts.add(13);
        ts.add(5);
        ts.add(7);
        ts.add(2);
        ts.add(3);
        System.out.println(ts);
        ts.remove(5);
        System.out.println(ts);
        ts.add(12);
        System.out.println(ts);
    }

    /**
     * Heap data structure based Binary Tree.
     * add, remove and contains operations are of O(log n) time complexity.
     *
     *
     * Use TreeSet when you need elements to be sorted as you add or removed.
     * Your interest is to maintain an order in how the elements are retrieved.
     */
    public static void priorityQueueOperations() {
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        Queue<Integer> ps = new PriorityQueue<>(comp);
        ps.add(10);
        ps.add(13);
        ps.add(5);
        ps.add(7);
        ps.add(2);
        ps.add(3);
        System.out.println("PriorityQueue "+ps);
        ps.remove(13);
        System.out.println("After remove "+ps);
        ps.add(23);
        System.out.println("Add an element "+ps);
    }
    public static void main(String[] args) {
        treeSetOperations();
        priorityQueueOperations();
    }
}
