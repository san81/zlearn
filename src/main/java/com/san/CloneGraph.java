package com.san;


import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


class CopyGraph {
    private HashMap <Node, Node> visited = new HashMap <> ();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // If the node was already visited before.
        // Return the clone from the visited dictionary.
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a clone for the given node.
        // Note that we don't have cloned neighbors as of now, hence [].
        Node cloneNode = new Node(node.val, new ArrayList());
        // The key is original node and value being the clone node.
        visited.put(node, cloneNode);

        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}

public class CloneGraph {

    public static void print(Node n) {
        Stack<Node> s = new Stack<>();
        Set<Node> visisted = new HashSet<>();
        s.add(n);
        while(!s.isEmpty()) {
            Node curNode = s.pop();
            System.out.print(curNode.val+"->");
            visisted.add(curNode);
            for(Node nei:curNode.neighbors){
                if(!visisted.contains(nei)){
                    visisted.add(nei);
                    s.add(nei);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        //[[2,4],[1,3],[2,4],[1,3]]
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        print(n1);

        CopyGraph cg = new CopyGraph();
        Node copy = cg.cloneGraph(n1);

        print(copy);
    }
}
