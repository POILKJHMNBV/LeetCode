package com.example.array;

/**
 * <p>L3105:最长的严格递增或递减子数组</p>
 * @author zhenwu
 * @date 2025/3/29 9:57
 */
public class L3105_LongestMonotonicSubarray {

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 3, 2};
        System.out.println(longestMonotonicSubarray(nums));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length, maxLen = 1;
        for (int i = 0; i < n; ) {
            int j = i + 1;
            if (j >= n) {
                break;
            }
            if (nums[j] > nums[i]) {
                while (j < n && nums[j] > nums[j - 1]) {
                    j++;
                }
            } else if (nums[j] < nums[i]) {
                while (j < n && nums[j] < nums[j - 1]) {
                    j++;
                }
            } else {
                i = j;
                continue;
            }
            maxLen = Math.max(maxLen, j - i);
            i = j - 1;
        }
        return maxLen;
    }
}
