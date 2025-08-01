package com.example.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L2685:统计完全连通分量的数量</p>
 * @author zhenwu
 * @date 2025/8/1 21:26
 */
public class L2685_CountCompleteComponents {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {3, 4}};
        System.out.println(countCompleteComponents(n, edges));
    }

    /**
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n + m)
     */
    private static int countCompleteComponents(int n, int[][] edges) {
        graph = new HashMap<>();
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            v = 0;
            e = 0;
            dfs(i);
            if (e == v * (v - 1)) {
                ans++;
            }
        }
        return ans;
    }

    static int v, e = 0;

    static Map<Integer, List<Integer>> graph;

    static boolean[] visited;

    private static void dfs(int cur) {
        visited[cur] = true;
        v++;
        e += graph.getOrDefault(cur, new ArrayList<>()).size();
        for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
