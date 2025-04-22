package com.example.binaryserach;

/**
 * <p>L2226:每个小孩最多能分到多少糖果</p>
 * @author zhenwu
 * @date 2025/4/22 22:27
 */
public class L2226_MaximumCandies {
    public static void main(String[] args) {
        int[] candies = {2, 5};
        int k = 16;
        System.out.println(maximumCandies(candies, k));
    }

    /**
     * 时间：O(n log L)，其中 n 为 candies 的长度，L 为二分的上界。
     * 空间：O(1)
     */
    private static int maximumCandies(int[] candies, long k) {
        int l = 0, r = candies[0];
        for (int candy : candies) {
            r = Math.max(r, candy);
        }
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (canNotAllocate(candies, m, k)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    private static boolean canNotAllocate(int[] candies, int needCandies, long k) {
        long cnt = 0;
        for (int candy : candies) {
            cnt += Math.floor(candy * 1.0 / needCandies);
        }
        return cnt < k;
    }
}
