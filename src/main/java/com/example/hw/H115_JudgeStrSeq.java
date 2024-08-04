package com.example.hw;

import java.util.Scanner;

/**
 * <p>字符串序列判定</p>
 * <p>
 *     输入两个字符串S和L，都只包含英文小写字母。S长度<=100，L长度<=500,000。判定S是否是L的有效字串。
 *     判定规则:
 *          S中的每个字符在L中都能找到(可以不连续)，且S在L中字符的前后顺序与S中顺序要保持一致。
 *          (例如，S="ace"是L="abcde”的一个子序列且有效字符是a、c、e，而”aec"不是有效子序列，且有效字符只有a、e)
 * </p>
 * <p>
 *     输入描述：输入两个字符串S和L，都只包含英文小写字母。S长度<=100，L长度<=500,000 先输入S，再输入L，每个字符串占一行。
 * </p>
 * <p>
 *     输出描述：S串最后一个有效字符在L中的位置。 (首位从0开始计算，无有效字符返回-1)
 * </p>
 * @author zhenwu
 * @date 2024/7/28 8:59
 */
public class H115_JudgeStrSeq {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars1 = in.nextLine().toCharArray();
        char[] chars2 = in.nextLine().toCharArray();
        int j = 0, lastIndex = -1;
        for (int i = 0; i < chars2.length; i++) {
            if (chars1[j] == chars2[i]) {
                j++;
                lastIndex = i;
            }
        }
        if (j == chars1.length) {
            System.out.println(lastIndex);
        } else {
            System.out.println(-1);
        }
    }
}
