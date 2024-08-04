package com.example.binaryserach;

/**
 * L4:寻找两个正序数组的中位数
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n))
 * </p>
 */
public class L4_FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) +
                getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) * 1.0 / 2;
    }

    private static int getKth(int[] nums1, int start1, int end1,
                              int[] nums2, int start2, int end2,
                              int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return getKth(nums2, start2, end2, nums1, start1, end1, k);
        }

        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }

        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - Math.min(len2, k / 2));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - Math.min(len1, k / 2));
        }
    }
}
