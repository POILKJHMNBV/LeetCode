package com.example.dp;

/**
 * <p>L5:最长回文子串</p>
 * <p>给你一个字符串 s，找到 s 中最长的回文子串</p>
 */
public class L5_LongestPalindrome {
    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindromePro(s));
    }

    /**
     * 暴力求解
     */
    private static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len; i++) {
            int oddLen = expandAroundCenter(charArray, i, i);
            int evenLen = expandAroundCenter(charArray, i, i + 1);
            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                // 这一步要在纸上画图发现规律，分奇数长度回文子串和偶数长度回文子串分类讨论，统一表达式
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 当 left = right 的时候，回文中心是一个字符，回文串的长度是奇数
     * 当 right = left + 1 的时候，此时回文中心两个字符，回文串的长度是偶数
     *
     * @param charArray 原始字符串的字符数组
     * @param left      起始左边界（可以取到）
     * @param right     起始右边界（可以取到）
     * @return 回文串的长度
     */
    private static int expandAroundCenter(char[] charArray, int left, int right) {
        int len = charArray.length;
        while (left >= 0 && right < len) {
            if (charArray[left] == charArray[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }

    /**
     * 动态规划
     * dp[i][j]:子串 s[i..j] 是否为回文子串，这里 i 和 j 分别表示字符串 s 的左右边界，规定 s[i] 和 s[j] 可以取到
     * 递推公式：
     *     dp[i][j] = (s[i] == s[j]) && dp[i + 1][j - 1]
     */
    private static String longestPalindromePro(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // 初始化dp
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        // 开始递推
        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }
}