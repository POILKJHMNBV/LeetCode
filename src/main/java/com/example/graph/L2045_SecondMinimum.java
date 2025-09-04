package com.example.graph;

import java.util.*;

/**
 * <p>L2045:到达目的地的第二短时间</p>
 * @author zhenwu
 * @date 2025/9/4 21:29
 */
public class L2045_SecondMinimum {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}};
        int time = 3, change = 5;
        System.out.println(secondMinimum(n, edges, time, change));
    }

    /**
     * BFS
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n + m)
     */
    private static int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);
        }

        // dis[i][0] 表示从起点到节点 i 的最短时间，dis[i][1] 表示次短时间
        int[][] dist = new int[n][2];
        dist[0][1] = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // 使用队列进行广度优先搜索(BFS)
        Queue<int[]> queue = new LinkedList<>();
        // 起点为节点 0，时间为 0
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0], d = p[1];
            for (Integer y : graph.getOrDefault(x, new ArrayList<>())) {
                int newD = calTime(d, time, change);
                if (newD < dist[y][0]) {
                    // 更新 y 的最短时间
                    dist[y][0] = newD;
                    queue.offer(new int[]{y, newD});
                } else if (newD < dist[y][1] && newD > dist[y][0]) {
                    // 找到 y 的次短时间
                    dist[y][1] = newD;
                    queue.offer(new int[]{y, newD});
                }
            }
        }

        // 返回节点 n-1 的次短时间
        return dist[n - 1][1];
    }

    /**
     * 从当前节点出发, 计算到达下一个节点的时刻
     * @param curTime 当前时间
     * @param time 耗时
     * @param change 变换时间
     * @return 下一个节点的到达时间
     */
    private static int calTime(int curTime, int time, int change) {
        int times = curTime / change;
        return times % 2 == 0 ? curTime + time : (times + 1) * change + time;
    }
}
