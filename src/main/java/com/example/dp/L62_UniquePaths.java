package com.example.dp;

/**
 * <p>L62:不同路径</p>
 * <p>一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。</p>
 * <p>机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。</p>
 * <p>问总共有多少条不同的路径？</p>
 */
public class L62_UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }

    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // 初始化dp数组
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }

        // 开始递推
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
