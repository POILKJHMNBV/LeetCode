package com.example.doublepointer;

/**
 * <p>L1855:下标对中的最大距离</p>
 * @author zhenwu
 * @date 2025/3/7 20:02
 */
public class L1855_MaxDistance {
    public static void main(String[] args) {
        int[] nums1 = {55, 30, 5, 4, 2};
        int[] nums2 = {100, 20, 10, 10, 5};
        System.out.println(maxDistancePro(nums1, nums2));
    }

    /**
     * 双指针
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     */
    private static int  maxDistancePro(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, maxLen = 0;
        for (int j = 0, i = 0; j < n; j++) {
            while (i < m && nums2[j] < nums1[i]) {
                i++;
            }
            if (i >= m) {
                break;
            }
            maxLen = Math.max(maxLen, j - i);
        }
        return maxLen;
    }

    /**
     * 双指针 + 二分查找
     * 时间复杂度：O(m * log n)
     */
    private static int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, maxLen = 0;
        for (int i = 0, j = 0; i < m && j < n; i++, j++) {
            if (nums2[j] < nums1[i]) {
                continue;
            }
            if (i > j) {
                break;
            }
            maxLen = Math.max(maxLen, search(nums2, i, nums1[i]) - i);
        }
        return maxLen;
    }

    private static int search(int[] nums, int l, int target) {
        int r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (target > nums[m]) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return l;
    }
}
