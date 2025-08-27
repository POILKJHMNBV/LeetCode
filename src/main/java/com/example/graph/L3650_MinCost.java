package com.example.graph;

import java.util.*;

/**
 * <p>L3650:边反转的最小路径总成本</p>
 * @author zhenwu
 * @date 2025/8/27 21:22
 */
public class L3650_MinCost {
    public static void main(String[] args) {

    }

    /**
     * Dijkstra算法
     * 时间复杂度：O(n + m * log m), 其中 n 为节点数，m 为边数
     * 空间复杂度：O(n + m)
     */
    private static int minCost(int n, int[][] edges) {
        List<int[]>[] graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2] * 2});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[0] = 0;
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int d = point[0], i = point[1];
            if (dist[i] < d) {
                // 重复入队的节点不需要重复计算距离
                continue;
            }
            if (i == n - 1) {
                return d;
            }
            for (int[] next : graph[i]) {
                int j = next[0], cost = next[1];
                if (d + cost < dist[j]) {
                    dist[j] = d + cost;
                    queue.offer(new int[]{dist[j], j});
                }
            }
        }
        return -1;
    }
}
