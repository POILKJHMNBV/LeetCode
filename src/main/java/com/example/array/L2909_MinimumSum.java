package com.example.array;

/**
 * <p>L2909:元素和最小的山形三元组 II</p>
 * @author zhenwu
 * @date 2025/5/8 21:48
 */
public class L2909_MinimumSum {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int minimumSum(int[] nums) {
        int n = nums.length;
        int[] suffixMinArray = new int[n];

        // 后缀最小值数组
        suffixMinArray[n - 1] = nums[n - 1];
        for (int i = n - 2; i > 1; i--) {
            suffixMinArray[i] = Math.min(suffixMinArray[i + 1], nums[i]);
        }

        int ans = Integer.MAX_VALUE, preMin = nums[0];
        for (int j = 1; j < n - 1; j++) {
            if (nums[j] > preMin && nums[j] > suffixMinArray[j + 1]) {
                ans = Math.min(ans, preMin + nums[j] + suffixMinArray[j + 1]);
            }
            preMin = Math.min(preMin, nums[j]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
