package com.example.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zhenwu
 * @date 2025/8/31 19:55
 */
public final class GraphUtil {

    private GraphUtil() {
    }

    /**
     * dijkstra算法求出源点到其他点的最短距离
     */
    public static int[] dijkstra(int n, List<int[]>[] graph) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        dist[0] = 0;
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] point = pq.poll();
            int x = point[0], d = point[1];
            if (d > dist[x]) {
                // 重复入队的节点不需要重复计算距离
                continue;
            }
            for (int[] next : graph[x]) {
                int y = next[0], w = next[1];
                if (dist[y] > dist[x] + w) {
                    dist[y] = dist[x] + w;
                    pq.offer(new int[]{y, dist[y]});
                }
            }
        }
        return dist;
    }
}
