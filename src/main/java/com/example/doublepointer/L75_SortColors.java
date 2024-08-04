package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L75:颜色分类</p>
 * <p>
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * </p>
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * </p>
 */
public class L75_SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColors(int[] nums) {
        int i = -1, j = nums.length;
        int cursor = 0;
        while (cursor < j) {
            if (nums[cursor] < 1) {
                swap(nums, ++i, cursor);
                cursor++;
            } else if (nums[cursor] == 1) {
                cursor++;
            } else {
                swap(nums, --j, cursor);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}