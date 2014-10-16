
package com.san.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class DFS {

    int vcount=8;
    int[][] adjMat = new int[vcount][vcount];
    List<Vertex> vertexes = new ArrayList<Vertex>();
    Stack<Integer> stack=new Stack<Integer>();
    
    public DFS(){
        adjMat[0][1]=1;
        adjMat[1][2]=1;
        adjMat[1][7]=1;
        adjMat[2][1]=1;
        adjMat[2][3]=1;
        adjMat[2][4]=1;
        adjMat[3][2]=1;
        adjMat[4][2]=1;
        adjMat[4][5]=1;
        adjMat[4][6]=1;
        adjMat[4][7]=1;
        adjMat[5][4]=1;
        adjMat[6][4]=1;
        adjMat[7][1]=1;
        adjMat[7][4]=1;
        char vnames[] = {'q','b','c','d','e','f','g','h'};
        for(int i=0;i<8;i++){
            Vertex v =new Vertex();
            v.name=vnames[i];
            vertexes.add(v);
        }
    }
    
    public void dfs(){
            vertexes.get(0).visited=true;
            System.out.println(vertexes.get(0).name+"->");
            stack.push(0);
            while(!stack.isEmpty()){
                int vAdj = getAdjUnvisitedVertex(stack.peek());
                if(vAdj==-1){
                    stack.pop();
                }else{
                    vertexes.get(vAdj).visited=true;
                    System.out.println(vertexes.get(vAdj).name+"->");
                    stack.push(vAdj);
                }
            }
    }
    
    public void bfs(){
        Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
        vertexes.get(0).visited=true;
        System.out.println(vertexes.get(0).name+"->");
        queue.add(0);
        while(!queue.isEmpty()){
            int v = queue.poll();
            for(int j=0;j<vcount;j++){
                if(adjMat[v][j]==1 && vertexes.get(j).visited==false){
                    System.out.println(vertexes.get(j).name+"->");
                    vertexes.get(j).visited=true;
                    queue.add(j);
                }
            }
        }
  }
    
    public int getAdjUnvisitedVertex(int v){
        for(int j=0;j<vcount;j++){
            if(adjMat[v][j]==1 && vertexes.get(j).visited==false){
                return j;
            }
        }
        return -1;
    }
    
    public static void main(String ar[]){
        DFS dfs = new DFS();
        dfs.bfs();
    }
}

class Vertex{
    char name;
    boolean visited=false;
}