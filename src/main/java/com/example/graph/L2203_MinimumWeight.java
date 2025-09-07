package com.example.graph;

import java.util.*;

/**
 * <p>L2203:得到要求路径的最小带权子图</p>
 * @author zhenwu
 * @date 2025/9/7 13:55
 */
public class L2203_MinimumWeight {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {
                {0, 1, 1},
                {2, 1, 1}
        };
        int src1 = 0, src2 = 1, dest = 2;
        System.out.println(minimumWeight(n, edges, src1, src2, dest));
    }

    /**
     * tip: 三岔路
     * 时间复杂度: O(n + m * log m)
     * 空间复杂度: O(n + m)
     */
    private static long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        // 创建正向图和反向图
        List<Point>[] graph = new ArrayList[n], reverseGraph = new ArrayList[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        Arrays.setAll(reverseGraph, i -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], w = edge[2];
            graph[x].add(new Point(y, w));
            reverseGraph[y].add(new Point(x, w));
        }

        // 求解 src1 到其他点的最短距离
        long[] dist1 = dijkstra(src1, graph);
        // 求解 src2 到其他点最短距离
        long[] dist2 = dijkstra(src2, graph);
        // 求解 dest 到其他点最短距离
        long[] dist3 = dijkstra(dest, reverseGraph);

        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist1[i] == Long.MAX_VALUE || dist2[i] == Long.MAX_VALUE || dist3[i] == Long.MAX_VALUE) {
                continue;
            }
            res = Math.min(res, dist1[i] + dist2[i] + dist3[i]);
        }
        return res == Long.MAX_VALUE ? -1 : res;
    }

    private record Point(int k, int w) {
    }

    private record Pair(int k, long d) {
    }

    /**
     * dijkstra 求源点到其他点的最短距离
     */
    private static long[] dijkstra(int src, List<Point>[] graph) {
        long[] dist = new long[graph.length];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o.d));
        pq.offer(new Pair(src, 0));
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int p = cur.k;
            long dis = cur.d;
            if (dis > dist[p]) {
                continue;
            }
            for (Point point : graph[p]) {
                int k = point.k;
                long w = point.w;
                if (dist[k] > dis + w) {
                    dist[k] = dis + w;
                    pq.offer(new Pair(k, dist[k]));
                }
            }
        }
        return dist;
    }
}
