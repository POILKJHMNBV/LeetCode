package com.example.hw;

import java.util.Scanner;

/**
 * @author zhenwu
 */
public class N71_RegExp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] regArr = in.nextLine().toLowerCase().toCharArray();
        char[] targetArr = in.nextLine().toLowerCase().toCharArray();
        int regLen = regArr.length;
        int targetLen = targetArr.length;
        boolean[][] dp = new boolean[targetLen + 1][regLen + 1];
        dp[0][0] = true;

        for (int i = 1; i <= regLen; i++) {
            if (regArr[i - 1] == '*' && i > 2) {
                dp[0][i] = dp[0][i - 2];
            }
        }

        for (int i = 1; i <= targetLen; i++) {
            for (int j = 1; j <= regLen; j++) {
                if (isMatch(targetArr, i - 1, regArr, j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
    }

    private static boolean canMatch(char ch) {
        return (ch >= 'a' && ch <= 'z') || Character.isDigit(ch);
    }

    private static boolean isMatch(char[] targetArr, int i, char[] regArr, int j) {
        return targetArr[i] == regArr[j] || (regArr[j] == '?' && canMatch(targetArr[i]));
    }
}
