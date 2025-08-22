package com.example.graph;

import java.util.*;

/**
 * <p>L3342:到达最后一个房间的最少时间 II</p>
 * @author zhenwu
 * @date 2025/8/22 20:37
 */
public class L3342_MinTimeToReach {
    public static void main(String[] args) {

    }

    /**
     * dijkstra算法
     * 时间复杂度：O(n * m)
     * 空间复杂度：O(n * m)
     */
    private static int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] dist = new int[n][m];
        for (int[] ints : dist) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        dist[0][0] = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, 0, 0});
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int d = point[0], i = point[1], j = point[2];
            if (i == n - 1 && j == m - 1) {
                return d;
            }
            if (dist[i][j] < d) {
                // 重复入队的节点不需要重复计算距离
                continue;
            }
            int time = (i + j) % 2 + 1;
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m) {
                    int did = Math.max(d, moveTime[x][y]) + time;
                    if (dist[x][y] > did) {
                        dist[x][y] = did;
                        queue.offer(new int[]{did, x, y});
                    }
                }
            }
        }
        return -1;
    }
}
