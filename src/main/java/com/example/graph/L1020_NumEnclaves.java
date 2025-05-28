package com.example.graph;

/**
 * <p>L1020:飞地的数量</p>
 * @author zhenwu
 * @date 2025/5/28 22:11
 */
public class L1020_NumEnclaves {

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        System.out.println(numEnclaves(grid));
    }

    private static int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int k = dfs(grid, i, j);
                    if (k != -1) {
                        cnt += k;
                    }
                }
            }
        }
        return cnt;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if (!inArea(grid, i, j)) {
            return -1;
        }
        if (grid[i][j] <= 0) {
            return 0;
        }
        grid[i][j] = -1;
        int ans = 1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean touchBorder = false;
        for (int[] direction : directions) {
            int x = direction[0] + i, y = direction[1] + j;
            int z = dfs(grid, x, y);
            if (z == -1) {
                touchBorder = true;
            }
            ans += z;
        }
        return touchBorder ? -1 : ans;
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
