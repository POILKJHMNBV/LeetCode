package com.example.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L1391:检查网格中是否存在有效路径</p>
 * @author zhenwu
 * @date 2025/6/2 17:01
 */
public class L1391_HasValidPath {
    public static void main(String[] args) {
        int[][] grid = {{2, 6, 3}, {6, 5, 2}};
        System.out.println(hasValidPath(grid));
    }

    private static boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(grid, 0, 0, visited);
        return visited[m - 1][n - 1];
    }

    private static void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int[] neighbor : getNeighbors(grid, i, j)) {
            int x = neighbor[0], y = neighbor[1];
            if (!inArea(grid, x, y)) {
                continue;
            }
            switch (grid[i][j]) {
                case 1 -> {
                    if (grid[x][y] == grid[i][j]) {
                         dfs(grid, x, y, visited);
                    }
                    if (y == j + 1 && (grid[x][y] == 3 || grid[x][y] == 5)) {
                        dfs(grid, x, y, visited);
                    }
                    if (y == j - 1 && (grid[x][y] == 4 || grid[x][y] == 6)) {
                        dfs(grid, x, y, visited);
                    }
                }
                case 2 -> {
                    if (grid[x][y] == grid[i][j]) {
                        dfs(grid, x, y, visited);
                    }
                    if (x == i + 1 && grid[x][y] >= 5) {
                        dfs(grid, x, y, visited);
                    }
                    if (x == i - 1 && (grid[x][y] == 3 || grid[x][y] == 4)) {
                        dfs(grid, x, y, visited);
                    }
                }
                case 3 -> {
                    if (x == i + 1 && (grid[x][y] == 2 || grid[x][y] >= 5)) {
                        dfs(grid, x, y, visited);
                    }
                    if (y == j - 1 && (grid[x][y] == 1 || grid[x][y] == 4 || grid[x][y] == 6)) {
                        dfs(grid, x, y, visited);
                    }
                }
                case 4 -> {
                    if (x == i + 1 && (grid[x][y] == 2 || grid[x][y] >= 5)) {
                        dfs(grid, x, y, visited);
                    }
                    if (y == j + 1 && (grid[x][y] == 1 || grid[x][y] == 3 || grid[x][y] == 5)) {
                        dfs(grid, x, y, visited);
                    }
                }
                case 5 -> {
                    if (x == i - 1 && (grid[x][y] == 2 || grid[x][y] == 3 || grid[x][y] == 4)) {
                        dfs(grid, x, y, visited);
                    }
                    if (y == j - 1 && (grid[x][y] == 1 || grid[x][y] == 4 || grid[x][y] == 6)) {
                        dfs(grid, x, y, visited);
                    }
                }
                case 6 -> {
                    if (x == i - 1 && (grid[x][y] == 2 || grid[x][y] == 3 || grid[x][y] == 4)) {
                        dfs(grid, x, y, visited);
                    }
                    if (y == j + 1 && (grid[x][y] == 1 || grid[x][y] == 3 || grid[x][y] == 5)) {
                        dfs(grid, x, y, visited);
                    }
                }
            }
        }
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }

    private static List<int[]> getNeighbors(int[][] grid, int x, int y) {
        List<int[]> ans = new ArrayList<>();
        switch (grid[x][y]) {
            case 1 -> {
                ans.add(new int[]{x, y + 1});
                ans.add(new int[]{x, y - 1});
            }
            case 2 -> {
                ans.add(new int[]{x + 1, y});
                ans.add(new int[]{x - 1, y});
            }
            case 3 -> {
                ans.add(new int[]{x, y - 1});
                ans.add(new int[]{x + 1, y});
            }
            case 4 -> {
                ans.add(new int[]{x, y + 1});
                ans.add(new int[]{x + 1, y});
            }
            case 5 -> {
                ans.add(new int[]{x, y - 1});
                ans.add(new int[]{x - 1, y});
            }
            case 6 -> {
                ans.add(new int[]{x, y + 1});
                ans.add(new int[]{x - 1, y});
            }
        }
        return ans;
    }
}
