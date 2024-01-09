package com.san;

import java.util.ArrayList;
import java.util.List;

public class AllPossiblePositionsOfQueens {

  boolean checkIfItIsOk(char[][] board, int x, int y) {
    int n = board.length;
    //check row
    for (int i = 0; i < board.length; i++) {
      if (board[i][y] == 'Q') {
        return false;
      }

      if (board[x][i] == 'Q') {
        return false;
      }
    }

    //cross down right
    int k = x, l = y;
    while (k < n && l < n) {
      if (board[k][l] == 'Q') {
        return false;
      }
      k++;
      l++;
    }

    //cross up right
    k = x;
    l = y;
    while (k >= 0 && l < n) {
      if (board[k][l] == 'Q') {
        return false;
      }
      k--;
      l++;
    }

    //cross down left
    k = x;
    l = y;
    while (k < n && l >= 0) {
      if (board[k][l] == 'Q') {
        return false;
      }
      k++;
      l--;
    }

    //cross up right
    k = x;
    l = y;
    while (k >= 0 && l >= 0) {
      if (board[k][l] == 'Q') {
        return false;
      }
      k--;
      l--;
    }
    return true;
  }

  boolean placeGivenQ(char[][] board, int n) {
    if (n == 0) {
      return true;
    }
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (checkIfItIsOk(board, i, j)) {
          board[i][j] = 'Q';
          if (placeGivenQ(board, n - 1)) {
            return true;
          } else {
            board[i][j] = '.';
          }
        }
      }
    }
    return false;
  }

  List<String> constructAnswer(char[][] board) {
    List<String> ans = new ArrayList<String>();
    for (int i = 0; i < board.length; i++) {
      String s = "";
      for (int j = 0; j < board.length; j++) {
        s += board[i][j];

      }
      ans.add(s);
    }
    return ans;
  }

  char[][] constructBoard(int n) {
    char[][] board = new char[n][n];
    for (int i = 0; i < board.length; i++) {
      board[i] = new char[n];
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        board[i][j] = '.';
      }
    }
    return board;
  }

  public List<List<String>> solveNQueens(int n) {
    char[][] board = constructBoard(n);

    List<List<String>> ans = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = 'Q';
        if (placeGivenQ(board, n - 1)) {
          ans.add(constructAnswer(board));
          board = constructBoard(n);
        }
        board[i][j] = '.';
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    AllPossiblePositionsOfQueens aps = new AllPossiblePositionsOfQueens();
    List<List<String>> lists = aps.solveNQueens(4);
    System.out.println(lists);
  }
}
