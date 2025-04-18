package com.example.binaryserach;

/**
 * <p>L2594:修车的最少时间</p>
 * @author zhenwu
 * @date 2025/4/18 22:34
 */
public class L2594_RepairCars {

    public static void main(String[] args) {

    }

    /**
     * 时间：O(n log L)，其中 n 为 ranks 的长度，L 为二分的上界。
     * 空间：O(1)
     */
    private static long repairCars(int[] ranks, int cars) {
        long l = 1, r = (long) ranks[0] * cars * cars;
        while (l < r) {
            long m = l + r >> 1;
            if (check(ranks, cars, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private static boolean check(int[] ranks, int cars, long m) {
        long cnt = 0;
        for (int x : ranks) {
            cnt += (long) Math.sqrt(m / x);
        }
        return cnt >= cars;
    }
}
