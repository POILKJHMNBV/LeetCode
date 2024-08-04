package com.example.sort;

import java.util.Arrays;

/**
 * L912:排序数组
 * 给你一个整数数组 nums，请你将该数组升序排列。
 */
public class L912_SortArray {
    public static void main(String[] args) {
        int[] result = sortArray(new int[]{5, 1, 1, 2, 0, 0});
        System.out.println(Arrays.toString(result));
    }

    private static int[] sortArray(int[] nums) {
        int length = nums.length;
        int minIndex = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i;
            }
        }
        SortUtil.swap(nums, 0, minIndex);
        for (int i = 1; i < length; i++) {
            int temp = nums[i];
            int j = i;
            while (nums[j - 1] > nums[j]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
