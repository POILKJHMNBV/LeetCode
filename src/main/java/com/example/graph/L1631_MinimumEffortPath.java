package com.example.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>L1631:最小体力消耗路径</p>
 * @author zhenwu
 * @date 2025/8/28 21:43
 */
public class L1631_MinimumEffortPath {
    public static void main(String[] args) {

    }

    /**
     * Dijkstra算法
     * 时间复杂度：O(m * n  + log m * n)
     * 空间复杂度：O(m * n)
     */
    private static int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0});

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        int[][] dist = new int[m][n];
        for (int[] nums : dist) {
            Arrays.fill(nums, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], dis = cur[2];
            if (visited[x][y]) {
                continue;
            }
            if (x == m - 1 && y == n - 1) {
                return dis;
            }
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int i = x + dir[0], j = y + dir[1];
                if (i >= 0 && i < m && j >= 0 && j < n && Math.max(dis, Math.abs(heights[x][y] - heights[i][j])) < dist[i][j]) {
                    int newDis = Math.max(dis, Math.abs(heights[x][y] - heights[i][j]));
                    dist[i][j] = newDis;
                    pq.offer(new int[]{i, j, newDis});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
