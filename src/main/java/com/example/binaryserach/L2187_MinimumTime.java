package com.example.binaryserach;

/**
 * <p>L2187:完成旅途的最少时间</p>
 * @author zhenwu
 * @date 2025/4/14 22:19
 */
public class L2187_MinimumTime {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n log m), 其中 n 为 time 的长度，m 为二分上下界之差。在本题数据范围下，m 不会超过 10^14
     * 空间：O(1)
     */
    private static long minimumTime(int[] time, int totalTrips) {
        long minTime = time[0];
        for (int t : time) {
            minTime = Math.min(minTime, t);
        }
        long l = minTime - 1, r = minTime * totalTrips;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (canFinishTrip(m, time, totalTrips)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private static boolean canFinishTrip(long minTime, int[] time, int totalTrips) {
        long sum = 0;
        for (int t : time) {
            sum += Math.floor(minTime * 1.0 / t);
            if (sum >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}
