package com.example.doublepointer;

/**
 * <p>L2444:统计定界子数组的数目</p>
 * @author zhenwu
 * @date 2025/3/18 21:18
 */
public class L2444_CountSubarrays {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int l = -1, r = -1, i0 = -1;
        for (int i = 0, n = nums.length; i < n; i++) {
            if (nums[i] == maxK) {
                r = i;
            }
            if (nums[i] == minK) {
                l = i;
            }
            if (nums[i] < minK || nums[i] > maxK) {
                i0 = i;
            }
            ans += Math.max(0, Math.min(r, l) - i0);
        }
        return ans;
    }
}
