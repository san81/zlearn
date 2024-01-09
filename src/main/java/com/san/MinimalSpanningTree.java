package com.san;

import org.junit.Assert;

import java.util.*;

class NodeWeight<K, V> {
    K key;
    V value;

    public NodeWeight(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
}

class MinimalSpanningTree {
    public int minimumCost(int n, int[][] connections) {
        Map<Integer, List<NodeWeight<Integer, Integer>>> graph = new HashMap<>();
        for(int[] con:connections){
            int sourceVertex = con[0];
            int destVertex = con[1];
            int weight = con[2];
            graph.putIfAbsent(sourceVertex, new ArrayList<>());
            graph.putIfAbsent(destVertex, new ArrayList<>());
            graph.get(sourceVertex).add(new NodeWeight(destVertex, weight));
            graph.get(destVertex).add(new NodeWeight(sourceVertex, weight));
        }

        Queue<NodeWeight<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<NodeWeight<Integer, Integer>>(){
            public int compare(NodeWeight<Integer, Integer> p1, NodeWeight<Integer, Integer> p2) {
                return p1.getValue() - p2.getValue();
            }
        });

        queue.add(new NodeWeight<Integer, Integer>(connections[0][0], 0));
        Set<Integer> visited = new HashSet<>();
        int cost = 0;
        while(!queue.isEmpty()) {
            NodeWeight<Integer, Integer> curNodeWght = queue.poll();
            int currentNode = curNodeWght.getKey();
            if(visited.contains(currentNode))
                continue;
            visited.add(currentNode);
            cost += curNodeWght.getValue();
            for(NodeWeight<Integer, Integer> adjNode:graph.get(currentNode)){
                if(!visited.contains(adjNode.getKey())) {
                    queue.add(adjNode);
                }
            }
        }

        return visited.size()==n?cost:-1;
    }

    public static void main(String[] args) {
        int n = 5;
        MinimalSpanningTree msp = new MinimalSpanningTree();
        Assert.assertEquals(6, msp.minimumCost(3, new int[][]{{1,2,5},{1,3,6},{2,3,1}}), 6);
        Assert.assertEquals(-1, msp.minimumCost(4, new int[][]{{1,2,3},{3,4,4}}), -1);
        Assert.assertEquals(166998, msp.minimumCost(5, new int[][]{{2,1,50459},{3,2,47477},{4,2,52585},{5,3,16477}}));
    }
}