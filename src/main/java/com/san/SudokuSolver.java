package com.san;

public class SudokuSolver {

    public boolean isValid(char[][] board, int row, int col, int value) {
        //check row
        for(int i=0;i<board.length;i++) {
            if(board[row][i]-'0'==value) {
                return false;
            }
            if(board[i][row]-'0'==value) {
                return false;
            }
        }

        //check 3 * 3 matrix
        int matRow = (row/3)*3;
        int matCol = (col/3)*3;
        for(int i=matRow;i<3;i++){
            for(int j=matCol;j<3;j++) {
                if(board[i][j]-'0'==value) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSolved(char[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(board[i][j]=='.') {
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        //if the board is all full then nothing to do
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if(board[i][j]=='.') {
                    for(int k=1;k<=9;k++) {
                        if(isValid(board, i, j, k)) {
                            board[i][j]= Character.forDigit(k, 10);
                            solveSudoku(board);
                            if(isSolved(board)) {
                                return;
                            }else {
                                board[i][j] = '.';
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        SudokuSolver ss = new SudokuSolver();
        ss.solveSudoku(board);
    }
}
