package com.example.dp;

/**
 * <p>L213: 打家劫舍 II</p>
 * <p>你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。</p>
 * <p>给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。</p>
 */
public class L213_Rob {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        System.out.println(robPro(nums));
    }

    private static int robPro(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 直接分成两种情况求最大值，第一间偷或不偷
        return Math.max(process(nums, 0, len - 2),
                process(nums, 1, len - 1));
    }

    private static int process(int[] nums, int begin, int end) {
        int a = nums[begin];
        int b = Math.max(nums[begin], nums[begin + 1]);
        for (int i = begin + 2; i <= end; i++) {
            int tmp = Math.max(b, a + nums[i]);
            a = b;
            b = tmp;
        }
        return b;
    }
}