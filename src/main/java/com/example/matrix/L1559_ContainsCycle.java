package com.example.matrix;

/**
 * <p>L1559:二维网格图中探测环</p>
 * @author zhenwu
 * @date 2025/6/7 10:05
 */
public class L1559_ContainsCycle {
    public static void main(String[] args) {
        char[][] grid = {
                {'c', 'a', 'd'},
                {'a', 'a', 'a'},
                {'a', 'a', 'd'},
                {'a', 'c', 'd'},
                {'a', 'b', 'c'}
        };
        System.out.println(containsCycle(grid));
    }

    private static boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (dfs(grid, visited, i, j, -1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static boolean dfs(char[][] grid, boolean[][] visited,
                               int i, int j, int preI, int preJ) {
        visited[i][j] = true;
        for (int[] dir : directions) {
            int x = i + dir[0], y = j + dir[1];
            if (!inArea(grid, x, y) || grid[x][y] != grid[i][j]) {
                continue;
            }
            if (x == preI && y == preJ) {
                continue;
            }
            if (visited[x][y]) {
                return true;
            }
            if (dfs(grid, visited, x, y, i, j)) {
                return true;
            }
        }
        return false;
    }

    private static boolean inArea(char[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
