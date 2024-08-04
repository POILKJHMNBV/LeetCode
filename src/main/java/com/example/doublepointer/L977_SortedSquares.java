package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L977:有序数组的平方</p>
 * <p>给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序</p>
 */
public class L977_SortedSquares {
    public static void main(String[] args) {

    }

    /**
     * 暴力法
     */
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }

    /**
     * 双指针法
     */
    public int[] sortedSquaresPro(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int left = 0, right = len - 1, k = len - 1;
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                res[k--] = nums[right] * nums[right];
                right--;
            } else {
                res[k--] = nums[left] * nums[left];
                left++;
            }
        }
        return res;
    }
}