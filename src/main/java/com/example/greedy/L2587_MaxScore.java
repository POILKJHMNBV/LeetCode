package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L2587:重排数组以得到最大前缀分数</p>
 * @author zhenwu
 * @date 2025/9/23 21:31
 */
public class L2587_MaxScore {
    public static void main(String[] args) {

    }

    /**
     * 思路：对数组进行排序，然后从后往前遍历，计算当前位置的分数
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(log n)
     */
    private static int maxScore(int[] nums) {
        Arrays.sort(nums);
        if (nums[nums.length - 1] <= 0) {
            return 0;
        }
        int score = 0;
        long sum = 0;
        for (int i = nums.length - 1; i >= 0 && sum >= 0; i--) {
            sum += nums[i];
            if (sum > 0) {
                score++;
            }
        }
        return score;
    }
}
