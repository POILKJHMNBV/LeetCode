package com.example.slidewindow;

/**
 * <p>L1493:删掉一个元素以后全为 1 的最长子数组</p>
 * @author zhenwu
 * @date 2024/9/2 20:13
 */
public class L1493_LongestSubarray {
    public static void main(String[] args) {

    }

    private static int longestSubarray(int[] nums) {
        int l = 0, r = 0, zeroCount = 0;
        int maxLen = 0;
        // 维持滑动窗口内只有一个0
        while (r < nums.length) {
            if (nums[r] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[l++] == 0) {
                    zeroCount--;
                }
            }
            maxLen = Math.max(maxLen, r - l);
            r++;
        }
        return maxLen;
    }
}
