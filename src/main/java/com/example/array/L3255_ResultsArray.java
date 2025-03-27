package com.example.array;

import java.util.Arrays;

/**
 * <p>L3255:长度为 K 的子数组的能量值 II</p>
 * @author zhenwu
 * @date 2025/3/27 21:40
 */
public class L3255_ResultsArray {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Arrays.fill(ans, -1);
        for (int i = 0, cnt = 0; i < n; i++) {
            cnt = i == 0 || nums[i] == nums[i - 1] + 1 ? cnt + 1 : 1;
            if (cnt >= k) {
                ans[i - k + 1] = nums[i];
            }
        }
        return ans;
    }
}
