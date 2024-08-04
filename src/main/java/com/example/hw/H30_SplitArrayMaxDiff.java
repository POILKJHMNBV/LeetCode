package com.example.hw;

import java.util.Scanner;

/**
 * <p>分割数组的最大差值</p>
 * <p>
 *     给定一个由若干整数组成的数组nums，可以在数组内的任意位置进行分割，将该数组分割成两个非空子数组(即左数组和右数组)，
 *     分别对子数组求和得到两个值.计算这两个值的差值，请输出所有分割方案中，差值最大的值。
 * </p>
 * <p>
 *     输入描述：
 *      1.第一行输入数组Q中元素个数n，1< n < 100000
 *      2.第二行输入数字序列，以空格进行分隔，数字取值为4字节整数
 * </p>
 * <p>
 *     输出描述：输出差值的最大取值
 * </p>
 * @author zhenwu
 * @date 2024/7/9 21:51
 */
public class H30_SplitArrayMaxDiff {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            sum += nums[i];
        }

        long maxDiff = 0, leftSum = 0;
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            maxDiff = Math.max(maxDiff, Math.abs(sum - leftSum - leftSum));
        }
        System.out.println(maxDiff);
    }
}
