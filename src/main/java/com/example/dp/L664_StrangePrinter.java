package com.example.dp;

/**
 * <p>L664:奇怪的打印机</p>
 * <p>有台奇怪的打印机有以下两个特殊要求：</p>
 * <p>
 *     打印机每次只能打印由 同一个字符 组成的序列。
 *     每次可以在从起始到结束的任意位置打印新字符，并且会覆盖掉原来已有的字符。
 * </p>
 * <p>给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。</p>
 */
public class L664_StrangePrinter {
    public static void main(String[] args) {
        String s = "aaabbb";
        System.out.println(strangePrinter(s));
    }

    /**
     * dp[i][j]:表示打印完成区间 [i,j] 的最少操作数
     */
    private static int strangePrinter(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] charArray = s.toCharArray();
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (charArray[i] == charArray[j]) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int minimum = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minimum = Math.min(minimum, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = minimum;
                }
            }
        }
        return dp[0][len - 1];
    }
}