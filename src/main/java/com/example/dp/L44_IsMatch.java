package com.example.dp;

/**
 * <p>L44:通配符匹配</p>
 * <p>给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：</p>
 * <p>
 *   '?' 可以匹配任何单个字符。
 *   '*' 可以匹配任意字符序列（包括空字符序列）。
 * </p>
 * <p>判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。</p>
 */
public class L44_IsMatch {
    public static void main(String[] args) {
        String s = "aa", p = "a";
        System.out.println(isMatch(s, p));
    }

    private static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

        // 初始化dp
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 1; i <= pLen; i++) {
            dp[0][i] = dp[0][i - 1] && pCharArray[i - 1] == '*';
        }

        // 开始递推
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (sCharArray[i - 1] == pCharArray[j - 1] || pCharArray[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (pCharArray[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
            }
        }

        return dp[sLen][pLen];
    }
}
