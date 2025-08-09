package com.example.bfs;

import java.util.*;

/**
 * <p>L3243:新增道路查询后的最短距离 I</p>
 * @author zhenwu
 * @date 2025/8/9 15:50
 */
public class L3243_ShortestDistanceAfterQueries {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(q * (n + q))，其中 n 为节点数，q 为查询数
     * 空间复杂度：O(n + q)
     */
    private static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            graph.computeIfAbsent(i, k -> new ArrayList<>()).add(i + 1);
        }
        int[] ans = new int[queries.length];
        for (int i = 0, m = queries.length; i < m; i++) {
            graph.computeIfAbsent(queries[i][0], k -> new ArrayList<>()).add(queries[i][1]);
            ans[i] = bfs(graph, n);
        }
        return ans;
    }

    private static int bfs(Map<Integer, List<Integer>> graph, int n) {
        int[] dist = new int[n];
        for (int i = 1; i < n; i++) {
            // 初始所有节点的距离都为-1，表示没有被访问过
            dist[i] = -1;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
                if (dist[next] >= 0) {
                    continue;
                }
                queue.offer(next);
                dist[next] = dist[cur] + 1;
            }
        }
        return dist[n - 1];
    }
}
