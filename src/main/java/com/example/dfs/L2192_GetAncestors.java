package com.example.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L2192:有向无环图中一个节点的所有祖先</p>
 * @author zhenwu
 * @date 2025/8/2 8:43
 */
public class L2192_GetAncestors {
    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        System.out.println(getAncestors(n, edges));
    }

    /**
     * 逆向dfs
     * 时间复杂度：O(n * (n + m))
     * 空间复杂度：O(n + m)
     */
    private static List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new ArrayList<>());
        }
        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            dfs(graph, i, visited);
            List<Integer> list = ancestors.get(i);
            visited[i] = false;
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    list.add(j);
                }
            }
        }
        return ancestors;
    }


    private static void dfs(Map<Integer, List<Integer>> graph, int cur, boolean[] visited) {
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
            dfs(graph, next, visited);
        }
    }
}
