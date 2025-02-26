package com.example.doublepointer;

import java.util.Collections;
import java.util.List;

/**
 * <p>L2824:统计和小于目标的下标对数目</p>
 * @author zhenwu
 * @date 2025/2/26 22:04
 */
public class L2824_CountPairs {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(1)
     */
    private static int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int l = 0, r = nums.size() - 1, ans = 0;
        while (l < r) {
            if (nums.get(l) + nums.get(r) < target) {
                ans += r - l;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}
