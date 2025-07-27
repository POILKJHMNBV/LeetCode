package com.example.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L797:所有可能的路径</p>
 * @author zhenwu
 * @date 2025/7/27 14:47
 */
public class L797_AllPathsSourceTarget {
    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }

    /**
     * 时间复杂度：O(2^n * n)
     * 空间复杂度：O(n)
     */
    private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(graph, 0, new ArrayList<>(), result);
        return result;
    }
    private static void dfs(int[][] graph, int cur, List<Integer> path, List<List<Integer>> result) {
        path.add(cur);
        if (cur == graph.length - 1) {
            result.add(new ArrayList<>(path));
        } else {
            for (int next : graph[cur]) {
                dfs(graph, next, path, result);
            }
        }
        path.remove(path.size() - 1);
    }
}
