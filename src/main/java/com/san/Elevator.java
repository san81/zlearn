package com.san;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This question asked in Sigma Computing interview
 */
public class Elevator {
    int currentFloor=0;
    Queue<Integer> upQueue = new PriorityQueue<>();
    Queue<Integer> downQueue = new PriorityQueue<>(Collections.reverseOrder());

    String direction = "DOWN";

    public void requestStop(int floorNumber){


        if(direction.equals("UP")) {
            if(this.currentFloor<floorNumber) {
                upQueue.add(floorNumber);
                System.out.println("Request added to UP queue: "+floorNumber);
            }else{
                downQueue.add(floorNumber);
                System.out.println("Request added to DOWN queue: "+floorNumber);
            }

        }else{
            if(this.currentFloor>floorNumber) {
                downQueue.add(floorNumber);
                System.out.println("Request added to DOWN queue: "+floorNumber);
            }else {
                upQueue.add(floorNumber);
                System.out.println("Request added to UP queue: "+floorNumber);
            }

        }

       adjustDirection();
    }

    private void adjustDirection() {
        if(this.upQueue.isEmpty() && !this.downQueue.isEmpty()) {
            direction = "DOWN";
        } else if(!this.upQueue.isEmpty() && this.downQueue.isEmpty()) {
            direction = "UP";
        }
    }

    public int reachedAFloor() {
        int floorReached = 0;
        if(direction.equals("UP")) {
            floorReached = upQueue.poll();
        }else {
            floorReached = downQueue.poll();
        }
        System.out.println("Reached %s queue floor: %d".formatted(this.direction, floorReached));
        this.currentFloor = floorReached;
        adjustDirection();
        return floorReached;
    }

    public static void main(String[] args) {
        Elevator ele = new Elevator();
        ele.requestStop(5);
        ele.requestStop(2);
        ele.requestStop(3);
        ele.reachedAFloor();
        ele.reachedAFloor();
        ele.requestStop(2);
        ele.reachedAFloor();
        ele.reachedAFloor();
        ele.requestStop(4);
        ele.requestStop(1);
        ele.reachedAFloor();
        ele.reachedAFloor();
    }

}
