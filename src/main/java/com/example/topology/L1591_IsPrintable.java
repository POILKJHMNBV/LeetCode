package com.example.topology;

import java.util.*;

/**
 * <p>L1591:奇怪的打印机 II</p>
 * @author zhenwu
 * @date 2025/8/19 21:54
 */
public class L1591_IsPrintable {
    public static void main(String[] args) {

    }

    /**
     * 拓扑排序
     * 时间复杂度：O(n * m * c), c为是矩阵中的不同颜色数量
     * 空间复杂度：O(n * m * c)
     */
    private static boolean isPrintable(int[][] targetGrid) {
        int maxColor = 0;
        int m = targetGrid.length, n = targetGrid[0].length;
        for (int[] ints : targetGrid) {
            for (int j = 0; j < n; j++) {
                maxColor = Math.max(maxColor, ints[j]);
            }
        }
        int[][] bounds = new int[maxColor + 1][];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = targetGrid[i][j];
                if (bounds[color] == null) {
                    bounds[color] = new int[]{i, i, j, j};
                } else {
                    int[] bound = bounds[color];
                    bound[0] = Math.min(bound[0], i);
                    bound[1] = Math.max(bound[1], i);
                    bound[2] = Math.min(bound[2], j);
                    bound[3] = Math.max(bound[3], j);
                }
            }
        }
        int[] indegrees = new int[maxColor + 1];
        List<Integer>[] nextArr = new List[maxColor + 1];
        for (int i = 1; i <= maxColor; i++) {
            nextArr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = targetGrid[i][j];
                for (int prev = 1; prev <= maxColor; prev++) {
                    if (prev == curr || bounds[prev] == null) {
                        continue;
                    }
                    int[] bound = bounds[prev];
                    if (i >= bound[0] && i <= bound[1] && j >= bound[2] && j <= bound[3]) {
                        indegrees[curr]++;
                        nextArr[prev].add(curr);
                    }
                }
            }
        }
        int count = 0;
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int color = 1; color <= maxColor; color++) {
            if (indegrees[color] == 0) {
                queue.offer(color);
            }
        }
        while (!queue.isEmpty()) {
            int color = queue.poll();
            count++;
            List<Integer> nextList = nextArr[color];
            for (int next : nextList) {
                indegrees[next]--;
                if (indegrees[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return count == maxColor;
    }
}
