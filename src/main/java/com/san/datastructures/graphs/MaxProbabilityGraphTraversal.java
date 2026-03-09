package com.san.datastructures.graphs;

import java.util.*;

import com.san.amazon.trees.Pair;

public class MaxProbabilityGraphTraversal {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        Map<Integer, List<Object[]>> adjMap = new HashMap<>();
        for(int i=0;i<edges.length;i++) {
            int[] edge = edges[i];
            adjMap.computeIfAbsent(edge[0], e->new ArrayList<>()).add(new Object[]{edge[1],succProb[i]});
            //adjMap.computeIfAbsent(edge[1], e->new ArrayList<>()).add(new Object[]{edge[0],succProb[i]});
        }

        double[] answer = new double[n];
        Queue<Pair<Integer, Double>> queue = new ArrayDeque<>();
        queue.add(new Pair(start_node, 0.0));

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                Pair p = queue.poll();
                int node = (int)p.getKey();
                double prob = (double)p.getValue();
                if(node == end_node) {
                    return answer[node];
                }
                if(null!=adjMap.get(node)) {
                    for(Object[] edge: adjMap.get(node)) {
                        int nextNode = (int)edge[0];
                        double nextProb = (double)edge[1];
                        if(prob+nextProb > answer[nextNode]) {
                            answer[nextNode] = prob+nextProb;
                            queue.add(new Pair(nextNode, prob+nextProb));
                        }
                    }
                }

            }
        }
        return 0;
    }
}