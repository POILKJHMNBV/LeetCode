package com.example.matrix;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L934:最短的桥</p>
 * @author zhenwu
 * @date 2025/6/12 21:51
 */
public class L934_ShortestBridge {
    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println(shortestBridge(grid));
    }

    /**
     * 多源BFS + DFS
     * 时间复杂度: O(n * n)
     * 空间复杂度: O(n * n)
     */
    private static int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                dfs(grid, i, j);
                found = true;
                break;
            }
            if (found) {
                break;
            }
        }

        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        int ans = -1;
        while (!queue.isEmpty()) {
            ans++;
            for (int i = 0, size = queue.size(); i < size; i++) {
                int[] point = queue.poll();
                for (int[] direction : directions) {
                    int x = point[0] + direction[0], y = point[1] + direction[1];
                    if (notInArea(grid, x, y) || grid[x][y] == 2) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        return ans;
                    }
                    grid[x][y] = 2;
                    queue.add(new int[]{x, y});
                }
            }
        }
        return ans;
    }

    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static void dfs(int[][] grid, int i, int j) {
        if (notInArea(grid, i, j) || grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 2;
        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1]);
        }
    }

    private static boolean notInArea(int[][] grid, int i, int j) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length;
    }
}
