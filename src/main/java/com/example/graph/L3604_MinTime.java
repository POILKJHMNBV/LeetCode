package com.example.graph;

import java.util.*;

/**
 * <p>L3604:有向图中到达终点的最少时间</p>
 * @author zhenwu
 * @date 2025/8/25 21:58
 */
public class L3604_MinTime {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1, 0, 1}, {1, 2, 2, 5}};
        System.out.println(minTime(n, edges));
    }

    /**
     * Dijkstra算法
     * 时间复杂度：O(n + m * log m), 其中 n 为节点数，m 为边数
     * 空间复杂度：O(n + m)
     */
    private static int minTime(int n, int[][] edges) {
        List<int[]>[] graph = new List[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] e : edges) {
            List<int[]> ints = graph[e[0]];
            ints.add(new int[]{e[1], e[2], e[3]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int d = point[0], i = point[1];
            if (dist[i] < d) {
                // 重复入队的节点不需要重复计算距离
                continue;
            }
            if (i == n - 1) {
                return d;
            }

            for (int[] next : graph[i]) {
                int j = next[0], startTime = next[1], endTime = next[2];
                int newDis = Math.max(d, startTime) + 1;
                if (Math.max(d, startTime) <= endTime && newDis < dist[j]) {
                    // 满足时间要求且距离更近
                    dist[j] = newDis;
                    queue.offer(new int[]{newDis, j});
                }
            }
        }
        return -1;
    }
}
