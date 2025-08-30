package com.example.graph;

import java.util.*;

/**
 * <p>L3123:最短路径中的边</p>
 * @author zhenwu
 * @date 2025/8/30 10:21
 */
public class L3123_FindAnswer {
    public static void main(String[] args) {

    }

    /**
     * dijkstra + bfs
     * 时间复杂度：O(n  + log m * m)
     * 空间复杂度：O(m + n)
     */
    private static boolean[] findAnswer(int n, int[][] edges) {
        List<int[]>[] graph = new List[n];
        Arrays.setAll(graph, k -> new ArrayList<>());
        for (int i = 0, m = edges.length; i < m; i++) {
            graph[edges[i][0]].add(new int[]{edges[i][1], edges[i][2], i});
            graph[edges[i][1]].add(new int[]{edges[i][0], edges[i][2], i});
        }
        int[] dist = dijkstra(n, graph);
        boolean[] ans = new boolean[edges.length];
        if (dist[n - 1] == Integer.MAX_VALUE) {
            return ans;
        }

        // bfs反向遍历所有满足条件的路径
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.offer(n - 1);
        vis[n - 1] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int[] next : graph[cur]) {
                int y = next[0], w = next[1], idx = next[2];
                if (dist[cur] != dist[y] + w) {
                    continue;
                }
                ans[idx] = true;
                if (!vis[y]) {
                    q.offer(y);
                    vis[y] = true;
                }
            }
        }
        return ans;
    }

    /**
     * dijkstra算法求出源点到其他点的最短距离
     */
    private static int[] dijkstra(int n, List<int[]>[] graph) {
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
