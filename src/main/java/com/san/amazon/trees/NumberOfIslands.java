package com.san.amazon.trees;

public class NumberOfIslands {
    public void dfsWipeOff(int r, int c, char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(r<0 || c<0 || r>=rows || c>=cols || grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        dfsWipeOff(r-1, c, grid);
        dfsWipeOff(r+1, c, grid);
        dfsWipeOff(r, c-1, grid);
        dfsWipeOff(r, c+1, grid);
    }
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0){
            return 0;
        }
        int ilandCounter = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length; j++){
                if(grid[i][j]=='1') {
                    ilandCounter++;
                    dfsWipeOff(i, j, grid);
                }
            }
        }
        return ilandCounter;
    }

    public static void main(String[] args) {
        //char[][] grid = new char[][]{{'1','1','1','1','0'}, {'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
//        char[][] grid = new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        char[][] grid = new char[][]{{'1','1','1'}, {'0','1','0'},{'1','1','1'}};
        System.out.println(new NumberOfIslands().numIslands(grid));
    }
}
