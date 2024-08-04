package com.example.hw;

import java.util.Scanner;

/**
 * <p>
 * 描述
 *      计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 *      输入一行，代表要计算的字符串，非空，长度小于5000。
 * 输出描述：
 *      输出一个整数，表示输入字符串最后一个单词的长度。
 * </p>
 *10.70.44.68~255.254.255.0
 * 1.0.0.1~255.0.0.0
 * 192.168.0.2~255.255.255.0
 * 19..0.~255.255.255.0
 */
public class N1_LastWordLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strArray = line.split(" ");
        System.out.println(strArray[strArray.length - 1].length());
    }
}
