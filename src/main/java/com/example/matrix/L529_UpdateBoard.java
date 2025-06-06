package com.example.matrix;

import java.util.Arrays;

/**
 * <p>L529:扫雷游戏</p>
 * @author zhenwu
 * @date 2025/6/6 21:45
 */
public class L529_UpdateBoard {
    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        updateBoard(board, click);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    private static char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }

    private static void dfs(char[][] board, int i, int j) {
        if (!inArea(board, i, j) || board[i][j] != 'E') {
            return;
        }
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        // 地雷数量
        int cnt = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (inArea(board, x, y) && board[x][y] == 'M') {
                cnt++;
            }
        }
        if (cnt == 0) {
            board[i][j] = 'B';
            for (int[] dir : dirs) {
                dfs(board, i + dir[0], j + dir[1]);
            }
        } else {
            board[i][j] = (char) (cnt + '0');
        }
    }

    private static boolean inArea(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
