package com.example.array;

/**
 * <p>L674:最长连续递增序列</p>
 * @author zhenwu
 * @date 2025/3/21 20:29
 */
public class L674_FindLengthOfLCIS {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int findLengthOfLCIS(int[] nums) {
        int maxLen = 1;
        for (int i = 0, n = nums.length; i < n; i++) {
            int j = i + 1;
            while (j < n && nums[j] > nums[j - 1]) {
                j++;
            }
            maxLen = Math.max(maxLen, j - i);
            i = j - 1;
        }
        return maxLen;
    }
}
