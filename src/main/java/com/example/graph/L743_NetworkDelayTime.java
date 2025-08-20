package com.example.graph;

import java.util.Arrays;

/**
 * <p>L743:网络延迟时间</p>
 * @author zhenwu
 * @date 2025/8/20 21:47
 */
public class L743_NetworkDelayTime {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     */
    private static int networkDelayTime(int[][] times, int n, int k) {
        int infinity = Integer.MAX_VALUE >> 1;
        // 邻接矩阵，存储图形关系
        int[][] grid = new int[n][n];
        for (int[] ints : grid) {
            Arrays.fill(ints, infinity);
        }
        for (int[] time : times) {
            grid[time[0] - 1][time[1] - 1] = time[2];
        }

        // 存储源点到其他点的最短距离
        int[] dist = new int[n];
        Arrays.fill(dist, infinity);
        dist[k - 1] = 0;

        // 存储源点到其他点最短距离是否已经确定
        boolean[] done = new boolean[n];
        int maxDistance = 0;
        while (true) {
            int u = -1;
            for (int i = 0; i < n; i++) {
                if (!done[i] && (u == -1 || dist[i] < dist[u])) {
                    u = i;
                }
            }
            if (u == -1) {
                return maxDistance;
            }
            if (dist[u] == infinity) {
                // 有节点无法到达
                return -1;
            }
            done[u] = true;
            maxDistance = dist[u];
            for (int v = 0; v < n; v++) {
                // 以u为基点，更新源点到v的最短距离
                dist[v] = Math.min(dist[v], dist[u] + grid[u][v]);
            }
        }
    }
}
