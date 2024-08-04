package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L26:删除有序数组中的重复项</p>
 * <p>给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数</p>
 * <p>考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：</p>
 * <p>1.更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。</p>
 * <p>2.返回 k </p>
 */
public class L26_RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    private static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if (nums.length == 1) {
            return 1;
        }
        int newLength = nums.length;
        for (int i = 1; i < newLength; i++) {
            if (nums[i] == nums[i - 1]) {
                int left = i - 1, right = left + 1;
                while (right < newLength && nums[right] == nums[left]) {
                    right++;
                }
                int step = right - left - 1;
                System.arraycopy(nums, right, nums, left + 1, nums.length - right);
                newLength -= step;
            }
        }
        return newLength;
    }
}
