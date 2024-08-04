package com.example.slidewindow;

/**
 * <p>L76:最小覆盖子串</p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 */
public class L76_MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen) {
            return "";
        }
        // 滑动窗口
        int[] window = new int[128];
        int[] pattern = new int[128];
        for (int i = 0; i < tLen; i++) {
            pattern[t.charAt(i) - 'A']++;
        }

        // 记录匹配次数
        int distance = 0;
        for (int p : pattern) {
            if (p > 0) {
                distance++;
            }
        }

        // 记录最小覆盖子串起始位置
        int start = 0;

        // 记录最小覆盖子串长度
        int minLen = sLen + 1;

        // 记录匹配次数
        int match = 0;

        int left = 0, right = 0;

        while (right < sLen) {
            char rightChar = s.charAt(right);
            if (pattern[rightChar - 'A'] > 0) {
                window[rightChar - 'A']++;
                if (pattern[rightChar - 'A'] == window[rightChar - 'A']) {
                    match++;
                }
            }

            right++;

            while (distance == match) {
                // 更新最小覆盖子串和起始位置
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                // 尝试缩小窗口
                char leftChar = s.charAt(left);
                if (pattern[leftChar - 'A'] > 0) {
                    window[leftChar - 'A']--;
                    if (window[leftChar - 'A'] < pattern[leftChar - 'A'] ) {
                        match--;
                    }
                }
                left++;
            }
        }
        return minLen == sLen + 1 ? "" : s.substring(start, start + minLen);
    }
}
