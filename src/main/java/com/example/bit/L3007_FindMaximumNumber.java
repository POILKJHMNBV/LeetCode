package com.example.bit;

/**
 * <p>L3007:价值和小于等于 K 的最大数字</p>
 * @author zhenwu
 * @date 2025/7/23 21:42
 */
public class L3007_FindMaximumNumber {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O((log k * log k) / x)
     * num 的二进制长度为 m = O(x + log k)，我们统计了其中的 O(m / x) 个比特位，所以每次二分需要 O(log k / x), 再算上O(x + log k) 的二分次数
     * 空间复杂度: O(1)
     */
    private static long findMaximumNumber(long k, int x) {
        long left = 0;
        long right = (k + 1) << x;
        while (left + 1 < right) {
            long mid = (left + right) >>> 1;
            if (countDigitOne(mid, x) <= k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static long countDigitOne(long num, int x) {
        long res = 0;
        // 统计 [1,num] 中的第 i=x,2x,3x,... 个比特位上的 1 的个数
        // 注意比特位从 0 开始，不是从 1 开始，所以要减一
        for (int i = x - 1; (num >> i) > 0; i += x) {
            long n = num >> i;
            res += n >> 1 << i;
            if ((n & 1) > 0) {
                long mask = (1L << i) - 1;
                res += (num & mask) + 1;
            }
        }
        return res;
    }
}
