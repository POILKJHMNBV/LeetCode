package com.example.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>字符串分隔（二）</p>
 * <p>
 *     给定一个非空字符串S，其被N个‘-’分隔成N+1的子串，给定正整数K，要求除第一个子串外，其余的子串每K个字符组成新的子串，并用‘-’分隔。
 *     对于新组成的每一个子串，
 *          如果它含有的小写字母比大写字母多，则将这个子串的所有大写字母转换为小写字母；
 *          反之，如果它含有的大写字母比小写字母多，则将这个子串的所有小写字母转换为大写字母；
 *          大小写字母的数量相等时，不做转换。
 * </p>
 * <p>
 *     输入描述：输入为两行，第一行为参数K，第二行为字符串S。
 * </p>
 * <p>
 *     输出描述：输出转换后的字符串
 * </p>
 * @author zhenwu
 * @date 2024/7/22 21:48
 */
public class H91_StrSplit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        String[] strArray = in.next().split("-");
        int length = strArray.length;
        if (length == 1) {
            System.out.println(strArray[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < length; i++) {
            sb.append(strArray[i]);
        }
        List<String> res = new ArrayList<>();
        String s = sb.toString();
        int len = s.length();
        for (int i = 0; i < s.length(); i += k) {
            res.add(transfer(s.substring(i, Math.min(len, i + k))));
        }
        System.out.print(strArray[0]);
        for (String str : res) {
            System.out.print("-" + str);
        }
    }

    private static String transfer(String s) {
        int upperLetterCount = 0, lowerLetterCount = 0;
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            if (ch >= 'A' && ch <= 'Z') {
                upperLetterCount++;
            } else if (ch >= 'a' && ch <= 'z') {
                lowerLetterCount++;
            }
        }
        if (upperLetterCount > lowerLetterCount) {
            return s.toUpperCase();
        } else if (upperLetterCount < lowerLetterCount) {
            return s.toLowerCase();
        } else {
            return s;
        }
    }
}
