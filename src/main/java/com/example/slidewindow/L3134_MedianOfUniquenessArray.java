package com.example.slidewindow;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L3134:找出唯一性数组的中位数</p>
 * @author zhenwu
 * @date 2025/2/21 21:29
 */
public class L3134_MedianOfUniquenessArray {
    public static void main(String[] args) {

    }

    /**
     * 二分 + 滑动窗口 + 哈希表
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        long k = ((long) n * (n + 1) / 2 + 1) / 2;
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid, k)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean check(int[] nums, int upper, long k) {
        int n = nums.length;
        long res = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int l = 0, r = 0; r < n; r++) {
            cntMap.merge(nums[r], 1, Integer::sum);
            while (cntMap.size() > upper) {
                // 不重复元素个数超过upper，缩小窗口
                int out = nums[l++];
                cntMap.merge(out, -1, Integer::sum);
                if (cntMap.get(out) == 0) {
                    cntMap.remove(out);
                }
            }
            res += r - l + 1;
            if (res >= k) {
                // 不重复元素个数不超过upper的子数组个数超过k
                return true;
            }
        }
        return false;
    }
}
