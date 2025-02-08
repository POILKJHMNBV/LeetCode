package com.example.slidewindow;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L1016:子串能表示从 1 到 N 数字的二进制串</p>
 * @author zhenwu
 * @date 2025/2/8 21:34
 */
public class L1016_QueryString {

    public static void main(String[] args) {
        String s = "0110";
        int n = 3;
        System.out.println(queryStringPro(s, n));
    }

    /**
     * 时间复杂度：O(min(m, n) * log min(m, n))
     * 空间复杂度：O(log n)
     */
    private static boolean queryString(String s, int n) {
        for (int i = n; i > 0; i--) {
            if (!s.contains(Integer.toBinaryString(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 时间复杂度：O(m * log n)
     * 空间复杂度：O(n)
     */
    private static boolean queryStringPro(String s, int n) {
        char[] chars = s.toCharArray();
        Set<Integer> set = new HashSet<>();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            int x = chars[i] - '0';
            if (x == 0) {
                continue;
            }
            for (int j = i + 1; x <= n; j++) {
                set.add(x);
                if (set.size() == n) {
                    return true;
                }
                if (j == len) {
                    break;
                }
                x = (x << 1) | (chars[j] - '0');
            }
        }
        return set.size() == n;
    }
}
