package com.example.dfs;

import com.example.graph.UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L1971:寻找图中是否存在路径</p>
 * @author zhenwu
 * @date 2025/7/26 9:32
 */
public class L1971_ValidPath {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}};
        int source = 0;
        int destination = 5;
        System.out.println(validPath(n, edges, source, destination));
        System.out.println(validPathPro(n, edges, source, destination));
    }

    /**
     * 并查集
     */
    private static boolean validPathPro(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        return unionFind.inSameTeam(source, destination);
    }

    private static boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }
        return dfs(graph, visited, source, destination);
    }

    /**
     * 深度优先遍历
     * 时间复杂度：O(N + E)
     * 空间复杂度：O(N)
     */
    private static boolean dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        boolean res = false;
        for (Integer next : graph.getOrDefault(source, new ArrayList<>())) {
            if (!visited[next]) {
                res = res || dfs(graph, visited, next, destination);
            }
        }
        return res;
    }

    /**
     * 深度优先遍历
     * 超时
     */
    private static boolean dfs(int[][] edges, boolean[] visited, int source, int destination) {
        if (source == destination) {
            return true;
        }
        visited[source] = true;
        boolean res = false;
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            if (x == source && !visited[y]) {
                res = res || dfs(edges, visited, y, destination);
            }
            if (y == source && !visited[x]) {
                res = res || dfs(edges, visited, x, destination);
            }
        }
        return res;
    }
}
