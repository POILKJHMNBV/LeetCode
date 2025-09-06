package com.example.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>L882:细分图中的可到达节点</p>
 * @author zhenwu
 * @date 2025/9/6 10:34
 */
public class L882_ReachableNodes {
    public static void main(String[] args) {

    }

    private static int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<int[]>[] graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], cnt = edge[2];
            graph[y].add(new int[]{x, cnt + 1});
            graph[x].add(new int[]{y, cnt + 1});
        }

        int[] dist = GraphUtil.dijkstra(n, graph);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] <= maxMoves) {
                ans++;
            }
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], cnt = edge[2];
            int a = Math.max(0, maxMoves - dist[x]);
            int b = Math.max(0, maxMoves - dist[y]);
            ans += Math.min(cnt, a + b);
        }
        return ans;
    }
}
