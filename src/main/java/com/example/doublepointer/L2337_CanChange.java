package com.example.doublepointer;

/**
 * <p>L2337:移动片段得到字符串</p>
 * @author zhenwu
 * @date 2025/3/9 9:06
 */
public class L2337_CanChange {
    public static void main(String[] args) {
        String start = "_L";
        String target = "LR";
        System.out.println(canChange(start, target));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean canChange(String start, String target) {
        char[] s = start.toCharArray(), t = target.toCharArray();
        int n = s.length, l = 0, r = 0;
        while (l < n && r < n) {
            while (l < n && s[l] == '_') l++;
            while (r < n && t[r] == '_') r++;
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
            if (s[l] != '_') {
                return false;
            }
            l++;
        }
        while (r < n) {
            if (t[r] != '_') {
                return false;
            }
            r++;
        }
        return true;
    }
}
