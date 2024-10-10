package com.example.string;

/**
 * <p>L25:验证回文串</p>
 * @author zhenwu
 * @date 2024/10/10 20:58
 */
public class L125_IsPalindrome {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n)   空间：O(1)
     */
    private static boolean isPalindrome(String s) {
        String newStr = s.trim();
        if (newStr.length() == 0) {
            return true;
        }
        char[] charArray = newStr.toLowerCase().toCharArray();
        int l = 0, r = charArray.length - 1;
        while (l < r) {
            char leftCh = charArray[l], rightCh = charArray[r];
            if (!Character.isLetterOrDigit(leftCh)) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightCh)) {
                r--;
                continue;
            }
            if (leftCh != rightCh) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
