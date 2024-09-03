package com.example.doublepointer;

import java.util.Arrays;

/**
 * @author zhenwu
 * @date 2024/8/31 15:31
 */
public class L283_MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left++, right);
            }
            right++;
        }
    }

    private static void moveZeroesPro(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length && nums[j] != 0; j++) {
                swap(nums, j, j - 1);
            }
        }
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
