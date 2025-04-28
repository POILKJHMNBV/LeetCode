package com.example.binaryserach;

import java.util.Arrays;

/**
 * <p>L2576:求出最多标记下标</p>
 * @author zhenwu
 * @date 2025/4/28 22:39
 */
public class L2576_MaxNumOfMarkedIndices {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n log n)
     * 空间：O(1)
     */
    private static int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length / 2 + 1; // 开区间
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left * 2; // 最多匹配 left 对，有 left * 2 个数
    }

    private static boolean check(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            if (nums[i] * 2 > nums[nums.length - k + i]) {
                return false;
            }
        }
        return true;
    }
}
