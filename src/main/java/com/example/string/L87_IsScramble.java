package com.example.string;

import java.util.Arrays;

/**
 * <p>L87:扰乱字符串</p>
 * @author zhenwu
 * @date 2024/10/6 22:06
 */
public class L87_IsScramble {
    public static void main(String[] args) {
        String s1 = "eebaacbcbcadaaedceaaacadccd";
        String s2 = "eadcaacabaddaceacbceaabeccd";
        System.out.println(isScramble(s1, s2));
    }

    // TODO: 2024/10/6 22:06
    private static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        if (!check(s1, s2)) {
            return false;
        }
        int len = s1.length();
        for (int i = 1; i < len; ++i) {
            // s1 的 [0,i) 和 [i,n) 和 s2 的 [0,i) 和 [i,n) 是否互为扰乱字符串
            if (isScramble(s1.substring(0, i), s2.substring(0, i))
                    && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }

            // s1 的 [0,i) 和 [i,n) 和 s2 的 [n-i,n) 和 [0, n-i) 是否互为扰乱字符串
            if (isScramble(s1.substring(0, i), s2.substring(len - i))
                    && isScramble(s1.substring(i), s2.substring(0, len - i))) {
                return true;

            }
        }
        return false;
    }

    private static boolean check(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int len = s1.length();
        int[] count1 = new int[26], count2 = new int[26];
        char[] charArray1 = s1.toCharArray(), charArray2 = s2.toCharArray();
        for (int i = 0; i < len; ++i) {
            count1[charArray1[i] - 'a']++;
            count2[charArray2[i] - 'a']++;
        }
        return Arrays.equals(count1, count2);
    }
}
