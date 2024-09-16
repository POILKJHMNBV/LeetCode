package com.example.binaryserach;

/**
 * <p>L162:寻找峰值</p>
 * @author zhenwu
 * @date 2024/9/16 16:08
 */
public class L162_FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 1};
        System.out.println(findPeakElementPro(nums));
    }

    /**
     * 时间：O(n)  空间：O(1)
     */
    private static int findPeakElement(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        for (int i = 0; i < len; i++) {
            if (i == 0 && nums[i] > nums[i + 1]) {
                return i;
            }
            if (i == len - 1 && nums[i] > nums[i - 1]) {
                return i;
            }
            if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 时间：O(log n)  空间：O(1)
     */
    private static int findPeakElementPro(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[m + 1]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
