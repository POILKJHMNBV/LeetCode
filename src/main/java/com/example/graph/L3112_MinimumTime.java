package com.example.graph;

import java.util.*;

/**
 * <p>L3112:访问消失节点的最少时间</p>
 * @author zhenwu
 * @date 2025/8/24 15:14
 */
public class L3112_MinimumTime {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n + m * log m), 其中 n 为节点数，m 为边数
     * 空间复杂度：O(n + m)
     * <p>Dijkstra算法求最短距离</p>
     * @param n 节点数
     * @param edges 边
     * @param disappear 节点消失时间
     * @return 最短距离
     */
    private static int[] minimumTime(int n, int[][] edges, int[] disappear) {
        // 稀疏图用邻接表表示
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1], w = edge[2];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{y, w});
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{x, w});
        }

        // 距离数组
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        dis[0] = 0;

        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // Dijkstra 算法求解最短距离
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0], d = point[1];
            if (dis[i] < d) {
                // 重复入队的节点不需要重复计算距离
                continue;
            }
            for (int[] next : graph.getOrDefault(i, new ArrayList<>())) {
                int j = next[0], w = next[1], dist = d + w;
                if (dist < disappear[j] && (dis[j] < 0 || dis[j] > dist)) {
                    dis[j] = dist;
                    queue.offer(new int[]{j, dist});
                }
            }
        }
        return dis;
    }
}
