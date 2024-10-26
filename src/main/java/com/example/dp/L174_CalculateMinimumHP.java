package com.example.dp;

import java.util.Arrays;

/**
 * <p>L174:地下城游戏</p>
 * @author zhenwu
 * @date 2024/10/26 21:49
 */
public class L174_CalculateMinimumHP {
    public static void main(String[] args) {

    }

    /**
     * 逆序dp, dp[i][j] = max(min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j], 1)
     * 时间复杂度: O(mn)
     * 空间复杂度: O(mn)
     */
    private static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;

        // 初始化 dp 数组, dp[i][j] 表示从 (i, j) 到达终点需要的最小血量
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n - 1] = dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int minn = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(minn - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
