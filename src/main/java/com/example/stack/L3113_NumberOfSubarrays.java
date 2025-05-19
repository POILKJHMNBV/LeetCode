package com.example.stack;

import java.util.ArrayDeque;

/**
 * <p>L3113:边界元素是最大值的子数组数目</p>
 * <p>
 *     给你一个 正 整数数组 nums
 *     请你求出 nums 中有多少个子数组，满足子数组中 第一个 和 最后一个 元素都是这个子数组中的最大值
 * </p>
 * @author zhenwu
 * @date 2025/5/19 21:59
 */
public class L3113_NumberOfSubarrays {

    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static long numberOfSubarrays(int[] nums) {
        long ans = nums.length;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{Integer.MAX_VALUE, 0});
        for (int num : nums) {
            while (num > stack.peek()[0]) {
                stack.pop();
            }
            if (num == stack.peek()[0]) {
                ans += stack.peek()[1]++;
            } else {
                stack.push(new int[]{num, 1});
            }
        }
        return ans;
    }
}
