package com.example.tree;

import java.util.TreeSet;

/**
 * L220：存在重复元素 III
 * <p>
 * 给你一个整数数组 nums 和两个整数 indexDiff 和 valueDiff 。
 * 找出满足下述条件的下标对 (i, j)：
 * i != j,
 * abs(i - j) <= indexDiff
 * abs(nums[i] - nums[j]) <= valueDiff
 * 如果存在，返回 true ；否则，返回 false 。
 * </p>
 */
public class L220_ContainsNearbyAlmostDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int indexDiff = 3;
        int valueDiff = 0;
        System.out.println(containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff));
    }

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> treeSet = new TreeSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            long num = nums[i];
            Long left = treeSet.floor(num);
            Long right = treeSet.ceiling(num);
            if (left != null && (num - left) <= valueDiff) {
                return true;
            }
            if (right != null && (right - num) <= valueDiff) {
                return true;
            }
            treeSet.add(num);
            if (i >= indexDiff) {
                treeSet.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}
