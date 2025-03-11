package com.example.doublepointer;

/**
 * <p>L1537:最大得分</p>
 * @author zhenwu
 * @date 2025/3/11 21:11
 */
public class L1537_MaxSum {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     */
    private static int maxSum(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, i = 0, j = 0;
        long sum1 = 0, sum2 = 0;
        while (i < m || j < n) {
            if (i < m && (j >= n || nums1[i] < nums2[j])) {
                sum1 += nums1[i++];
            } else if (i >= m || nums1[i] > nums2[j]) {
                sum2 += nums2[j++];
            } else {
                sum1 = sum2 = Math.max(sum1, sum2) + nums1[i++];
                j++;
            }
        }
        return (int) (Math.max(sum1, sum2) % 1000000007);
    }
}
