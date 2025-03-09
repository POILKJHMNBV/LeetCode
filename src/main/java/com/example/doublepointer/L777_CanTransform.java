package com.example.doublepointer;

/**
 * <p>L777:在 LR 字符串中交换相邻字符</p>
 * @author zhenwu
 * @date 2025/3/9 10:25
 * @see L2337_CanChange
 */
public class L777_CanTransform {
    public static void main(String[] args) {
        String start = "XXXXXLXXXX";
        String result = "LXXXXXXXXX";
        System.out.println(canTransform(start, result));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean canTransform(String start, String result) {
        char[] s = start.toCharArray(), t = result.toCharArray();
        int n = s.length, l = 0, r = 0;
        while (l < n && r < n) {
            while (l < n && s[l] == 'X') l++;
            while (r < n && t[r] == 'X') r++;
            if (l == n || r == n) {
                break;
            }
            if (s[l] != t[r]) {
                // 不相等，直接返回false
                return false;
            }
            if (s[l] == 'L' && l < r) {
                // 左边字符是L，但是位置比右边小，说明左边字符移动到了右边，直接返回false
                return false;
            }
            if (s[l] == 'R' && l > r) {
                // 右边字符是R，但是位置比左边大，说明右边字符移动到了左边，直接返回false
                return false;
            }
            l++;
            r++;
        }
        while (l < n) {
            if (s[l] != 'X') {
                return false;
            }
            l++;
        }
        while (r < n) {
            if (t[r] != 'X') {
                return false;
            }
            r++;
        }
        return true;
    }
}
