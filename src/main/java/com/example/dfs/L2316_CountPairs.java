package com.example.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L2316:统计无向图中无法互相到达点对数</p>
 * @author zhenwu
 * @date 2025/7/28 21:40
 */
public class L2316_CountPairs {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}};
        System.out.println(countPairs(n, edges));
    }

    /**
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n + m)
     */
    private static long countPairs(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        long ans = 0;
        for (int i = 0, total = 0; i < n; i++) {
            int count = dfs(visited, graph, i);
            ans += (long) total * count;
            total += count;
        }
        return ans;
    }

    private static int dfs(boolean[] visited, Map<Integer, List<Integer>> graph, int cur) {
        if (visited[cur]) {
            return 0;
        }
        visited[cur] = true;
        int count = 1;
        for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
            count += dfs(visited, graph, next);
        }
        return count;
    }
}
