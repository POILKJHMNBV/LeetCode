package com.example.doublepointer;

/**
 * <p>L3456:找出长度为 K 的特殊子字符串</p>
 * @author zhenwu
 * @date 2025/3/20 21:27
 */
public class L3456_HasSpecialSubstring {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean hasSpecialSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0, n = chars.length; i < n; i++) {
            char ch = chars[i];
            int cnt = 0;
            while (i < n && ch == chars[i]) {
                i++;
                cnt++;
            }
            if (cnt == k) {
                return true;
            }
            i--;
        }
        return false;
    }
}
