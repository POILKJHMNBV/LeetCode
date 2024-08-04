package com.example.dp;

/**
 * <p>L132:分割回文串 II</p>
 * <p>给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是回文。
 * 返回符合要求的最少分割次数 </p>
 */
public class L132_MinCut {
    public static void main(String[] args) {

    }

    /**
     * dp[i]: s[0...i]进行分割，符合要求的最少分割次数
     */
    private static int minCut(String s) {
        int len = s.length();
        if (len < 2) {
            return 0;
        }

        // 利用dp数组数组存储当前子串是否是回文子串，减少判断回文子串的时间
        boolean[][] checkPalindrome = new boolean[len][len];
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || checkPalindrome[left + 1][right - 1])) {
                    checkPalindrome[left][right] = true;
                }
            }
        }

        // 初始化dp，都初始化为最大值
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = i;
        }

        // 开始递推
        for (int i = 1; i < len; i++) {
            if (checkPalindrome[0][i]) {
                // 当前子串是回文子串
                dp[i] = 0;
                continue;
            }
            
            // 当前子串不是回文子串，进行切割，寻找最小切割数
            for (int j = 0; j < i; j++) {
                if (checkPalindrome[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }
}
