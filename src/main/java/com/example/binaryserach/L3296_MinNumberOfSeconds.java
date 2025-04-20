package com.example.binaryserach;

import java.util.PriorityQueue;

/**
 * <p>L3296:移山所需的最少秒数</p>
 * @author zhenwu
 * @date 2025/4/16 22:09
 */
public class L3296_MinNumberOfSeconds {

    public static void main(String[] args) {
        int mountainHeight = 4;
        int[] workerTimes = {2, 1, 1};
        System.out.println(minNumberOfSecondsPro(mountainHeight, workerTimes));
    }

    /**
     * 时间：O(log x * n * log m)，其中 x 是 maxT * mountainHeight * (mountainHeight + 1) / 2，n 是 workerTimes 的长度，m 是 mountainHeight
     * 空间：O(1)
     */
    private static long minNumberOfSecondsPro(int mountainHeight, int[] workerTimes) {
        int maxT = workerTimes[0];
        for (int workerTime : workerTimes) {
            maxT = Math.max(maxT, workerTime);
        }
        long left = 0, right = (long) maxT * mountainHeight * (mountainHeight + 1) / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (calTotalHeightReduced(mid, workerTimes, mountainHeight) < mountainHeight) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private static long calTotalHeightReduced(long time, int[] workerTimes, int mountainHeight) {
        long totalHeight = 0;
        for (int workerTime : workerTimes) {
            totalHeight += calHeightReduced(time, workerTime, mountainHeight);
        }
        return totalHeight;
    }

    private static long calHeightReduced(long time, int workerTime, int mountainHeight) {
        long l = 0, r = mountainHeight;
        while (l <= r) {
            long m = l + (r - l) / 2;
            long requiredTime = workerTime * m * (m + 1) / 2;
            if (requiredTime > time) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
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
