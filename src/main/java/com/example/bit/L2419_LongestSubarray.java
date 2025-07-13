package com.example.bit;

/**
 * <p>L2419:按位与最大的最长子数组</p>
 * @author zhenwu
 * @date 2025/7/13 20:58
 */
public class L2419_LongestSubarray {
    public static void main(String[] args) {

    }

    /**
     * 由于与运算不会使得运算结果变大，因此只需求出数组中的最大值数量
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int longestSubarray(int[] nums) {
        int max = 0, ans = 0, cnt = 0;
        for (int num : nums) {
            if (max < num) {
                max = num;
                ans = 1;
                cnt = 1;
            } else if (max == num) {
                cnt++;
                ans = Math.max(ans, cnt);
            } else {
                cnt = 0;
            }
        }
        return ans;
    }
}
