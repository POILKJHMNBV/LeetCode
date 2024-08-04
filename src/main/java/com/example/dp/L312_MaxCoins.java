package com.example.dp;

/**
 * <p>L312:戳气球</p>
 */
public class L312_MaxCoins {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }

    /**
     * dp[i][j]:dp[i][j] 表示输入数组两端各扩充了一个虚拟气球以后，下标区间 [i..j] 按照题目中的规则戳破以后能够获得的最大分数
     */
    private static int maxCoins(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums[0];
        }

        // 在原始气球两边添加虚拟气球
        int[] newNums = new int[len + 2];
        newNums[0] = 1;
        newNums[len + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, len);
        int[][] dp = new int[len + 2][len + 2];
        for (int L = 1; L <= len; L++) {
            // i 是左边界
            for (int i = 1; i <= len - L + 1; i++) {
                // j 是 i 和 L 确定的情况下，右边界
                int j = i + L - 1;
                // 枚举每一个位置
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + newNums[i - 1] * newNums[k] * newNums[j + 1] + dp[k + 1][j]);
                }
            }
        }
        return dp[1][len];
    }
}
