package com.example.recursion;

/**
 * <p>L37:解数独</p>
 * @author zhenwu
 * @date 2024/9/29 20:18
 */
public class L37_SolveSudoku {
    public static void main(String[] args) {

    }

    private static void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private static boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }

                // 依次尝试填入每一个树
                for (char ch = '1'; ch <= '9'; ch++) {
                    if (isValid(board, i, j, ch)) {
                        // 尝试填入数字
                        board[i][j] = ch;
                        if (backtrack(board)) {
                            // 如果找到了解，直接返回
                            return true;
                        }
                        // 回溯
                        board[i][j] = '.';
                    }
                }

                // 尝试了9个数都不行，证明无法解数独
                return false;
            }
        }

        // 棋盘已经被填满，找到一个解
        return true;
    }

    private static boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {

            // 判断列内是否已经有该数字
            if (board[row][i] == c) {
                return false;
            }

            // 判断行内是否已经有该数字
            if (board[i][col] == c) {
                return false;
            }

            // 判断3*3的宫格内是否已经有该数字
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}