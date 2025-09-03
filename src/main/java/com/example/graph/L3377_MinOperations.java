package com.example.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>L3377:使两个整数相等的数位操作</p>
 * @author zhenwu
 * @date 2025/9/3 21:33
 */
public class L3377_MinOperations {
    public static void main(String[] args) {
        int n = 10, m = 12;
        System.out.println(minOperations(n, m));
    }

    /**
     * Dijkstra算法
     * 时间复杂度: O(M * log M), 其中 M = n * log n, 图中有 O(n) 个顶点, 每一个顶点最多有 O(log n) 个相邻顶点, 所以总边数最多为 O(n log n), 堆的时间复杂度为 O(log M)
     * 空间复杂度: O(M)
     */
    private static int minOperations(int n, int m) {
        int max = 10000;

        // 记录不是质数的数字
        boolean[] np = new boolean[max];
        np[0] = np[1] = true;
        // 埃氏筛法快速筛选质数
        for (int i = 2; i < max; i++) {
            if (np[i]) {
                continue;
            }
            for (int j = i * i; j < max; j += i) {
                np[j] = true;
            }
        }

        if (!np[m] || !np[n]) {
            return -1;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{n, n});
        int len = String.valueOf(n).length();
        // 存储每个数字最小的操作代价
        int[] dist = new int[(int) Math.pow(10, len)];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = n;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int d = p[0], x = p[1];
            if (x == m) {
                return d;
            }
            if (d > dist[x]) {
                continue;
            }
            int power = 1;
            // 枚举 x 的数位
            for (int v = x; v > 0; v /= 10) {
                // 获取 x 的当前数位
                int digit = v % 10;
                if (digit > 0) {
                    // 减小数字
                    int y = x - power;
                    int newDis = d + y;
                    if (np[y] && newDis < dist[y]) {
                        // y 不是质数, 且操作代价更小, 则加入队列
                        dist[y] = newDis;
                        queue.add(new int[]{newDis, y});
                    }
                }

                if (digit < 9) {
                    // 增加数字
                    int y = x + power;
                    int newDis = d + y;
                    if (np[y] && newDis < dist[y]) {
                        dist[y] = newDis;
                        queue.add(new int[]{newDis, y});
                    }
                }
                power *= 10;
            }
        }
        return -1;
    }
}
