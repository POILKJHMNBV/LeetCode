package com.example.dp;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/**
 * <p>L10:正则表达式匹配</p>
 * <p>给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。</p>
 * <p>'.' 匹配任意单个字符、'*' 匹配零个或多个前面的那一个元素</p>
 * <p>所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。</p>
 */
public class L10_IsMatch {
    public static void main(String[] args) {
        String s = "aaa";
        String p = "a*";
        System.out.println(isMatch(s, p));
        LocalDate date = LocalDate.of(2024, 1, 1);
        LocalDate now = LocalDate.now();
        System.out.println(date.until(now, ChronoUnit.DAYS));
    }

    /**
     * dp[i][j]：长度为i的前缀子串s[0:i-1]与长度为j的前缀子串p[0:j-1]是否匹配
     */
    private static boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();

        // 初始化dp
        dp[0][0] = true;
        for (int i = 1; i <= pLen; i++) {
            if (pCharArray[i - 1] == '*' && i >= 2) {
                dp[0][i] = dp[0][i - 2];
            }
        }

        // 开始递推
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (pCharArray[j - 1] != '*') {
                    if (match(sCharArray, i - 1, pCharArray, j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    continue;
                }
                if (match(sCharArray, i - 1, pCharArray, j - 2)) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                } else {
                    dp[i][j] = dp[i][j - 2];
                }
            }
        }

        for (boolean[] booleans : dp) {
            System.out.println(Arrays.toString(booleans));
        }
        return dp[sLen][pLen];
    }

    private static boolean match(char[] sCharArray, int i, char[] pCharArray, int j) {
        return sCharArray[i] == pCharArray[j] || pCharArray[j] == '.';
    }
}
