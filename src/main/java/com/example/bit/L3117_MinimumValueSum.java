package com.example.bit;

import java.util.HashMap;

/**
 * <p>L3117:划分数组得到最小的值之和</p>
 * @author zhenwu
 * @date 2025/7/18 21:45
 */
public class L3117_MinimumValueSum {
    public static void main(String[] args) {

    }

    private static int minimumValueSum(int[] nums, int[] andValues) {
        HashMap<Long, Integer> memo = new HashMap<>();
        int ans = dfs(0, 0, -1, nums, andValues, memo);
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    /**
     * 动态规划
     * 时间复杂度：O(nmlogU)，其中 n 为 nums 的长度，
     * m 为 andValues 的长度，U=max(nums)。
     * 由于每个状态只会计算一次，动态规划的时间复杂度 = 状态个数 × 单个状态的计算时间。
     * 本题状态个数等于 O(nmlogU)，单个状态的计算时间为 O(1)，所以动态规划的时间复杂度为 O(nmlogU)。
     * 空间复杂度：O(nmlogU)，其中 n 为 nums 的长度，
     */
    private static int dfs(int i, int j, int and, int[] nums, int[] andValues, HashMap<Long, Integer> memo) {
        int n = nums.length;
        int m = andValues.length;
        if (n - i < m - j) { // 剩余元素不足
            return Integer.MAX_VALUE / 2; // 除 2 防止下面 + nums[i] 溢出
        }
        if (j == m) { // 分了 m 段
            return i == n ? 0 : Integer.MAX_VALUE / 2;
        }
        and &= nums[i];
        // 三个参数压缩成一个 long
        long mask = (long) i << 36 | (long) j << 32 | and;
        if (memo.containsKey(mask)) { // 之前计算过
            return memo.get(mask);
        }
        int res = dfs(i + 1, j, and, nums, andValues, memo); // 不划分
        if (and == andValues[j]) { // 划分，nums[i] 是这一段的最后一个数
            res = Math.min(res, dfs(i + 1, j + 1, -1, nums, andValues, memo) + nums[i]);
        }
        memo.put(mask, res); // 记忆化
        return res;
    }
}
