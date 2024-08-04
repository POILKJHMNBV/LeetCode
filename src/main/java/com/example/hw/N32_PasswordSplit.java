package com.example.hw;

import java.util.Scanner;

/**
 * @author zhenwu
 */
public class N32_PasswordSplit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int maxLen = 0;
        if (str.length() == 2) {
            if (str.charAt(0) == str.charAt(1)) {
                maxLen = 2;
            }
        } else if (str.length() == 1) {
            maxLen = 1;
        } else {
            int len = str.length();
            for (int i = 1; i < len - 2; i++) {
                if (str.charAt(i) == str.charAt(i + 1)) {
                    maxLen = Math.max(maxLen, expandStr(str, i, i + 1));
                }
                maxLen = Math.max(maxLen, expandStr(str, i, -1));
            }
        }
        System.out.println(maxLen);
    }

    public static int expandStr(String str, int left, int right) {
        if (right == -1) {
            right = left + 1;
            left--;
        }
        while (left >= 0 && right <= str.length() - 1) {
            if (str.charAt(left) == str.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }
}
