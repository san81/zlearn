package com.san.design;

import java.io.*;
import java.util.*;

class Game {
    int[][] board;
    int winner; // 0 = in progress, 1 = P1 (X) wins, 2 = P2 (O) wins, -1 = tie
    int n;

    public Game(int n) {
        this.n = n;
        this.board = new int[n][n];
        this.winner = 0;
    }

    public boolean isComplete() {
        // Row check
        for (int i = 0; i < n; i++) {
            if (board[i][0] != 0) {
                boolean win = true;
                for (int j = 1; j < n; j++) {
                    if (board[i][j] != board[i][0]) { win = false; break; }
                }
                if (win) { this.winner = board[i][0]; return true; }
            }
        }

        // Column check
        for (int j = 0; j < n; j++) {
            if (board[0][j] != 0) {
                boolean win = true;
                for (int i = 1; i < n; i++) {
                    if (board[i][j] != board[0][j]) { win = false; break; }
                }
                if (win) { this.winner = board[0][j]; return true; }
            }
        }

        // Diagonal: top-left → bottom-right
        if (board[0][0] != 0) {
            boolean win = true;
            for (int i = 1; i < n; i++) {
                if (board[i][i] != board[0][0]) { win = false; break; }
            }
            if (win) { this.winner = board[0][0]; return true; }
        }

        // Diagonal: top-right → bottom-left
        if (board[0][n - 1] != 0) {
            boolean win = true;
            for (int i = 1; i < n; i++) {
                if (board[i][n - 1 - i] != board[0][n - 1]) { win = false; break; }
            }
            if (win) { this.winner = board[0][n - 1]; return true; }
        }

        // Tie check: board full with no winner
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (board[i][j] == 0) return false; // Still moves available

        this.winner = -1; // Tie
        return true;
    }

    // FIX: Added row, col, playerVal params — original had no way to know WHERE or WHO
    public void placePlayerChoice(int row, int col, int playerVal) {
        board[row][col] = playerVal;
    }
}

class Player {
    int myChar;
    Random rand = new Random(); // FIX: one shared Random, not seeded with board size

    Player(int myChar) {
        this.myChar = myChar;
    }

    // FIX: renamed maeChoice → makeChoice (typo)
    public int[] makeChoice(int[][] board) {
        // Collect empty cells, then pick one — O(n²) once, not repeated guessing
        List<int[]> available = new ArrayList<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (board[i][j] == 0) available.add(new int[]{i, j});

        return available.get(rand.nextInt(available.size()));
    }
    // FIX: added missing closing brace for class Player
}

public class TicTacGame {
    public static void main(String[] args) {
        Game game = new Game(3);
        Player p1 = new Player(1); // X
        Player p2 = new Player(2); // O

        boolean toggle = false;
        while (!game.isComplete()) {
            int[] choice;
            // FIX: toggle=false → p1 goes first; original had it backwards
            // FIX: actually USE the returned choice to place it on the board
            if (!toggle) {
                choice = p1.makeChoice(game.board);
                game.placePlayerChoice(choice[0], choice[1], p1.myChar);
            } else {
                choice = p2.makeChoice(game.board);
                game.placePlayerChoice(choice[0], choice[1], p2.myChar);
            }
            toggle = !toggle;
        }

        // FIX: print meaningful result instead of raw integer
        if (game.winner == 1)       System.out.println("X wins");
        else if (game.winner == 2)  System.out.println("O wins");
        else                        System.out.println("Tie");
    }
}