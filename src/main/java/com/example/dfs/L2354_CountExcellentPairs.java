package com.example.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L2354:优质数对的数目</p>
 * @author zhenwu
 * @date 2025/8/7 22:17
 */
public class L2354_CountExcellentPairs {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static long countExcellentPairs(int[] nums, int k) {
        int[] bitCnt = new int[33];
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            //去重
            if (!set.add(num)) {
                continue;
            }
            ++bitCnt[Integer.bitCount(num)];
        }

        long ans = 0;
        for (int i = 0; i <= 32; i++) {
            for (int j = Math.max(0, k - i); j <= 32; j++) {
                ans += (long) bitCnt[i] * bitCnt[j];
            }
        }

        return ans;
    }
}
