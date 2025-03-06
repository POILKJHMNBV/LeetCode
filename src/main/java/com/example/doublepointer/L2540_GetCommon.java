package com.example.doublepointer;

/**
 * <p>L2540:最小公共值</p>
 * @author zhenwu
 * @date 2025/3/6 21:17
 */
public class L2540_GetCommon {
    public static void main(String[] args) {

    }

    /**
     * 双指针法
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     */
    private static int getCommon(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        for (int i = 0, j = 0; i < m && j < n;) {
            int a = nums1[i], b = nums2[j];
            if (a == b) {
                return a;
            } else if (a < b) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }
}
