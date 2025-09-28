package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L2099:找到和最大的长度为 K 的子序列</p>
 * @author zhenwu
 * @date 2025/9/28 21:28
 */
public class L2099_MaxSubsequence {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] idx = new int[n][2];
        for (int i = 0; i < n; i++) {
            idx[i][0] = nums[i];
            idx[i][1] = i;
        }
        // 降序排序
        Arrays.sort(idx, (a, b) -> b[0] - a[0]);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            // 取前 k 个最大值的索引
            ans[i] = idx[i][1];
        }
        // 对索引进行排序
        Arrays.sort(ans);
        for (int i = 0; i < k; i++) {
            ans[i] = nums[ans[i]];
        }
        return ans;
    }
}
