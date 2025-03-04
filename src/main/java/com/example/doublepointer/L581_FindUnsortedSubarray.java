package com.example.doublepointer;

/**
 * <p>L581:最短无序连续子数组</p>
 * @author zhenwu
 * @date 2025/3/4 21:20
 */
public class L581_FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 2, 4};
        System.out.println(findUnsortedSubarray(nums));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int findUnsortedSubarray(int[] nums) {
        int n = nums.length, i = 0, j = n - 1;
        while (i < n - 1 && nums[i] <= nums[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            return 0;
        }
        while (j > 0 && nums[j - 1] <= nums[j]) {
            j--;
        }
        int minimum = nums[i + 1], maximum = minimum;
        for (int k = i; k <= j; k++) {
            minimum = Math.min(minimum, nums[k]);
            maximum = Math.max(maximum, nums[k]);
        }
        while (i >= 0 && nums[i] > minimum) {
            i--;
        }
        while (j < n && nums[j] < maximum) {
            j++;
        }
        return j - i - 1;
    }
}
