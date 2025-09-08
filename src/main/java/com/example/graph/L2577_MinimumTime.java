package com.example.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>L2577:在网格图中访问一个格子的最少时间</p>
 * @author zhenwu
 * @date 2025/9/8 21:39
 */
public class L2577_MinimumTime {
    public static void main(String[] args) {

    }

    /**
     * dijkstra算法
     * 时间复杂度: O(m * n * log(m * n))
     * 空间复杂度: O(m * n)
     */
    private static int minimumTime(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            // 永远不可能到达 (m - 1, n - 1)
            return -1;
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // dis[i][j] 表示从 (0, 0) 到 (i, j) 的最短时间
        int[][] dis = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, 0, 0});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int d = point[0], i = point[1], j = point[2];
            if (i == m - 1 && j == n - 1) {
                return d;
            }
            if (dis[i][j] < d) {
                // 重复入队的节点不需要重复计算距离
                continue;
            }
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];

                if (x < 0 || x >= m || y < 0 || y >= n) {
                    continue;
                }

                // 求解到达 (x, y) 的最短时间
                int newDis = Math.max(d + 1, grid[x][y]);

                // 奇偶性校正, 到达 (x, y) 的最短时间的奇偶性必须与到达 i + j 的奇偶性相同
                newDis += (newDis - x - y) % 2;

                if (newDis < dis[x][y]) {
                    dis[x][y] = newDis;
                    queue.offer(new int[]{newDis, x, y});
                }
            }
        }
        return -1;
    }
}
