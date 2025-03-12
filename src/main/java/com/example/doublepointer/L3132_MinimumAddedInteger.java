package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L3132:找出与数组相加的整数 II</p>
 * @author zhenwu
 * @date 2025/3/12 20:47
 */
public class L3132_MinimumAddedInteger {
    public static void main(String[] args) {

    }

    /**
     * 排序 + 双指针
     * 时间复杂度: O(n log n), 其中 n 是数组 nums1 长度
     * 空间复杂度: O(1)
     */
    private static int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 2; i > 0; i--) {
            int x = nums2[0] - nums1[i];
            for (int j = i, k = 0, n = nums1.length; j < n; j++) {
                if (nums1[j] + x == nums2[k] && ++k == nums2.length) {
                    return x;
                }
            }
        }
        return nums2[0] - nums1[0];
    }
}
