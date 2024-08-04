package com.example.doublepointer;

/**
 * <p>删除有序数组中的重复项 II</p>
 * <p>给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。</p>
 * <p>不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。</p>
 */
public class L80_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3};
        System.out.println(removeDuplicates(nums));
    }

    private static int removeDuplicates(int[] nums) {
        return process(nums, 2);
    }

    private static int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) nums[u++] = x;
        }
        return u;
    }
}
