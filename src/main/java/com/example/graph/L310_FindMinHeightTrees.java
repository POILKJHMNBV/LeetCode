package com.example.graph;

import java.util.*;
/**
 * <p>L310:最小高度树</p>
 * @author zhenwu
 * @date 2024/12/4 21:48
 */
public class L310_FindMinHeightTrees {
    public static void main(String[] args) {

    }

    /**
     * 拓扑排序
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        // 构建图的邻接表表示
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 初始化叶子节点集合
        Set<Integer> leaves = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                leaves.add(entry.getKey());
            }
        }

        // 拓扑排序，逐层删除叶子节点
        while (n > 2) {
            n -= leaves.size();
            Set<Integer> newLeaves = new HashSet<>();
            for (Integer leaf : leaves) {
                int neighbor = graph.get(leaf).get(0);
                graph.get(neighbor).remove((Integer) leaf);
                if (graph.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            leaves = newLeaves;
        }

        // 剩下的节点就是最小高度树的根节点
        return new ArrayList<>(leaves);
    }
}
