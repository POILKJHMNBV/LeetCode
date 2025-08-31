package com.example.graph;

import java.util.*;

/**
 * <p>L1976:到达目的地的方案数</p>
 * @author zhenwu
 * @date 2025/8/31 19:51
 */
public class L1976_CountPaths {
    public static void main(String[] args) {

    }

    /**
     * Dijkstra算法 + dp
     * 时间复杂度：O(n  + log m * m)
     * 空间复杂度：O(m + n)
     */
    private static int countPaths(int n, int[][] roads) {
        final int MOD = 1000000007;
        List<int[]>[] graph = new List[n];
        Arrays.setAll(graph, k -> new ArrayList<>());
        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, 1, n, Long.MAX_VALUE);
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingLong(Point::dis));
        pq.offer(new Point(0, 0));

        // dp[i] 表示到达节点 i 的最短路径方案数
        int[] dp = new int[n];
        dp[0] = 1;
        while (!pq.isEmpty()) {
            Point cur = pq.poll();
            int x = cur.p;
            long dis = cur.dis;
            if (x == n - 1) {
                return dp[x];
            }
            if (dis > dist[x]) {
                continue;
            }
            for (int[] next : graph[x]) {
                int y = next[0];
                long newDis = dis + next[1];
                if (newDis < dist[y]) {
                    // 找到更短的路径
                    dist[y] = newDis;
                    dp[y] = dp[x];
                    pq.offer(new Point(y, newDis));
                } else if (newDis == dist[y]) {
                    // 新的路径 == 旧路径
                    dp[y] = (dp[y] + dp[x]) % MOD;
                }
            }
        }
        return -1;
    }

    private record Point(int p, long dis) {
    }
}
