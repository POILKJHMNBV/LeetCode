package com.example.array;

/**
 * <p>L2765:最长交替子数组</p>
 * @author zhenwu
 * @date 2025/3/26 21:40
 */
public class L2765_AlternatingSubarray {

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 3, 4};
        System.out.println(alternatingSubarray(nums));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int alternatingSubarray(int[] nums) {
        int maxLen = -1;
        for (int i = 0, n = nums.length; i < n; i++) {
            int j = i + 1;
            while (j < n) {
                int k = (j - i) % 2;
                if ((k == 1 && nums[j] == nums[i] + 1) || (k == 0 && nums[i] == nums[j])) {
                    j++;
                } else {
                    break;
                }
            }
            if (j - i > 1) {
                maxLen = Math.max(maxLen, j - i);
            }
            i = j - i > 1 ? j - 2 : j - 1;
        }
        return maxLen;
    }
}
