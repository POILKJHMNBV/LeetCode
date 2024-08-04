package com.example.greedy;

/**
 * @author zhenwu
 * 2024/6/21 22:12
 * <p>L45:跳跃游戏 II</p>
 * <p>给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:</p>
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * </p>
 * <p>返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。</p>
 */
public class L45_JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    private static int jump(int[] nums) {
        int len = nums.length;
        int maxPositions = 0;
        int end = 0;
        int steps = 0;
        for (int i = 0; i < len - 1; i++) {
            maxPositions = Math.max(maxPositions, i + nums[i]);
            if (i == end) {
                end = maxPositions;
                steps++;
            }
        }
        return steps;
    }
}
