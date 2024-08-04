package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>整型数组按个位值排序</p>
 * <p>
 *     给定一个非空数组(列表)，其元素数据类型为整型，请按照数组元素十进制最低位从小到大进行排序，十进制最低位相同的元素，相对位置保持不变。
 *     当数组元素为负值时，十进制最低位等同于去除符号位后对应十进制值最低位。
 * </p>
 * <p>
 *     输入描述：给定一个非空数组，其元素数据类型为32位有符号整数，数组长度[1,1000]
 * </p>
 * <p>
 *     输出描述：输出排序后的数组
 * </p>
 * @author zhenwu
 * @date 2024/7/27 10:49
 */
public class H106_IntegerArrayOrderByLowestOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArray = in.nextLine().split(",");
        Arrays.sort(strArray, (s1, s2) -> {
            int a = s1.charAt(s1.length() - 1) - '0';
            int b = s2.charAt(s2.length() - 1) - '0';
            return a - b;
        });
        int len = strArray.length;
        for (int i = 0; i < len - 1; i++) {
            System.out.print(strArray[i] + ",");
        }
        System.out.println(strArray[len - 1]);
    }
}
