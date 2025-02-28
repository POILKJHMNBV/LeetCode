package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L1498:满足条件的子序列数目</p>
 * @author zhenwu
 * @date 2025/2/28 21:06
 */
public class L1498_NumSubseq {
    public static void main(String[] args) {
        int[] nums = {27, 21, 14, 2, 15, 1, 19, 8, 12, 24, 21,
                8, 12, 10, 11, 30, 15, 18, 28, 14, 26, 9, 2, 24, 23,
                11, 7, 12, 9, 17, 30, 9, 28, 2, 14, 22, 19, 19, 27, 6,
                15, 12, 29, 2, 30, 11, 20, 30, 21, 20, 2, 22, 6, 14, 13,
                19, 21, 10, 18, 30, 2, 20, 28, 22};
        int target = 31;
        System.out.println(numSubseq(nums, target));
    }

    /**
     * 二分查找，排序
     * 时间复杂度：O(n* log n)
     * 空间复杂度：O(n)
     */
    private static int numSubseq(int[] nums, int target) {
        int subsequences = 0;
        int length = nums.length;
        int[] power2 = new int[length];
        power2[0] = 1;
        for (int i = 1; i < length; i++) {
            power2[i] = power2[i - 1] * 2 % 1000000007;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length && nums[i] * 2 <= target; i++) {
            int j = searchEnd(nums, target - nums[i], i);
            int count = power2[j - i];
            subsequences = (subsequences + count) % 1000000007;
        }
        return subsequences;
    }

    private static int searchEnd(int[] nums, int target, int low) {
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (nums[mid] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
