package com.example.array;

/**
 * <p>L3011:判断一个数组是否可以变为有序</p>
 * @author zhenwu
 * @date 2025/3/25 21:36
 */
public class L3011_CanSortArray {
    public static void main(String[] args) {

    }

    /**
     * 对于每一组，如果这一组的每个数，都大于等于上一组的最大值 preMax，那么我们就能把数组排成递增的，否则不行。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean canSortArray(int[] nums) {
        int preMax = 0;
        for (int i = 0, n = nums.length; i < n;) {
            int cnt = Integer.bitCount(nums[i]);
            int max = nums[i];
            while (i < n && cnt == Integer.bitCount(nums[i])) {
                if (nums[i] < preMax) {
                    return false;
                }
                max = Math.max(nums[i++], max);
            }
            preMax = max;
        }
        return true;
    }
}
