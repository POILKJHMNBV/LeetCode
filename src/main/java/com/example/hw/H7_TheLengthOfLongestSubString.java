package com.example.hw;

import java.util.Scanner;

/**
 * <p>最长子字符串的长度</p>
 * <p>
 *     给你一个字符串 s，字符串s首尾相连成一个环形，请你在环中找出字符o出现了偶数次最长子字符串的长度。
 * </p>
 * @author zhenwu
 * @date 2024/6/29 10:10
 */
public class H7_TheLengthOfLongestSubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] charArray = in.nextLine().toCharArray();
        int count = 0;
        for (char ch : charArray) {
            if (ch == 'o') {
                count++;
            }
        }
        if (count % 2 == 0) {
            System.out.println(charArray.length);
        } else {
            System.out.println(charArray.length - 1);
        }
    }
}
