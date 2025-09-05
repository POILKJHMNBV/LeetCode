package com.example.graph;

import java.util.*;

/**
 * <p>L3419:图的最大边权的最小值</p>
 * @author zhenwu
 * @date 2025/9/5 21:00
 */
public class L3419_MinMaxWeight {
    public static void main(String[] args) {

    }

    /**
     * Dijkstra
     * 时间复杂度: O(n + m * log m)
     * 空间复杂度: O(n + m)
     */
    private static int minMaxWeight(int n, int[][] edges, int threshold) {
        if (edges.length < n - 1) {
            // 边数不够
            return -1;
        }
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], w = edge[2];
            graph[y].add(new int[]{x, w});
        }

        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{0, 0});
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0], d = point[1];
            if (d > dis[x]) {
                // 重复入队
                continue;
            }
            ans = d;
            n--;
            for (int[] next : graph[x]) {
                int y = next[0];
                int newD = Math.max(d, next[1]);
                if (newD < dis[y]) {
                    dis[y] = newD;
                    queue.offer(new int[]{y, dis[y]});
                }
            }
        }
        return n > 0 ? -1 : ans;
    }
}
