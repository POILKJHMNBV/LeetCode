package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>跳格子3</p>
 * <p>
 *     小明和朋友们一起玩跳格子游戏
 *     每个格子上有特定的分数 score = [1, -1, -6, 7, -17, 7]，
 *     从起点score[0]开始，每次最大的步长为k，请你返回小明跳到终点 score[n-1] 时，能得到的最大得分。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入总的格子数量 n
 *          第二行输入每个格子的分数 score[i]
 *          第三行输入最大跳的步长 k
 * </p>
 * <p>
 *     输出描述：输出最大得分
 *     备注：
 *          格子的总长度 n 和步长 k 的区间在 [1, 100000]
 *          每个格子的分数 score[i] 在 [-10000, 10000] 区间中
 * </p>
 * @author zhenwu
 * @date 2024/7/21 9:08
 */
public class H74_JumpGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = in.nextInt();
        }
        int k = in.nextInt();

        // dp[i]表示跳到当前格子所能获得的最大分数
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = score[0];
        for (int i = 1; i < n; i++) {
            for (int step = 1; step <= k && (i - step) >= 0; step++) {
                dp[i] = Math.max(dp[i], dp[i - step] + score[i]);
            }
        }
        System.out.println(dp[n - 1]);
    }
}
