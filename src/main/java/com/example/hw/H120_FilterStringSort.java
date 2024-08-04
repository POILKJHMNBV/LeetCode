package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>字符串筛选排序</p>
 * <p>
 *     输入一个由n个大小写字母组成的字符串， 按照 ASCII 码值从小到大的排序规则，查找字符串中第 k 个最小 ASCII 码值的字母(k >= 1) ,
 *     输出该字母所在字符串的位置索引(字符串的第一个字符位置索引为0) 。
 *     如果大于字符串长度，则输出最大 ASCII 码值的字母所在字符串的位置索引;
 *     如果有重复的字母，则输出字母的最小位置索引。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入一个由大小写字母组成的字符串
 *          第二行输入k，k必须大于o，k可以大于输入字符串的长度
 * </p>
 * <p>
 *     输出描述：
 *          输出字符串中第k个最小ASCII码值的字母所在字符串的位置索引,
 *          k如果大于字符串长度，则输出最大ASCII值的字母所在字符串的位置索引，
 *          如果第k个最小ascii码值的字母存在重复，则输出该字母的最小位置索引。
 * </p>
 * @author zhenwu
 * @date 2024/8/3 9:04
 */
public class H120_FilterStringSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char ch = k > s.length() ? chars[s.length() - 1] : chars[k - 1];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                System.out.println(i);
                break;
            }
        }
    }
}
