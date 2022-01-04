package com.san.google.graphs;

import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Longest Increasing Path in a Matrix
 *
 * Solution
 * Given an m x n integers matrix, return the length of the longest increasing path in matrix.
 *
 * From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 *
 *
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 200
 * 0 <= matrix[i][j] <= 231 - 1
 */
public class LongestIncreasingPath {

    int rows;
    int cols;

    public int dfs(int[][] matrix, int r, int c,  List<Integer> list, int[][] mem) {

        if(mem[r][c]!=0) {
            return mem[r][c];
        }

        list.add((matrix[r][c]));


        if(r-1>=0 && matrix[r-1][c]>matrix[r][c]) {
            mem[r][c] = Math.max(mem[r][c], dfs(matrix, r-1, c, list, mem));
        }

        if(r+1<rows && matrix[r+1][c]>matrix[r][c]) {
            mem[r][c] = Math.max(mem[r][c], dfs(matrix, r + 1, c, list, mem));
        }

        if(c-1>=0 && matrix[r][c-1]>matrix[r][c]) {
            mem[r][c] = Math.max(mem[r][c], dfs(matrix, r, c - 1, list, mem));
        }

        if(c+1<cols && matrix[r][c+1]>matrix[r][c]) {
            mem[r][c] = Math.max(mem[r][c], dfs(matrix, r, c + 1, list, mem));
        }

//        list.remove(list.size()-1);
        return ++mem[r][c] ;
    }
    public int longestIncreasingPath(int[][] matrix) {


        if(matrix==null || matrix.length==0){
            return 0;
        }
        int ans = 0;
        rows = matrix.length;
        cols = matrix[0].length;
        int[][] mem = new int[matrix.length][matrix[0].length];

        for(int i=0;i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                List<Integer> l = new ArrayList<>();
                ans = Math.max(ans, dfs(matrix, i, j, l, mem));
                if(l.size()==ans)
                    System.out.println("r:"+i+" c:"+j+" Chain:"+l + " ans:"+ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestIncreasingPath lip = new LongestIncreasingPath();
        Assert.assertEquals(4, lip.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
        Assert.assertEquals(4, lip.longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
        Assert.assertEquals(1, lip.longestIncreasingPath(new int[][]{{1}}));
        Assert.assertEquals(4, lip.longestIncreasingPath(new int[][]{{7,7,5},{2,4,6},{8,2,0}}));
        Assert.assertEquals(5, lip.longestIncreasingPath(new int[][]{{2,8,6,0,4,14},{15,3,5,0,10,12},{10,13,14,5,11,16},{7,8,16,11,15,13},{19,10,7,13,0,11},{16,19,7,3,6,11},{7,2,5,9,0,19},{14,11,8,8,14,11},{4,5,10,4,2,12}}));
    }
}
