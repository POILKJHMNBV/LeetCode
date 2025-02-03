package com.example.doublepointer;

/**
 * <p>L680:验证回文串 II</p>
 * <p>
 * 给你一个字符串 s，最多可以从中删除一个字符。
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * </p>
 * @author zhenwu
 * @date 2025/2/3 17:27
 */
public class L680_ValidPalindrome {

    public static void main(String[] args) {

    }

    private static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                // 尝试跳过左边或右边的字符，检查剩余部分是否为回文
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
