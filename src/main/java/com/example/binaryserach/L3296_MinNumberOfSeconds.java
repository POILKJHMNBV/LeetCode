package com.example.binaryserach;

import java.util.PriorityQueue;

/**
 * <p>L3296:移山所需的最少秒数</p>
 * @author zhenwu
 * @date 2025/4/16 22:09
 */
public class L3296_MinNumberOfSeconds {

    public static void main(String[] args) {

    }

    /**
     * 时间：O(mountainHeight * log n)，其中 n 是 workerTimes 的长度。
     * 空间：O(n)
     */
    private static long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        for (int t : workerTimes) {
            pq.offer(new long[]{t, t, t});
        }
        long ans = 0;
        while (mountainHeight-- > 0) {
            // 工作后总用时，当前工作（山高度降低 1）用时，workerTimes[i]
            long[] w = pq.poll();
            long nxt = w[0], delta = w[1], base = w[2];
            ans = nxt; // 最后一个出堆的 nxt 即为答案
            pq.offer(new long[]{nxt + delta + base, delta + base, base});
        }
        return ans;
    }
}
