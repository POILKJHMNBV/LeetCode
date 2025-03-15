package com.example.doublepointer;

import com.example.util.SearchUtils;

/**
 * <p>L2367:等差三元组的数目</p>
 * @author zhenwu
 * @date 2025/3/15 9:18
 */
public class L2367_ArithmeticTriplets {
    public static void main(String[] args) {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        System.out.println(SearchUtils.floorIndex(nums, 5));
        System.out.println(SearchUtils.ceilIndex(nums, 5));
        System.out.println(arithmeticTriplets(nums, diff));
    }

    /**
     * 三指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length, ans = 0, i = 0, j = 1;
        for (int num : nums) {
            while (j < n && num - nums[j] > diff) {
                j++;
            }
            if (num - nums[j] < diff) {
                continue;
            }
            while (i < n && num - nums[i] > 2 * diff) {
                i++;
            }
            if (num - nums[i] == 2 * diff) {
                ans++;
            }
        }
        return ans;
    }
}
