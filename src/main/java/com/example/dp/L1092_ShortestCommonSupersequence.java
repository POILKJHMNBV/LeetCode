package com.example.dp;

/**
 * <p>L1092:最短公共超序列</p>
 * <p>给你两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为 子序列 的最短字符串。如果答案不止一个，则可以返回满足条件的 任意一个 答案。</p>
 * <p>如果从字符串 t 中删除一些字符（也可能不删除），可以得到字符串 s ，那么 s 就是 t 的一个子序列。</p>
 */
public class L1092_ShortestCommonSupersequence {
    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";
        System.out.println(shortestCommonSupersequence(str1, str2));
    }

    /**
     * 思路：先构造最长公共子序列，最后反着推
     */
    private static String shortestCommonSupersequence(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        char[] charArray1 = (" " + str1).toCharArray();
        char[] charArray2 = (" " + str2).toCharArray();

        // 求取最长公共子序列
        // 初始化dp
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 开始递推
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (charArray1[i] == charArray2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 利用双指针构造结果
        int i = len1, j = len2;
        StringBuilder res = new StringBuilder();
        while (i > 0 || j > 0) {
            if (i == 0) {
                res.append(charArray2[j--]);
            } else if (j == 0) {
                res.append(charArray1[i--]);
            } else {
                if (dp[i][j] == dp[i - 1][j - 1] + 1 && charArray1[i] == charArray2[j]) {
                    res.append(charArray1[i]);
                    i--;
                    j--;
                } else if (dp[i][j] == dp[i - 1][j]) {
                    res.append(charArray1[i--]);
                } else {
                    res.append(charArray2[j--]);
                }
            }
        }

        return res.reverse().toString();
    }
}
