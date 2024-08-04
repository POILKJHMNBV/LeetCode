package com.example.dp;

import java.util.Arrays;

/**
 * <p>L1449:数位成本和为目标值的最大数字</p>
 * <p>
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。
 * 由于答案可能会很大，请你以字符串形式返回。
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 * </p>
 */
public class L1449_LargestNumber {
    public static void main(String[] args) {

    }

    /**
     * dp[i][j]:区间[0...i]元素恰好凑成 j 的最大位数
     */
    private static String largestNumber(int[] cost, int target) {
        // 初始化dp
        int len = cost.length;
        int[][] dp = new int[len][target + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        dp[0][0] = 0;
        for (int j = 0; j <= target; j += cost[0]) {
            dp[0][j] = j / cost[0];
        }

        // 开始递推
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - cost[i] >= 0 && dp[i][j - cost[i]] != -1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - cost[i]] + 1);
                }
            }
        }

        if (dp[len - 1][target] == -1) {
            return "0";
        }

        // 开始计算最大整数
        StringBuilder res = new StringBuilder();
        int maxLen = dp[len - 1][target];
        while (target > 0) {
            for (int i = len; i > 0; i--) {
                if (target - cost[i - 1] >= 0 && dp[len - 1][target - cost[i - 1]] == maxLen - 1) {
                    res.append(i);
                    target -= cost[i - 1];
                    maxLen--;
                    break;
                }
            }
        }
        return res.toString();
    }
}
