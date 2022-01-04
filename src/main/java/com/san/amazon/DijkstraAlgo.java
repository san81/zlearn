package com.san.amazon;

import java.util.*;

public class DijkstraAlgo {

    static class Edge implements Comparable<Edge>{
        char lable = ' ';
        int weight;

        Edge path;

        public Edge(char lable, int weight) {
            this.lable = lable;
            this.weight = weight;
        }

        public Edge(char lable, int weight, Edge path) {
            this.lable = lable;
            this.weight = weight;
            this.path = path;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static void shortestPath(Character sourceNode, Character destinationNode, Map<Character, List<Edge>> adjMat) {
        Queue<Edge> minHeap = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });


        Map<Character, Integer> distance = new HashMap<>();
        Set<Character> settled = new HashSet<>();
        for(Character node:adjMat.keySet()){
            distance.put(node, Integer.MAX_VALUE);
        }
        minHeap.add(new Edge(sourceNode, 0, null));
        int vertexCount = adjMat.size();
        // Until every node is settled
        distance.put(sourceNode, 0);
        Edge destinationEdge = null;
        while(settled.size()!=vertexCount) {

            if(minHeap.isEmpty())
                break;

            Edge nextEdge = minHeap.poll();
            settled.add(nextEdge.lable);
            System.out.println("Processing Node "+nextEdge.lable);

            for(Edge edge:adjMat.get(nextEdge.lable)) {
                if(!settled.contains(edge.lable)){
                    int totalWeight = nextEdge.weight + edge.weight;
                    if(distance.get(edge.lable)>totalWeight) {
                        distance.put(edge.lable, totalWeight);
                        edge.weight = totalWeight;
                        edge.path = nextEdge;
                        if(edge.lable == destinationNode){
                            destinationEdge = edge;
                            break;
                        }
                    }
                    minHeap.add(edge);
                }
            }
        }
        System.out.println(distance);
        if(distance.get(destinationNode)!=null) {
            //we are done with the path
            System.out.println("Distance: "+distance.get(destinationNode));

            while(destinationEdge!=null) {
                System.out.print(destinationEdge.lable+ " --"+destinationEdge.weight+"-->");
                destinationEdge = destinationEdge.path;
            }
        }
    }



    public static void main(String[] args) {
        List<Character> nodes = Arrays.asList('A', 'B','C','D','E', 'F','G');
        Map<Character, List<Edge>> adjMat = new HashMap<Character, List<Edge>>();
        for(Character node:nodes) {
            adjMat.put(node, new ArrayList<>());
        }

        adjMat.get('A').add(new Edge('B', 4));
        adjMat.get('A').add(new Edge('C', 3));
        adjMat.get('A').add(new Edge('E', 7));
        adjMat.get('B').add(new Edge('C', 6));
        adjMat.get('B').add(new Edge('D', 5));
        adjMat.get('C').add(new Edge('D', 11));
        adjMat.get('C').add(new Edge('E', 8));
        adjMat.get('D').add(new Edge('E', 2));
        adjMat.get('D').add(new Edge('F', 2));
        adjMat.get('D').add(new Edge('G', 10));
        adjMat.get('E').add(new Edge('G', 5));
        adjMat.get('F').add(new Edge('G', 3));

        shortestPath('A', 'F', adjMat);
    }




}
