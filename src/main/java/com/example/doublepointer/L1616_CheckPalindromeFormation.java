package com.example.doublepointer;

/**
 * <p>L1616:分割两个字符串得到回文串</p>
 * @author zhenwu
 * @date 2025/2/28 20:03
 */
public class L1616_CheckPalindromeFormation {
    public static void main(String[] args) {
        String a = "cacc";
        String b = "acbc";
        System.out.println(checkPalindromeFormation(a, b));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean checkPalindromeFormation(String a, String b) {
        char[] charA = a.toCharArray(), charB = b.toCharArray();
        int n = charA.length;
        if (isPalindrome(charA, 0, n - 1) || isPalindrome(charB, 0, n - 1)) {
            return true;
        }
        int i = 0, j = n - 1;
        while (i < j) {
            if (charA[i] != charB[j]) {
                break;
            }
            i++;
            j--;
        }
        if (j + 1 == i || j == i || isPalindrome(charA, i, j) || isPalindrome(charB, i, j)) {
            return true;
        }
        i = 0;
        j = n - 1;
        while (i < j) {
            if (charB[i] != charA[j]) {
                break;
            }
            i++;
            j--;
        }
        return j + 1 == i || j == i || isPalindrome(charA, i, j) || isPalindrome(charB, i, j);
    }

    private static boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i++] != chars[j--]) {
                return false;
            }
        }
        return true;
    }
}
