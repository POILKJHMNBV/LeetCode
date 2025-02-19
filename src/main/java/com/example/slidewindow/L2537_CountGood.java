package com.example.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L2537:统计好子数组的数目</p>
 * @author zhenwu
 * @date 2025/2/19 20:42
 */
public class L2537_CountGood {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int k = 10;
        System.out.println(countGood(nums, k));
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static long countGood(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        long ans = 0;
        for (int l = 0, r = 0, n = nums.length, pairs = 0; r < n; r++) {
            pairs += cnt.merge(nums[r], 1, Integer::sum) - 1;
            while (pairs >= k) {
                pairs -= cnt.merge(nums[l++], -1, Integer::sum);
            }
            ans += l;
        }
        return ans;
    }
}
