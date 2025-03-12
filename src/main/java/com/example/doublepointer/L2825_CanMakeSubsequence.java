package com.example.doublepointer;

/**
 * <p>L2825:循环增长使字符串子序列等于另一个字符串</p>
 * @author zhenwu
 * @date 2025/3/12 20:09
 */
public class L2825_CanMakeSubsequence {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean canMakeSubsequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        if (m < n) {
            return false;
        }
        int i = 0, j = 0;
        while (i < m && j < n) {
            char ch1 = str1.charAt(i), ch2 = str2.charAt(j);
            if (ch1 == ch2 || (ch1 == 'z' && ch2 == 'a') || ch1 + 1 == ch2) {
                j++;
            }
            i++;
        }
        return j == n;
    }
}
