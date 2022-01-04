package com.san.amazon.trees;

import java.util.ArrayList;
import java.util.List;

public class CutOffTreeFromGolfCourt {



    public int cutOffTree(List<List<Integer>> forest) {
        int r = 0;
        int c = 0;
        int rows = forest.size();
        int cols = forest.get(0).size();
        int steps = 0;
        while(forest.get(r).get(c)!=0) {
            steps++;
            forest.get(r).set(c, 0);
            int top = r > 0 ? forest.get(r-1).get(c) : Integer.MAX_VALUE;
            int down = r < rows-1 ? forest.get(r+1).get(c) : Integer.MAX_VALUE;
            int left = c >0 ? forest.get(r).get(c-1) : Integer.MAX_VALUE;
            int right = c < cols-1 ? forest.get(r).get(c+1) : Integer.MAX_VALUE;
            if(top==0 && down==0 && left==0 && right==0) {
                //There is no where to go
                break;
            }
            if(top==0) top = Integer.MAX_VALUE;
            if(down==0) down = Integer.MAX_VALUE;
            if(left==0) left = Integer.MAX_VALUE;
            if(right==0) right = Integer.MAX_VALUE;
            int nextNodeToGo = Math.min(Math.min(top, down), Math.min(left, right));
            if(nextNodeToGo == top && r>0) r--;
            else if(nextNodeToGo == down && r<rows-1) r++;
            else if(nextNodeToGo == left && c>0) c--;
            else if(nextNodeToGo == right && c<cols-1) c++;
        }
        for(int i=0;i<forest.size();i++){
            for(int j=0;j<forest.get(i).size(); j++){
                if(forest.get(i).get(j)!=0){
                    return -1;
                }
            }
        }
        return steps-1;
    }

    public static void main(String[] args) {
        List<List<Integer>> forest = new ArrayList<>();
        //forest = [[2,3,4],[0,0,5],[8,7,6]]
        forest.add(new ArrayList<Integer>(){{add(2); add(3); add(4);}});
        forest.add(new ArrayList<Integer>(){{add(0); add(0); add(5);}});
        forest.add(new ArrayList<Integer>(){{add(8); add(7); add(6);}});
        System.out.println(new CutOffTreeFromGolfCourt().cutOffTree(forest));
    }
}
