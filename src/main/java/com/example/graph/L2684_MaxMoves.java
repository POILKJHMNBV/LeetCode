package com.example.graph;

/**
 * <p>L2684:矩阵中移动的最大次数</p>
 * (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1)
 * @author zhenwu
 * @date 2025/5/29 22:01
 */
public class L2684_MaxMoves {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        };
        System.out.println(maxMoves(grid));
    }

    private static int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            dfs(grid, new boolean[m][n], i, 0, 0);
        }
        return maxMove;
    }

    static int maxMove = 0;

    private static void dfs(int[][] grid, boolean[][] visited,
                           int i, int j, int step) {
        if (visited[i][j]) {
            return;
        }
        maxMove = Math.max(step, maxMove);
        visited[i][j] = true;
        int y = j + 1;
        for (int k = -1; k <= 1; k++) {
            int x = i + k;
            if (inArea(grid, x, y) && grid[x][y] > grid[i][j]) {
                dfs(grid, visited, x, y, step + 1);
            }
        }
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
