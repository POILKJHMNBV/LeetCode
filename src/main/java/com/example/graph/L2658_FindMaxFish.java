package com.example.graph;

/**
 * <p>L2658:网格图中鱼的最大数目</p>
 * @author zhenwu
 * @date 2025/5/22 22:08
 */
public class L2658_FindMaxFish {

    public static void main(String[] args) {

    }

    private static int findMaxFish(int[][] grid) {
        int maxFish = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] <= 0) {
                    continue;
                }
                maxFish = Math.max(dfs(grid, i, j), maxFish);
            }
        }
        return maxFish;
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
