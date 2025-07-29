package com.example.dfs;

import com.example.graph.UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L1319:连通网络的操作次数</p>
 * @author zhenwu
 * @date 2025/7/29 22:10
 */
public class L1319_MakeConnected {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n + m)
     */
    private static int makeConnectedPro(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int ConnectedComponent = 0;
        for (int[] connection : connections) {
            graph.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(connection[1]);
            graph.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(connection[0]);
        }
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(visited, graph, i);
                ConnectedComponent++;
            }
        }
        return ConnectedComponent - 1;
    }

    private static void dfs(boolean[] visited, Map<Integer, List<Integer>> graph, int cur) {
       visited[cur] = true;
       for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
           if (!visited[next]) {
               dfs(visited, graph, next);
           }
       }
    }

    /**
     * 并查集
     * 时间复杂度：O(n * n)
     * 空间复杂度：O(n)
     */
    private static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int[] connection : connections) {
            unionFind.union(connection[0], connection[1]);
        }
        int count = unionFind.getCount();
        return count - 1;
    }
}
