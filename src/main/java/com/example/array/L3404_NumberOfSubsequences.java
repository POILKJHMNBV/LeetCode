package com.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L3404:统计特殊子序列的数目</p>
 * @author zhenwu
 * @date 2025/5/7 21:56
 */
public class L3404_NumberOfSubsequences {

    public static void main(String[] args) {

    }

    /**
     * p < q < r < s(q - p > 1, r - q > 1, s - r > 1)
     * nums[p] * nums[r] == nums[q] * nums[s]
     * nums[p] / nums[q] == nums[s] / nums[r]
     * a / b == d / c
     * 时间复杂度：O(n * n * log U)，其中 n 是 nums 的长度，U=max(nums)。计算一次 GCD 需要 O(logU) 的时间
     * 空间复杂度：O(min(n * n, U * U))
     */
    private static long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> suf = new HashMap<>();
        // 枚举 c
        for (int i = 4; i < n - 2; i++) {
            int c = nums[i];
            // 枚举 d
            for (int j = i + 2; j < n; j++) {
                int d = nums[j];
                int g = gcd(c, d);
                // 把分子和分母（两个 short）压缩成一个 int
                suf.merge((d / g) << 16 | (c / g), 1, Integer::sum);
            }
        }

        long ans = 0;
        // 枚举 b
        for (int i = 2; i < n - 4; i++) {
            int b = nums[i];
            // 枚举 a
            for (int j = 0; j < i - 1; j++) {
                int a = nums[j];
                int g = gcd(a, b);
                ans += suf.getOrDefault((a / g) << 16 | (b / g), 0);
            }
            // 撤销之前统计的 d'/c'
            int c = nums[i + 2];
            for (int j = i + 4; j < n; j++) {
                int d = nums[j];
                int g = gcd(c, d);
                suf.merge((d / g) << 16 | (c / g), -1, Integer::sum);
            }
        }
        return ans;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
