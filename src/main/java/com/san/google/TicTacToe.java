package com.san.google;

import java.util.Arrays;

class TicTacToe {

    int[][] board;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.board = new int[n][n];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        board[row][col] = player;

        //row win
        boolean won = true;
        for(int i=0;i<n;i++) {
            if(board[row][i] != player) {
                won = false;
                break;
            }
        }
        if(won) return player;
        won = true;
        for(int i=0; i<n; i++) {
            if(board[i][col]!=player){
                won = false;
                break;
            }
        }
        if(won) return player;

        //Left check diagonal
        won = true;
        for(int i=0;i <n; i++) {
            if(board[i][i] != player) {
                won = false;
            }
        }
        if(won) return player;

        //right check diagonal
        won = true;
        for(int i=n-1;i >=0; i--) {
            if(board[n-i-1][i] != player) {
                won = false;
            }
        }
        if(won) return player;
        return 0;
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(3);
        int[][] input = {{0, 0, 1}, {0, 2, 2}, {2, 2, 1}, {1, 1, 2}, {2, 0, 1}, {1, 0, 2}, {2, 1, 1}};
//        int[][] input = {{0,0,2},{0,1,1},{1,1,2}};
        int[] result = new int[input.length];
        int rIdx = 0;
        for(int[] move: input) {
            result[rIdx++]= ticTacToe.move(move[0], move[1], move[2]);
        }
        System.out.println(Arrays.toString(result));
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */