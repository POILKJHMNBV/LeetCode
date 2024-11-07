package com.example.sort;

import java.util.Arrays;

/**
 * L88:合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n
 */
public class L88_MergeSortedSort {
    public static void main(String[] args) {
        int[] num1 = {1, 2, 3, 0, 0, 0};
        merge(num1, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(num1));
    }

    /**
     * 逆序双指针
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     */
    private static void mergePro(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[k--] = nums2[j--];
            } else if (j < 0) {
                nums1[k--] = nums1[i--];
            } else if (nums2[j] >= nums1[i]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
    }

    /**
     * 合并两个有序数组
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(m + n)
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m];
        System.arraycopy(nums1, 0, temp, 0, m);
        int i = 0;
        int j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i == m) {
                nums1[k] = nums2[j];
                j++;
            } else if (j == n) {
                nums1[k] = temp[i];
                i++;
            } else if (temp[i] <= nums2[j]) {
                nums1[k] = temp[i];
                i++;
            } else {
                nums1[k] = nums2[j];
                j++;
            }
        }
    }
}
