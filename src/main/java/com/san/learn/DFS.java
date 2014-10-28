
package com.san.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class DFS {

    int vcount=11;
    int[][] adjMat = new int[vcount][vcount];
    List<Vertex> vertexes = new ArrayList<Vertex>();
    Stack<Integer> stack=new Stack<Integer>();
    
    public void DFS_(){
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
        char vnames[] = {'a','b','c','d','e','f','g','h'};
        for(int i=0;i<vnames.length;i++){
            Vertex v =new Vertex();
            v.name=vnames[i];
            vertexes.add(v);
        }
    }
    
    
    public  DFS(){
        adjMat[0][1]=1;
        adjMat[0][4]=1;
        adjMat[1][2]=1;
        adjMat[2][3]=1;
        adjMat[2][8]=1;
        adjMat[4][5]=1;
        adjMat[4][7]=1;
        adjMat[5][6]=1;
        adjMat[5][8]=1;
        adjMat[6][10]=1;
        adjMat[7][6]=1;
        adjMat[8][9]=1;
        char vnames[] = {'a','b','c','d','e','f','g','h','i','j','k'};
        
        for(int i=0;i<vnames.length;i++){
            Vertex v =new Vertex();
            v.name=vnames[i];
            vertexes.add(v);
        }
    }
    
    public void dfsRecursive(int currentNode){
        vertexes.get(currentNode).visited=true;
        System.out.println(vertexes.get(currentNode).name+"->");
        for(int j=0;j<vcount;j++){
            if(adjMat[currentNode][j]==1 && vertexes.get(j).visited==false){
                dfsRecursive(j);
            }
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
        dfs.dfsRecursive(0);
        System.out.println("BFS :: ");
        new DFS().bfs();
    }
}

class Vertex{
    char name;
    boolean visited=false;
}