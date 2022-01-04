package com.san.weekly232;

import java.util.HashMap;
import java.util.Map;

public class FindCenterOfGraph {
    public int findCenter(int[][] edges) {
        Map<Integer, Integer> vdegree = new HashMap<>();
        int maxEdge = -1;
        int maxDegree = 0;
        for(int[] edge :edges){
            int source = vdegree.getOrDefault(edge[0],0);
            int dest = vdegree.getOrDefault(edge[1],0);
            vdegree.put(edge[0], ++source);
            vdegree.put(edge[1], ++dest);
            if(source>maxDegree){
                maxDegree = source;
                maxEdge = edge[0];
            }
            if(dest>maxDegree){
                maxDegree = dest;
                maxEdge = edge[1];
            }
        }
        return maxEdge;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{1,2},{2,3},{4,2}};
        edges = new int[][]{{1,2},{5,1},{1,3},{1,4}};
        System.out.println(new FindCenterOfGraph().findCenter(edges));
    }
}
