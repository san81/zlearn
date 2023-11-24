package com.san.weekly306;

import org.junit.Assert;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 *6149. Node With Highest Edge Score
 * User Accepted:7031
 * User Tried:8083
 * Total Accepted:7110
 * Total Submissions:17046
 * Difficulty:Medium
 * You are given a directed graph with n nodes labeled from 0 to n - 1, where each node has exactly one outgoing edge.
 *
 * The graph is represented by a given 0-indexed integer array edges of length n, where edges[i] indicates that there is a directed edge from node i to node edges[i].
 *
 * The edge score of a node i is defined as the sum of the labels of all the nodes that have an edge pointing to i.
 *
 * Return the node with the highest edge score. If multiple nodes have the same edge score, return the node with the smallest index.
 */

public class HighestEdgeCount {


    public int edgeScore(int[] edges) {
        Map<Integer, Integer> edgeCount = new TreeMap<>(Comparator.naturalOrder());
        int maxEdgeCount = -1;
        int maxEdge = Integer.MAX_VALUE;
        for(int i=0;i<edges.length; i++) {
            int existingValue = edgeCount.getOrDefault(edges[i], 0);
            edgeCount.put(edges[i], i+existingValue);
        }

        for(Map.Entry<Integer, Integer> entry:edgeCount.entrySet()) {
            if(entry.getValue()>maxEdgeCount) {
                maxEdgeCount = entry.getValue();
                maxEdge = entry.getKey();
            }
        }
        return maxEdge;
    }

    public static void main(String[] args) {
        HighestEdgeCount highestEdgeCount = new HighestEdgeCount();
        Assert.assertEquals(7, highestEdgeCount.edgeScore(new int[]{1,0,0,0,0,7,7,5}));
        Assert.assertEquals(0, highestEdgeCount.edgeScore(new int[]{2, 0, 0, 2}));
        Assert.assertEquals(1, highestEdgeCount.edgeScore(new int[]{1, 0, 1, 1, 1, 1, 1}));
    }
}
