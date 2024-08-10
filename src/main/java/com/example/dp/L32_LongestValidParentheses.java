package com.example.dp;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>L32:最长有效括号</p>
 * <p>
 *     给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * </p>
 * @author zhenwu
 * @date 2024/8/10 17:51
 */
public class L32_LongestValidParentheses {
    public static void main(String[] args) {
        String s = "((((())";
        System.out.println(longestValidParentheses(s));
        System.out.println(longestValidParenthesesPro(s));
    }

    /**
     * 动态规划
     * 时间：O(n)
     * 空间：O(n)
     */
    private static int longestValidParenthesesPro(String s) {
        int length = s.length();
        // dp[i]:表示以i位置的字符结尾最长有效括号子串的长度
        int[] dp = new int[length];
        int maxLen = 0;
        for (int i = 1; i < length; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + dp[i - 1] + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    /**
     * 暴力求解
     * 时间：O(n<sup>3</sup>)
     * 空间：O(n)
     */
    private static int longestValidParentheses(String s) {
        int length = s.length();
        if (length < 2) {
            return 0;
        }
        int maxLen = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 2; j <= length; j += 2) {
                if (validParentheses(s.substring(i, j))) {
                    maxLen = Math.max(j - i, maxLen);
                }
            }
        }
        return maxLen;
    }

    private static boolean validParentheses(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : chars) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
