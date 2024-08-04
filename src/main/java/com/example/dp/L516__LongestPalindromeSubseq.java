package com.example.dp;

/**
 * <p>L516:最长回文子序列</p>
 * <p>给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。</p>
 */
public class L516__LongestPalindromeSubseq {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

    /**
     * dp[i][j]: 字符串s在[i, j]范围内最长的回文子序列的长度
     */
    private static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        char[] charArray = s.toCharArray();
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = charArray[i];
            for (int j =  i + 1; j < len; j++) {
                char c2 = charArray[j];
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }
}