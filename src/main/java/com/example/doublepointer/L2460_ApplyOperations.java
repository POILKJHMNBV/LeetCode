package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L2460:对数组执行操作</p>
 * @author zhenwu
 * @date 2025/3/5 21:21
 */
public class L2460_ApplyOperations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 1, 0};
        System.out.println(Arrays.toString(applyOperations(nums)));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int[] applyOperations(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                continue;
            }
            nums[i] *= 2;
            nums[i + 1] = 0;
        }
        for (int l = 0, r = 0; r < n; r++) {
            if (nums[r] != 0) {
                swap(nums, l++, r);
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
