package com.example.matrix;

/**
 * <p>L130:被围绕的区域</p>
 * @author zhenwu
 * @date 2024/10/12 21:31
 */
public class L130_Solve {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        solve(board);
        for (char[] chars : board) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    /**
     * 时间：O(m * n)   空间：O(m * n)
     */
    private static void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O' && dfs(board, i, j, new boolean[m][n])) {
                    fill(board, i, j);
                }
            }
        }
    }

    private static void fill(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = 'X';
            fill(board, i + 1, j);
            fill(board, i - 1, j);
            fill(board, i, j + 1);
            fill(board, i, j - 1);
        }
    }

    private static boolean dfs(char[][] board, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return true;
        }
        visited[i][j] = true;
        if (board[i][j] == 'X') {
            return true;
        }
        return dfs(board, i + 1, j, visited)
                && dfs(board, i - 1, j, visited)
                && dfs(board, i, j + 1, visited)
                && dfs(board, i, j - 1, visited);
    }
}
