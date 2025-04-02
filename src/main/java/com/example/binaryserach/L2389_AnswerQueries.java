package com.example.binaryserach;

import java.util.Arrays;

/**
 * <p>L2389:和有限的最长子序列</p>
 * @author zhenwu
 * @date 2025/4/2 10:45
 */
public class L2389_AnswerQueries {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5};
        int[] queries = {1};
        System.out.println(Arrays.toString(answerQueries(nums, queries)));
    }

    /**
     * 时间：O((n + m) * log n)  空间：O(1)
     */
    private static int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 1, n = nums.length; i < n; i++) {
            // 原地求前缀和
            nums[i] += nums[i - 1];
        }
        for (int i = 0, m = queries.length; i < m; i++) {
            ans[i] = search(nums, queries[i]) + 1;
        }
        return ans;
    }

    private static int search(int[] nums, int target) {
        int l = -1, r = nums.length - 1;
        while (l < r) {
            int m = l + (r - l + 1) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return l;
    }
}
