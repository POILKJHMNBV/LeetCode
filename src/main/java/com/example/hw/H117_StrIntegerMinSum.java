package com.example.hw;

import java.util.Scanner;

/**
 * <p>求字符串所有整数最小和</p>
 * <p>
 *     输入字符串s输出s中包含所有整数的最小和，说明：字符串s只包含a~z,A~Z,+,-，
 *     合法的整数包括正整数，一个或者多个0-9组成，如：0,2,3,002,102
 *     负整数，负号开头，数字部分由一个或者多个0-9组成，如-2,-012,-23,-00023
 * </p>
 * <p>
 *     输入描述：包含数字的字符串
 * </p>
 * <p>
 *     输出描述：所有整数的最小和
 * </p>
 * @author zhenwu
 * @date 2024/7/28 10:06
 */
public class H117_StrIntegerMinSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        int len = chars.length;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            char ch = chars[i];
            if (ch == '-') {
                long num = 0;
                while (i + 1 < len && Character.isDigit(chars[i + 1])) {
                    num = 10 * num + (chars[++i] - '0');
                }
                sum -= num;
            } else if (Character.isDigit(ch)) {
                sum += (ch - '0');
            }
        }
        System.out.println(sum);
    }
}
