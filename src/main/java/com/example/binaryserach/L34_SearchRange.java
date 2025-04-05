package com.example.binaryserach;

import java.util.Arrays;

/**
 * L34:在排序数组中查找元素的第一个和最后一个位置
 * <p>
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * </p>
 */
public class L34_SearchRange {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = -1;
        System.out.println(Arrays.toString(searchRange(nums, target)));
        System.out.println(Arrays.toString(searchRangePro(nums, target)));
    }

    /**
     * 时间：O(log n)
     * 空间：O(1)
     */
    private static int[] searchRangePro(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstIdx = leftBound(nums, target);
        if (firstIdx == nums.length || nums[firstIdx] != target) {
            return new int[]{-1, -1};
        }
        int lastIdx = leftBound(nums, target + 1) - 1;
        return new int[]{firstIdx, lastIdx};
    }

    private static int leftBound(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }

    private static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = searchFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        int lastPosition = searchLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private static int searchFirstPosition(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private static int searchLastPosition(int[] nums, int target) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
