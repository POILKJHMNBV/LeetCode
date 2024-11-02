package com.example.string;

/**
 * <p>L214:最短回文串</p>
 * @author zhenwu
 * @date 2024/10/12 21:10
 */
public class L214_ShortestPalindrome {
    public static void main(String[] args) {
        String s = "aacecaaa";
        System.out.println(shortestPalindrome(s));
    }

    /**
     * 求字符串s与其反转字符串的最长公共前缀，然后找到最短回文串的起始位置
     * KMP算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        String combined = s + "#" + rev;

        // 计算字符串s与其反转字符串的最长公共前缀
        int[] lps = new int[combined.length()];
        int j = 0;
        for (int i = 1;i < combined.length();) {
            if (combined.charAt(i) == combined.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        // 找到最短回文串的起始位置
        int lenToAdd = s.length() - lps[lps.length - 1];
        StringBuilder res = new StringBuilder(s.substring(s.length() - lenToAdd));
        return res.reverse() + s;
    }
}
