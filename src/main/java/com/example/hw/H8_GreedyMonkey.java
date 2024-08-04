package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>贪吃的猴子</p>
 * <p>
 *     一只贪吃的猴子，来到一个果园，发现许多串香蕉排成一行，每串香蕉上有若干根香蕉。每串香蕉的根数由数组numbers给出。
 *     猴子获取香蕉，每次都只能从行的开头或者末尾获取，并且只能获取N次，求猴子最多能获取多少根香蕉。
 * </p>
 * <p>
 *     输入描述:
 *       第一行为数组numbers的长度
 *       第二行为数组numbers的值每个数字通过空格分开
 *       第三行输入为N，表示获取的次数
 * </p>
 * @author zhenwu
 * @date 2024/6/29 10:41
 */
public class H8_GreedyMonkey {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = in.nextInt();
        }
        int count = in.nextInt();
        if (count >= n) {
            System.out.println(Arrays.stream(numbers).sum());
            return;
        }

        int total = Arrays.stream(numbers, 0, count).sum();
        int maxBananas = total;

        // 左右指针尝试猴子左右拿取香蕉的每一种情况
        int l = count - 1, r = n - 1;
        while (l >= 0) {
            total += numbers[r--] - numbers[l--];
            maxBananas = Math.max(total, maxBananas);
        }
        System.out.println(maxBananas);
    }
}
