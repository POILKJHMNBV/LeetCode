package com.example.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L992:K 个不同整数的子数组</p>
 * @author zhenwu
 * @date 2025/1/13 21:29
 */
public class L992_SubarraysWithKDistinct {
    public static void main(String[] args) {
        int[] nums = {2, 1, 2, 1, 2};
        int k = 2;
        System.out.println(subarraysWithKDistinctPro(nums, k));
    }

    /**
     * 滑动窗口 + 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int subarraysWithKDistinctPro(int[] nums, int k) {
        int n = nums.length;
        // lower[i] 表示以 i 结尾，其左边「最远」满足出现 k 个不同字符的下标
        // upper[i] 表示以 i 结尾，其左边「最远」满足出现 k - 1 个不同字符的下标
        int[] lower = new int[n], upper = new int[n];
        find(lower, nums, k);
        find(upper, nums, k - 1);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (lower[i] != -1 && upper[i] != -1) {
                count += upper[i] - lower[i];
            }
        }
        return count;
    }

    private static void find(int[] arr, int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int diff = 0;
        for (int i = 0, j = 0; i < n; i++) {
            if (++cnt[nums[i]] == 1) {
                diff++;
            }
            while (diff > k) {
                if (--cnt[nums[j++]] == 0) {
                    diff--;
                }
            }
            arr[i] = j;
        }
    }

    /**
     * 暴力求解
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(n)
     * 超时
     */
    private static int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int m = k; m <= n; m++) {
            for (int i = 0; i <= n - m; i++) {
                set.clear();
                for (int j = i; j < i + m; j++) {
                    set.add(nums[j]);
                }
                if (set.size() == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
