package com.example.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <p>L802:找到最终的安全状态</p>
 * @author zhenwu
 * @date 2025/8/8 20:50
 */
public class L802_EventualSafeNodes {
    public static void main(String[] args) {
        int[][] graph = {{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}};
        System.out.println(eventualSafeNodes(graph));
    }

    /**
     * 反向拓扑排序
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n + m)
     */
    private static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeList = new ArrayList<>();
        int n = graph.length;
        int[] outdegrees = new int[n];
        List<Integer>[] prevArr = new List[n];
        for (int i = 0; i < n; i++) {
            prevArr[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int[] adjacent = graph[i];
            outdegrees[i] = adjacent.length;
            for (int next : adjacent) {
                prevArr[next].add(i);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (outdegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> prevList = prevArr[node];
            for (int prev : prevList) {
                outdegrees[prev]--;
                if (outdegrees[prev] == 0) {
                    queue.offer(prev);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (outdegrees[i] == 0) {
                safeList.add(i);
            }
        }
        return safeList;
    }
}
