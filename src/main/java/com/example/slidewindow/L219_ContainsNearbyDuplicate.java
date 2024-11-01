package com.example.slidewindow;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L217:存在重复元素 II</p>
 * @author zhenwu
 * @date 2024/11/1 21:45
 */
public class L219_ContainsNearbyDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(min(k, n))
     */
    private static boolean containsNearbyDuplicate(int[] nums, int k) {
        int l = 0, r = Math.min(k, nums.length - 1);
        Set<Integer> set = new HashSet<>();
        for (int i = l; i <= r; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        r++;
        set.remove(nums[l++]);
        while (r < nums.length) {
            if (!set.add(nums[r++])) {
                return true;
            }
            set.remove(nums[l++]);
        }
        return false;
    }
}
