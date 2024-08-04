package com.example.dp;

/**
 * <p>L1143:最长公共子序列</p>
 * <p>给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。</p>
 */
public class L1143_LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "abe";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    /**
     * dp[i][j]: 表示 text1 前面 i 个字符与 text2 前面 j 个字符的最长公共子序列长度
     */
    private static int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        char[] charArray1 = text1.toCharArray();
        char[] charArray2 = text2.toCharArray();

        // 初始化dp
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 开始递推
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
