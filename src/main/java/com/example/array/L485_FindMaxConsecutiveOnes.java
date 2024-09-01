package com.example.array;

/**
 * <p>L485:最大连续 1 的个数</p>
 * @author zhenwu
 * @date 2024/9/1 10:35
 */
public class L485_FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                l = i;
                break;
            }
        }
        int r = l;
        int maxCount = 0;
        while (r < nums.length) {
            while (r < nums.length && nums[r] == 1) {
                r++;
            }
            maxCount = Math.max(maxCount, r - l);
            while (r < nums.length && nums[r] == 0) {
                r++;
            }
            l = r;
        }
        return maxCount;
    }
}
