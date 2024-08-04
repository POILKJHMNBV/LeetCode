package com.example.greedy;

/**
 * @author zhenwu
 * 2024/6/21 22:03
 * <p>L55:跳跃游戏</p>
 * <p>给你一个非负整数数组 nums，你最初位于数组的第一个下标。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。</p>
 */
public class L55_CanJump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        int len = nums.length;
        int maxPositions = 0;
        for (int i = 0; i < len; i++) {
            if (i > maxPositions) {
                return false;
            }
            maxPositions = Math.max(maxPositions, i + nums[i]);
        }
        return true;
    }
}
