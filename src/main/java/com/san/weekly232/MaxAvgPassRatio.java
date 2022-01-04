package com.san.weekly232;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxAvgPassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<double[]> prq = new PriorityQueue<>(Comparator.comparingDouble(o -> -o[0]));
        for(int[] cls:classes){
            double a = cls[0], b = cls[1];
            prq.offer(new double[]{profit(a, b), a, b});
        }
        while(extraStudents -->0){
            double[] head = prq.poll();
            double a = head[1], b = head[2];
            prq.offer(new double[]{profit(a+1, b+1), a+1, b+1});
        }
        double ans = 0.0d;
        while(!prq.isEmpty()){
            double[] head = prq.poll();
            double a = head[1], b = head[2];
            ans += a/b;
        }
        return ans/classes.length;
    }

    public double profit(double a, double b) {
        return (a+1)/(b+1) - a/b;
    }

    public static void main(String[] args) {
        int[][] classes = new int[][]{{1,2},{3,5},{2,2}};
        int extraStudents = 2;
        System.out.println(new MaxAvgPassRatio().maxAverageRatio(classes, extraStudents));
    }
}
