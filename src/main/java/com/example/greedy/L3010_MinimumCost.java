package com.example.greedy;

/**
 * <p>L3010:将数组分成最小总代价的子数组 I</p>
 * @author zhenwu
 * @date 2025/9/17 21:20
 */
public class L3010_MinimumCost {
    public static void main(String[] args) {

    }

    /**
     * 贪心算法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int minimumCost(int[] nums) {
        int min = 100, secondMin = 100;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                secondMin = min;
                min = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }
        return min + secondMin + nums[0];
    }
}
