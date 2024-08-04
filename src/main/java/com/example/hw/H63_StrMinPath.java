package com.example.hw;

import java.util.Scanner;

/**
 * <p>两个字符串间的最短路径问题</p>
 * <p>
 *     给定两个字符串，分别为字符串A与字符串B。
 *     例如A字符串为ABCABBA，B字符串为CBABAC可以得到下图m*n的二维数组，定义原点为(0, 0)，终点为(m, n)，水平与垂直的每一条边距离为1，映射成坐标系如下图。
 *     从原点(0, 0)到(0, A)为水平边，距离为1，从(0, A)到(A, C)为垂直边，距离为1；
 *     假设两个字符串同一位置的两个字符相同则可以作一个斜边，如(A, C)到(B, B)最短距离为斜边，距离同样为1。
 * </p>
 * <p>
 *     输入描述：空格分割的两个字符串A与字符串B，字符串不为“空串”，字符格式满足正则规则:[A-Z]，字符串长度<10000
 * </p>
 * <p>
 *     输出描述：原点到终点的最短距离
 * </p>
 * @author zhenwu
 * @date 2024/7/17 21:03
 */
public class H63_StrMinPath {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] char1 = in.next().toCharArray();
        char[] char2 = in.next().toCharArray();
        int length1 = char1.length;
        int length2 = char2.length;

        // dp[i][j]表示从原点到达(i, j)的最短路径
        int[][] dp = new int[length2 + 1][length1 + 1];
        for (int i = 0; i <= length2; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= length1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= length2; i++) {
            for (int j = 1; j <= length1; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                if (char2[i - 1] == char1[j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        System.out.println(dp[length2][length1]);
    }
}
