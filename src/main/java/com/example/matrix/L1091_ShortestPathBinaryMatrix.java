package com.example.matrix;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L1091:二进制矩阵中的最短路径</p>
 * @author zhenwu
 * @date 2025/6/9 22:05
 */
public class L1091_ShortestPathBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    /**
     * BFS
     * 时间复杂度: O(n * n)
     * 空间复杂度: O(n * n)
     */
    private static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length, shortest = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{-1, -1});
        while (!queue.isEmpty()) {
            shortest++;
            for (int i = 0, size = queue.size(); i < size; i++) {
                int[] cur = queue.poll();
                for (int[] direction : directions) {
                    int newX = cur[0] + direction[0], newY = cur[1] + direction[1];
                    if (!inArea(grid, newX, newY) || grid[newX][newY] == 1) {
                        continue;
                    }
                    if (newX == n - 1 && newY == n - 1) {
                        return shortest;
                    }
                    queue.offer(new int[]{newX, newY});
                    grid[newX][newY] = 1;
                }
            }
        }
        return -1;
    }

    private static boolean inArea(int[][] grid, int i, int j) {
        return i >= 0 && i < grid.length && j >= 0 && j < grid[0].length;
    }
}
