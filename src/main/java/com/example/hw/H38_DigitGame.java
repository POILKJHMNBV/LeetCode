package com.example.hw;

import java.util.Scanner;

/**
 * <p>小扇和小船的数字游戏</p>
 * <p>
 *     小扇和小船今天又玩起来了数字游戏，
 *     小船给小扇一个正整数 n（1 ≤ n ≤ 1e9），小扇需要找到一个比 n 大的数字 m，使得 m 和 n 对应的二进制中 1 的个数要相同，如
 *          4对应二进制100
 *          8对应二进制1000
 *          其中1的个数都为1个
 *     现在求 m 的最小值。
 * </p>
 * <p>
 *     输入描述：输入一个正整数 n（1 ≤ n ≤ 1e9）
 * </p>
 * <p>
 *     输出描述：输出一个正整数 m
 * </p>
 * @author zhenwu
 * @date 2024/7/13 13:51
 */
public class H38_DigitGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        /*
            1.若n的二进制为连续的1和连续的0，例如4，7，14，只需在后面添一个0，然后从第2个1开始所有1往后移
                4 -> 100 -> 1000 -> 8
                7 -> 111 -> 1110 -> 1011 -> 11
                12 -> 1100 -> 11000 -> 10001 -> 17
                14 -> 1110 -> 11100 -> 10011 -> 19
            2.反之，只需从低位往高位遍历，找到右边有1的第一个0，将这个0与1交换即可
                5 -> 101 -> 110 -> 6
                9 -> 1001 -> 1010 -> 10
                11 -> 1011 -> 1101 -> 13
                18 -> 10010 -> 10100 -> 20
         */
        String binaryString = Integer.toBinaryString(n);
        char[] binaryArray = binaryString.toCharArray();
        int zeroIndex = -1, oneIndex = -1;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryArray[i] == '0' && oneIndex == -1) {
                zeroIndex = i;
            }
            if (binaryArray[i] == '1' && zeroIndex != -1 && oneIndex == -1) {
                oneIndex = i;
            }
        }
        if (oneIndex == -1) {
            // 第一种情况
            char[] newBinaryArray = (binaryString + "0").toCharArray();
            int lastOneIndex = binaryString.lastIndexOf('1');
            if (lastOneIndex != 0) {
                int length = newBinaryArray.length;
                for (int i = 1; i < length; i++) {
                    newBinaryArray[i] = lastOneIndex >= (length - i) ? '1' : '0';
                }
            }
            System.out.println(binaryStringToDigit(newBinaryArray));
        } else {
            // 第二种情况
            binaryArray[zeroIndex] = '1';
            binaryArray[oneIndex] = '0';
            System.out.println(binaryStringToDigit(binaryArray));
        }
    }

    private static int binaryStringToDigit(char[] binaryArray) {
        int res = 0;
        int len = binaryArray.length;
        for (int i = 0; i < len; i++) {
            if (binaryArray[i] == '1') {
                res += Math.pow(2, len - 1 - i);
            }
        }
        return res;
    }
}
