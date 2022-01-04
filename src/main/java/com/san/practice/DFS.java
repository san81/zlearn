package com.san.practice;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by santhoshgandhe on 4/24/19.
 */

class Vertex{
    char name;
    boolean visited=false;
}

public class DFS {

    int vcount = 11;
    int[][] adjMat = new int[vcount][vcount];
    List<Vertex> vertexes = new ArrayList<Vertex>();
    Stack<Integer> stack = new Stack<Integer>();

    public void DFS_() {
        adjMat[0][1] = 1;
        adjMat[1][2] = 1;
        adjMat[1][7] = 1;
        adjMat[2][1] = 1;
        adjMat[2][3] = 1;
        adjMat[2][4] = 1;
        adjMat[3][2] = 1;
        adjMat[4][2] = 1;
        adjMat[4][5] = 1;
        adjMat[4][6] = 1;
        adjMat[4][7] = 1;
        adjMat[5][4] = 1;
        adjMat[6][4] = 1;
        adjMat[7][1] = 1;
        adjMat[7][4] = 1;
        char vnames[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        for (int i = 0; i < vnames.length; i++) {
            Vertex v = new Vertex();
            v.name = vnames[i];
            vertexes.add(v);
        }
    }


    public DFS() {
        adjMat[0][1] = 1;
        adjMat[0][4] = 1;
        adjMat[1][2] = 1;
        adjMat[2][3] = 1;
        adjMat[2][8] = 1;
        adjMat[4][5] = 1;
        adjMat[4][7] = 1;
        adjMat[5][6] = 1;
        adjMat[5][8] = 1;
        adjMat[6][10] = 1;
        adjMat[7][6] = 1;
        adjMat[8][9] = 1;
        char vnames[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'};

        for (int i = 0; i < vnames.length; i++) {
            Vertex v = new Vertex();
            v.name = vnames[i];
            vertexes.add(v);
        }
    }


    public void dfs(){
        vertexes.get(0).visited=true;
        stack.push(0);
        System.out.println(vertexes.get(0)+"-->");
        while(!stack.isEmpty()) {

        }
    }
}
