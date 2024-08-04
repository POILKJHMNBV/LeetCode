package com.example.hw;

import java.util.Scanner;

/**
 * <p>字符串变换最小字符串</p>
 * <p>
 *     给定一个字符串s, 最多只能进行一次变换， 返回变换后能得到的最小字符串（按照字典序进行比较）
 *     变换规则： 交换字符串中任意两个不同位置的字符
 * </p>
 * <p>
 *     输入描述：一串小写字母组成的字符串s，s是都是小写字符组成，1<=s.length<=1000
 * </p>
 * <p>
 *     输出描述：按照要求进行变换得到的最小字符串。
 * </p>
 * @author zhenwu
 * @date 2024/7/22 21:10
 */
public class H89_StrChangeToMinStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if (chars[j] < chars[index]) {
                    index = j;
                }
            }

            if (index != i) {
                char tmp = chars[i];
                chars[i] = chars[index];
                chars[index] = tmp;
                break;
            }
        }
        System.out.println(new String(chars));
    }
}
