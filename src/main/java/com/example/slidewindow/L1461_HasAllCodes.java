package com.example.slidewindow;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L1461:检查一个字符串是否包含所有长度为 K 的二进制子串</p>
 * @author zhenwu
 * @date 2025/2/5 20:47
 */
public class L1461_HasAllCodes {
    public static void main(String[] args) {

    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(2^k)
     */
    private static boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if (k > n) {
            return false;
        }
        Set<String> set = new HashSet<>();
        int l = 0, r = k;
        while (r <= n) {
            set.add(s.substring(l++, r++));
            if (set.size() == Math.pow(2, k)) {
                return true;
            }
        }
        return set.size() == Math.pow(2, k);
    }
}
