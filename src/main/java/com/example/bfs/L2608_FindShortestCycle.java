package com.example.bfs;

import java.util.*;

/**
 * <p>L2608:图中的最短环</p>
 * @author zhenwu
 * @date 2025/8/13 21:45
 */
public class L2608_FindShortestCycle {
    public static void main(String[] args) {

    }

    /**
     * 找到最短环
     * 时间复杂度：O(n * m)，m为边的数量，n为节点数量
     * 空间复杂度：O(n + m)
     */
    private static int findShortestCycle(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        int[] dist = new int[n];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(bfs(graph, i, dist), ans);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     * bfs
     * @param graph 图
     * @param start 起点
     * @param dist 起点到各个节点的距离
     * @return 最短环的长度
     */
    private static int bfs(Map<Integer, List<Integer>> graph, int start, int[] dist) {
        Arrays.fill(dist, -1);
        dist[start] = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        // 当前节点，父节点
        queue.offer(new int[]{start, -1});
        int ans = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int cur = p[0], parent = p[1];
            for (int next : graph.getOrDefault(cur, new ArrayList<>())) {
                if (dist[next] == -1) {
                    // 节点未访问
                    queue.offer(new int[]{next, cur});
                    dist[next] = dist[cur] + 1;
                } else if (next != parent) {
                    // 节点已访问，且不是父节点
                    ans = Math.min(dist[cur] + dist[next] + 1, ans);
                }
            }
        }
        return ans;
    }
}
