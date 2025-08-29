package com.example.graph;

import java.util.*;

/**
 * <p>L1786:从第一个节点出发到最后一个节点的受限路径数</p>
 * @author zhenwu
 * @date 2025/8/29 21:44
 */
public class L1786_CountRestrictedPaths {
    public static void main(String[] args) {

    }

    /**
     * Dijkstra算法 + dp
     * 时间复杂度：O(m * n  + log m * n)
     * 空间复杂度：O(m * n)
     */
    private static int countRestrictedPaths(int n, int[][] edges) {
        final int MODULO = 1000000007;
        List<int[]>[] graph = new List[n + 1];
        Arrays.setAll(graph, k -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] dist = dijkstra(n, graph);

        int[][] distIndices = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            distIndices[i][0] = dist[i];
            distIndices[i][1] = i;
        }

        // 排序, 方便dp
        Arrays.sort(distIndices, Comparator.comparingInt(a -> a[0]));

        // dp[i] 表示从 i 到 n 的受限路径数
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = 1; i <= n; i++) {
            int cur = distIndices[i][1];
            for (int[] next : graph[cur]) {
                int y = next[0];
                if (dist[y] < dist[cur]) {
                    dp[cur] = (dp[y] + dp[cur]) % MODULO;
                }
            }
        }
        return dp[1];
    }

    private static int[] dijkstra(int n, List<int[]>[] graph) {
        // 记录节点 n 到其他节点(1~n)的最短距离
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{n, 0});
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
