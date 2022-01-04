package com.san.amazon;

import org.junit.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {
    public int findRoot(int i, int[] root) {
        while(i!=root[i]) {
            i = root[i];
        }
        return i;
    }

    public void union(int i, int j, int[] root) {
        int rootI = findRoot(i, root);
        int rootJ = findRoot(j, root);
        if(rootI!=rootJ) {
            for(int r=0;r<root.length;r++){
                if(root[r]==rootJ) {
                    root[r] = rootI;
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int[] root = new int[isConnected.length];

        for(int i=0;i<root.length;i++){
            root[i]=i;
        }

        for(int i=0;i<isConnected.length;i++) {
            for(int j=0;j<isConnected[i].length;j++) {
                if(isConnected[i][j]==1) {
                    if(root[j]!=j){
                        //there is an existing parent here
                        union(i, j, root);
                    }else {
                        root[j] = findRoot(i, root);
                    }
                }
            }
        }

        System.out.println(Arrays.toString(root));
        Set<Integer> distinctRoots = new HashSet<Integer>();
        for(int i:root){
            distinctRoots.add(i);
        }
        return distinctRoots.size();
    }

    public static void main(String[] args) {
        NumberOfProvinces nop = new NumberOfProvinces();
//        Assert.assertEquals(2, nop.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
//        Assert.assertEquals(3, nop.findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
//        Assert.assertEquals(8, nop.findCircleNum(new int[][]{{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,0,0,0,0,1,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,1,0,0,0,1,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},{0,0,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,0,0,0,0,0,1,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,1,0,0},{0,1,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1}}));
        Assert.assertEquals(3, nop.findCircleNum(new int[][]{{1,1,0,0,0,0,0,1,0,0,0,0,0,0,0},{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,0,1,1,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,1,1,0,0,0,0},{0,0,0,1,0,1,0,0,0,0,1,0,0,0,0},{0,0,0,1,0,0,1,0,1,0,0,0,0,1,0},{1,0,0,0,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,0,0,0,0,1,0},{0,0,0,0,1,0,0,0,0,1,0,1,0,0,1},{0,0,0,0,1,1,0,0,0,0,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,1,0,1,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,1,0,0,0,0,1}}));
    }
}
