package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>游戏分组</p>
 * <p>
 *     部门准备举办一场王者荣耀表演赛，有 10 名游戏爱好者参与，分为两队，每队 5 人。
 *     每位参与者都有一个评分，代表着他的游戏水平。为了表演赛尽可能精彩，我们需要把 10 名参赛者分为实力尽量相近的两队。
 *     一队的实力可以表示为这一队 5 名队员的评分总和。
 *     现在给你 10 名参与者的游戏水平评分，请你根据上述要求分队，最后输出这两组的实力差绝对值。
 * </p>
 * <p>
 *     输入描述：10 个整数，表示 10 名参与者的游戏水平评分。范围在 [1,10000] 之间。
 * </p>
 * <p>
 *     输出描述：实力最相近两队的实力差绝对值。
 * </p>
 * @author zhenwu
 * @date 2024/7/15 20:47
 */
public class H52_GameGroup {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        totalSum = Arrays.stream(nums).sum();
        minDiff = totalSum;
        backtracking(0, nums, 0, 0);
        System.out.println(minDiff);
    }

    private static int totalSum = 0;

    private static int minDiff = 0;

    /**
     * 暴力递归求解
     * @param sum 已经选中的玩家实力之和
     * @param nums 玩家数组
     * @param startIndex 起始索引
     * @param count 已经选取的玩家数量
     */
    private static void backtracking(int sum, int[] nums, int startIndex, int count) {
        if (count == 5) {
            minDiff = Math.min(minDiff, Math.abs(totalSum - sum - sum));
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            backtracking(sum + nums[i], nums, i + 1, count + 1);
        }
    }
}
