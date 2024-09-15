package com.example.heap;

import java.util.PriorityQueue;

/**
 * <p>L2462:雇佣 K 位工人的总代价</p>
 * @author zhenwu
 * @date 2024/9/15 17:18
 */
public class L2462_TotalCost {
    public static void main(String[] args) {
        int[] costs = {31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58};
        int k = 11, candidates = 2;
        System.out.println(totalCost(costs, k, candidates));
    }


    /**
     * 小根堆
     * 时间：O((k + candidates) * log candidates)
     * 空间：O(candidates)
     */
    private static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        // 先按照值从小到大排序，值相同的情况下则按照索引从小到大排序
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        // 通过左右指针控制  candidates * 2 是否大于等于 n
        int left = candidates - 1, right = n - candidates;
        if (left + 1 < right) {
            for (int i = 0; i <= left; ++i) {
                pq.offer(new int[]{costs[i], i});
            }
            for (int i = right; i < n; ++i) {
                pq.offer(new int[]{costs[i], i});
            }
        } else {
            for (int i = 0; i < n; ++i) {
                pq.offer(new int[]{costs[i], i});
            }
        }

        long ans = 0;
        for (int i = 0; i < k; ++i) {
            int[] arr = pq.poll();
            int cost = arr[0], id = arr[1];
            ans += cost;
            if (left + 1 < right) {
                if (id <= left) {
                    ++left;
                    pq.offer(new int[]{costs[left], left});
                } else {
                    --right;
                    pq.offer(new int[]{costs[right], right});
                }
            }
        }
        return ans;
    }
}