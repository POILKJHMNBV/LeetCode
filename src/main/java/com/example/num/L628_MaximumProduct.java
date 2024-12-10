package com.example.num;

import java.util.Arrays;

/**
 * <p>L628:三个数的最大乘积</p>
 * @author zhenwu
 * @date 2024/12/10 21:38
 */
public class L628_MaximumProduct {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(1)
     */
    private static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3],
                nums[0] * nums[1] * nums[len - 1]);
    }
}
