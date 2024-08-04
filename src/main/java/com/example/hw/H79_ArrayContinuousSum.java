package com.example.hw;

import java.util.Scanner;

/**
 * <p>数组连续和</p>
 * <p>
 *     给定一个含有N个正整数的数组，求出有多少连续区间（包括单个正整数），它们的和大于等于 x。
 * </p>
 * <p>
 *     输入描述：
 *          第一行为两个整数 N,x。(0<N≤100000, 0≤x≤10000000)
 *          第二行有 N 个正整数 （每个正整数小于等于 100）
 * </p>
 * <p>
 *     输出描述：
 *          输出一个整数，表示所求的个数
 *     注意：注意：此题对效率有要求，暴力解法通过率不高，请考虑高效的实现方式。
 * </p>
 * @author zhenwu
 * @date 2024/7/21 11:24
 */
public class H79_ArrayContinuousSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), x = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        // 前缀和数组
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int count = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (prefixSum[j] - prefixSum[i] >= x) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
