package com.example.hw;

import java.util.Scanner;

/**
 * <p>字符串拼接</p>
 * <p>
 *     给定 M 个字符(a-z) ，从中取出任意字符(每个字符只能用一次)拼接成长度为 N 的字符串，要求相同的字符不能相邻。
 *     计算出给定的字符列表能拼接出多少种满足条件的字符串，输入非法或者无法拼接出满足条件的字符串则返回 0
 * </p>
 * <p>
 *     输入描述：
 *          给定长度为 M 的字符列表和结果字符串的长度 N ，中间使用空格(" ")拼接。
 *          0 < M < 30，0 < N ≤ 5
 * </p>
 * <p>
 *     输出描述：
 *          输出满足条件的字符串个数。
 * </p>
 * @author zhenwu
 * @date 2024/7/21 11:33
 */
public class H80_ConcatStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.next().toCharArray();
        int n = in.nextInt();
        int[] counter = new int[26];
        for (char ch :chars){
            if (ch >= 'a' && ch <= 'z') {
                counter[ch - 'a']++;
            } else {
                System.out.println(0);
                return;
            }
        }
        System.out.println(backtracking(counter, n, -1));
    }

    /**
     * 暴力递归求解
     * @param counter 字符个数计数器
     * @param n 目标字符串长度
     * @param pre 前一个字符索引
     * @return 满足条件的字符串个数
     */
    private static int backtracking(int[] counter, int n, int pre) {
        if (n == 0) {
            return 1;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            // 前一个字符和当前字符相同或者没有字符了，跳过
            if (counter[i] == 0 || i == pre) {
                continue;
            }

            counter[i]--;
            count += backtracking(counter, n - 1, i);
            counter[i]++;
        }
        return count;
    }
}
