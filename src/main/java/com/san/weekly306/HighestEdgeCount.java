package com.san.weekly306;

import org.junit.Assert;

import java.util.LinkedHashMap;
import java.util.Map;

public class HighestEdgeCount {
    public int edgeScore(int[] edges) {
        Map<Integer, Integer> edgeCount = new LinkedHashMap<>();
        int maxEdgeCount = 0;
        int maxEdge = Integer.MAX_VALUE;
        for(int i=0;i<edges.length; i++) {
            int existingValue = edgeCount.getOrDefault(edges[i], 0);
            edgeCount.put(edges[i], i+existingValue);
            if(maxEdgeCount < i+existingValue) {
                maxEdgeCount = i+existingValue;
                if(maxEdge > edges[i]){
                    maxEdge = edges[i];
                }
            }
        }
        return maxEdge;
    }

    public static void main(String[] args) {
        HighestEdgeCount highestEdgeCount = new HighestEdgeCount();
        Assert.assertEquals(highestEdgeCount.edgeScore(new int[]{1,0,0,0,0,7,7,5}), 7);
    }
}
