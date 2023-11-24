package com.san;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

  public boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      Set<Integer> hseen = new HashSet<Integer>();
      Set<Integer> vseen = new HashSet<Integer>();
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] != '.') {
          int curVal = board[i][j] - '0';
          if (hseen.contains(curVal)) {
            return false;
          } else {
            hseen.add(curVal);
          }
        }

        if (board[j][i] != '.') {
          int curVal = board[j][i] - '0';
          if (vseen.contains(curVal)) {
            return false;
          } else {
            vseen.add(curVal);
          }
        }
      }
    }

    for (int i = 0; i < 9; i += 3) {
      for (int j = 0; j < 9; j += 3) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int ix = i; ix < i + 3; ix++) {
          for (int jx = j; jx < j + 3; jx++) {
            if (board[ix][jx] != '.') {
              int curVal = board[ix][jx] - '0';
              if (seen.contains(curVal)) {
                return false;
              }
              seen.add(curVal);
            }
          }
        }
      }
    }
    return true;
  }


  public static void main(String[] args) {
    char[][] board =
        new char[][] {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    System.out.println(new ValidSudoku().isValidSudoku(board));
  }
}
