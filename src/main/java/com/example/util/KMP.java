package com.example.util;

/**
 * KMP算法实现
 * @author zhenwu
 * @date 2024/8/18 17:17
 */
public final class KMP {

    public static int indexOf(String s, String pattern) {
        int n = s.length(), m = pattern.length(), i = 0, j = 0;
        if (m > n) {
            return -1;
        }
        int[] next = nextArray(pattern.toCharArray());
        while (i < n && j < m) {
            if (s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (j == 0) {
                i++;
            } else {
                j = next[j];
            }
        }
        return j == m ? i - j : -1;
    }


    /**
     * 求取nextArray数组
     * next[i]:表示0...i-1的子串s的前缀子串和后最子串相等的最长长度，不包括子串s本身
     * chars = {a, a, b, c, a, a, b}
     * next = {-1, 0, 1, 0, 0, 0, 2}
     */
    private static int[] nextArray(char[] chars) {
        int len = chars.length;
        if (len == 1) {
            return new int[] {-1};
        }
        int[] next = new int[len];
        next[0] = -1;
        next[1] = 0;
        // cnt表示当前字符和前一个要比对字符的下标
        int i = 2, cnt = 0;
        while (i < len) {
            if (chars[i - 1] == chars[cnt]) {
                next[i++] = ++cnt;
            } else if (cnt > 0) {
                // cnt不为0，还能往前跳
                cnt = next[cnt];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
