package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L905:按奇偶排序数组</p>
 * @author zhenwu
 * @date 2025/3/5 21:15
 */
public class L905_SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int[] sortArrayByParity(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int num = nums[i];
            if (num % 2 == 1) {
                while (nums[j] % 2 == 1 && i < j) {
                    j--;
                }
                swap(nums, i++, j--);
            } else {
                i++;
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
