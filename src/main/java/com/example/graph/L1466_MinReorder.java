package com.example.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L1466:重新规划路线</p>
 * @author zhenwu
 * @date 2024/9/10 20:03
 */
public class L1466_MinReorder {
    public static void main(String[] args) {

    }

    private static int count;

    private static int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = buildGraph(connections);
        dfs(graph, new boolean[n], 0);
        return count;
    }

    private static void dfs(List<List<Integer>> graph, boolean[] visited, int city) {
        visited[city] = true;
        for (int adjacency : graph.get(city)) {
            if (!visited[Math.abs(adjacency)]) {
                if (adjacency > 0) {
                    count++;
                }
                dfs(graph, visited, Math.abs(adjacency));
            }
        }
    }

    private static List<List<Integer>> buildGraph(int[][] connections) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = connections.length + 1;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(to);
            graph.get(to).add(-from);
        }
        return graph;
    }
}
