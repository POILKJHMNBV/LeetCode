package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L344:反转字符串</p>
 * @author zhenwu
 * @date 2024/8/17 21:54
 */
public class L344_ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    private static void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
