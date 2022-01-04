package com.san.learn;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BasicStackTest {
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println(s.peek());
        System.out.println(s.pop());
        System.out.println(s.peek());


        Queue<Integer> queue = new PriorityQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.peek());

    }
}
