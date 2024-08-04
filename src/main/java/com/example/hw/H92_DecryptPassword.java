package com.example.hw;

import java.util.Scanner;

/**
 * <p>密码解密</p>
 * <p>
 *     给定一段 “密文”字符串 s ，其中字符都是经过 “密码本” 映射的，现需要将“密文”解密并且输出。
 *     映射的规则：
 *          (a−i)分别用(1−9)表示；
 *          (j−z)分别用(10∗−26∗)表示。
 *     约束：映射始终唯一
 * </p>
 * <p>
 *     输入描述：“密文”字符串
 *     输出描述：明文字符串
 * </p>
 * @author zhenwu
 * @date 2024/7/22 22:05
 */
public class H92_DecryptPassword {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char ch = chars[i];
            int num;
            if (i + 2 < len && chars[i + 2] == '*') {
                num = 10 * (ch - '0') + (chars[i + 1] - '0');
                i += 2;
            } else {
                num = ch - '0';
            }
            System.out.print((char) ('a' + num - 1));
        }
    }
}
