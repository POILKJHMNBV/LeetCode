package com.example.recursion;

/**
 * <p>L980:不同路径 III</p>
 * <p>每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。</p>
 * @author zhenwu
 * @date 2024/12/21 11:05
 */
public class L980_uniquePathsIII {
    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(uniquePathsIII(grid));
    }

    private static int uniquePathsIII(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int remain = 0;
        int startX = 0, startY = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 起点位置
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 0) {
                    // 剩余的0的数量，即需要走的步数
                    remain++;
                }
            }
        }
        boolean[][] visited = new boolean[m][n];
        dfs(grid, startX, startY, remain, visited);
        return count;
    }

    static int count = 0;

    private static void dfs(int[][] grid,
                            int x, int y,
                            int remain,
                            boolean[][] visited) {
        if (!inArea(grid, x, y) || grid[x][y] == -1 || visited[x][y]) {
            // 越界、障碍物或者已经访问过，直接返回
            return;
        }
        visited[x][y] = true;
        if (grid[x][y] == 2 && remain == -1) {
            // 走到终点，且已经走完所有0，计数+1，然后回溯
            count++;
            visited[x][y] = false;
            return;
        }
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            // 继续往下走，剩余步数-1
            dfs(grid, x + dir[0], y + dir[1], remain - 1, visited);
        }
        // 回溯，将当前位置标记为未访问
        visited[x][y] = false;
    }

    private static boolean inArea(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}
