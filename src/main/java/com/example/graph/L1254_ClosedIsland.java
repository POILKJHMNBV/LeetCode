package com.example.graph;

/**
 * <p>L1254:统计封闭岛屿的数目</p>
 * @author zhenwu
 * @date 2025/5/30 21:22
 */
public class L1254_ClosedIsland {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0}
        };
        System.out.println(closedIsland(grid));
    }

    private static int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    continue;
                }
                arriveBorder = false;
                dfs(grid, i, j);
                if (!arriveBorder) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static boolean arriveBorder;

    private static void dfs(int[][] grid, int i, int j) {
        grid[i][j] = 2;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for (int[] direction : directions) {
            int x = direction[0] + i, y = direction[1] + j;
            if (!inArea(grid, x, y)) {
                arriveBorder = true;
                continue;
            }
            if (grid[x][y] == 0) {
                dfs(grid, x, y);
            }
        }
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
