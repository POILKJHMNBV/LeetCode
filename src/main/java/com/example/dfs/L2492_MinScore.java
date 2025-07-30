package com.example.dfs;

import java.util.*;

/**
 * <p>L2492:两个城市间路径的最小分数</p>
 * @author zhenwu
 * @date 2025/7/30 22:01
 */
public class L2492_MinScore {
    public static void main(String[] args) {
        int n = 6;
        int[][] roads = {
                {4, 5, 7468},
                {6, 2, 7173},
                {6, 3, 8365},
                {2, 3, 7674},
                {5, 6, 7852},
                {1, 2, 8547},
                {2, 4, 1885},
                {2, 5, 5192},
                {1, 3, 4065},
                {1, 4, 7357}
        };
        System.out.println(minScore(n, roads));
    }

    /**
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n + m)
     */
    private static int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] road : roads) {
            graph.computeIfAbsent(road[0], k -> new ArrayList<>()).add(new int[]{road[1], road[2]});
            graph.computeIfAbsent(road[1], k -> new ArrayList<>()).add(new int[]{road[0], road[2]});
        }
        boolean[] visited = new boolean[n];
        Set<Integer> distances = new HashSet<>();
        dfs(visited, graph, 1, distances);
        return distances.stream().min(Integer::compareTo).orElse(-1);
    }

    private static void dfs(boolean[] visited,
                            Map<Integer, List<int[]>> graph,
                            int cur,
                            Set<Integer> distances) {
        visited[cur - 1] = true;
        if (graph.containsKey(cur)) {
            for (int[] next : graph.get(cur)) {
                distances.add(next[1]);
                if (!visited[next[0] - 1]) {
                    dfs(visited, graph, next[0], distances);
                }
            }
        }
    }
}
