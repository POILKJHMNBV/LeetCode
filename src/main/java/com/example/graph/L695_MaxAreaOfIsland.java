package com.example.graph;

/**
 * <p>L695:岛屿的最大面积</p>
 * @author zhenwu
 * @date 2025/5/23 21:59
 */
public class L695_MaxAreaOfIsland {

    public static void main(String[] args) {

    }

    private static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] <= 0) {
                    continue;
                }
                maxArea = Math.max(dfs(grid, i, j), maxArea);
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if (!inArea(grid, i, j) || grid[i][j] <= 0) {
            return 0;
        }
        int ans = grid[i][j];
        grid[i][j] = -1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            ans += dfs(grid, i + direction[0], j + direction[1]);
        }
        return ans;
    }

    private static boolean inArea(int[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }
}
