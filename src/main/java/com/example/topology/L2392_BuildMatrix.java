 package com.example.topology;

import java.util.*;

/**
 * <p>L2392:给定条件下构造矩阵</p>
 * @author zhenwu
 * @date 2025/8/18 21:43
 */
public class L2392_BuildMatrix {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(k * k + m + n)
     * 空间复杂度：O(k + m + n)
     */
    private static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // BFS拓扑排序
        Queue<Integer> que = new ArrayDeque<>(k);
        int[] sortedRowIdx = getSortedIdx(k, que, rowConditions);
        if (sortedRowIdx.length == 0) {
            // 存在环
            return new int[0][0];
        }
        int[] sortedColIdx = getSortedIdx(k, que, colConditions);
        if (sortedColIdx.length == 0) {
            return new int[0][0];
        }
        // 组装矩阵
        int[][] res = new int[k][k];
        for (int i = 0; i < k; i++) {
            res[sortedRowIdx[i]][sortedColIdx[i]] = i + 1;
        }
        return res;
    }

    private static int[] getSortedIdx(int k, Queue<Integer> que, int[][] conditions) {
        List<List<Integer>> graph = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[k];
        for (int[] row : conditions) {
            graph.get(row[0] - 1).add(row[1] - 1);
            inDegree[row[1] - 1]++;
        }
        int[] sortedIdx = new int[k];
        int idx = 0;
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                que.offer(i);
                sortedIdx[i] = idx;
                idx++;
            }
        }
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    que.offer(next);
                    sortedIdx[next] = idx;
                    idx++;
                }
            }
        }
        return idx == k ? sortedIdx : new int[0];
    }
}
