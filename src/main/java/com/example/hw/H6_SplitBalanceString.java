package com.example.hw;

import java.util.Scanner;

/**
 * <p>分割均衡字符串</p>
 * <p>
 *     均衡串定义:字符串只包含两种字符，且两种字符的个数相同。
 *     给定一个均衡字符串，请给出可分割成新的均衡子串的最大个数，分割后的子串，是原字符串的连续子串。
 *     约定字符串中只包含大写的'X"和'Y'两种字符。
 * </p>
 * <p>
 *     输入描述：均衡串:XXYYXY，字符串的长度[2,10000]。给定的字符用均为均衡串。
 * </p>
 * <p>
 *     输出描述：可分割成新的均衡子串的最大个数
 * </p>
 * @author zhenwu
 * @date 2024/6/29 9:56
 */
public class H6_SplitBalanceString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int xCount = 0, yCount = 0, count = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == 'X') {
                xCount++;
            } else {
                yCount++;
            }
            if (xCount == yCount) {
                count++;
                xCount = 0;
                yCount = 0;
            }
        }
        System.out.println(count);
    }
}
