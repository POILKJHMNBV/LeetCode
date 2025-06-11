package com.example.matrix;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L1765:地图中的最高点</p>
 * @author zhenwu
 * @date 2025/6/10 21:51
 */
public class L1765_HighestPeak {
    public static void main(String[] args) {

    }

    /**
     * 多源BFS
     * 时间复杂度: O(n * n)
     * 空间复杂度: O(n * n)
     */
    private static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] res = new int[m][n];
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
                res[i][j] = isWater[i][j] == 1 ? 0 : -1;
            }
        }

        int h = 1;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                int[] point = queue.poll();
                for (int[] direction : directions) {
                    int x = point[0] + direction[0], y = point[1] + direction[1];
                    if (notInArea(isWater, x, y) || res[x][y] != -1) {
                        continue;
                    }
                    res[x][y] = h;
                    queue.add(new int[]{x, y});
                }
            }
            h++;
        }
        return res;
    }

    private static boolean notInArea(int[][] grid, int i, int j) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid[0].length;
    }
}
