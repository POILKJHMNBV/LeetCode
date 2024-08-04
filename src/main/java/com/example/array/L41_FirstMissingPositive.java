package com.example.array;


import java.util.HashSet;

/**
 * <p>L41:缺失的第一个正数</p>
 * <p>给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。</p>
 */
public class L41_FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {7};
        System.out.println(firstMissingPositive(nums));
    }

    private static int firstMissingPositivePlus(int[] nums) { 
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        throw new IllegalArgumentException();
    }

    private static int firstMissingPositivePro(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) {
                nums[i] = length + 1;
            }
        }
        for (int i = 0; i < length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs < length + 1) {
                if (nums[abs - 1] > 0) {
                    nums[abs - 1] = -nums[abs - 1];
                }
            }
        }
        for (int i = 0; i < length; i++) {
            // 获取第一个正数的下标
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
