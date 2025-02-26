package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L611:有效三角形的个数</p>
 * @author zhenwu
 * @date 2025/2/26 22:11
 */
public class L611_TriangleNumber {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(1)
     */
    private static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int k = 2; k < nums.length; k++) {
            int c = nums[k], l = 0, r = k - 1;
            while (l < r) {
                if (nums[l] + nums[r] > c) {
                    ans += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }
}
