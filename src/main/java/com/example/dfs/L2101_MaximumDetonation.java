package com.example.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L2101:引爆最多的炸弹</p>
 * @author zhenwu
 * @date 2025/8/5 22:00
 */
public class L2101_MaximumDetonation {
    public static void main(String[] args) {
        int[][] bombs = {{1,1,100000}, {100000,100000,1}};
        System.out.println(maximumDetonation(bombs));
    }

    /**
     * 时间复杂度：O(n^3)，其中 n 是 bombs 的长度。注意图中至多有 O(n^2)条边
     * 空间复杂度：O(n^2)
     */
    private static int maximumDetonation(int[][] bombs) {
        int length = bombs.length;
        Map<Integer, List<Integer>> graph = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            int x = bombs[i][0], y = bombs[i][1];
            long r = bombs[i][2];
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    continue;
                }
                long dx = bombs[j][0] - x, dy = bombs[j][1] - y;
                if (dx * dx + dy * dy <= r * r) {
                    graph.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < length && res < length; i++) {
            res = Math.max(res, dfs(graph, i, new boolean[length]));
        }
        return res;
    }

    private static int dfs(Map<Integer, List<Integer>> graph, int x, boolean[] visited) {
        visited[x] = true;
        int res = 1;
        for (int next : graph.getOrDefault(x, new ArrayList<>())) {
            if (!visited[next]) {
                res += dfs(graph, next, visited);
            }
        }
        return res;
    }
}
