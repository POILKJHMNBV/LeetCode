package com.example.slidewindow;

/**
 * <p>L2962:统计最大元素出现至少 K 次的子数组</p>
 * @author zhenwu
 * @date 2025/2/18 20:11
 */
public class L2962_CountSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 2, 2};
        int k = 2;
        System.out.println(countSubarrays(nums, k));
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static long countSubarrays(int[] nums, int k) {
        long ans = 0, maxNum = nums[0];
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        for (int l = 0, r = 0, cnt = 0, n = nums.length; r < n; r++) {
            if (nums[r] == maxNum) {
                cnt++;
            }
            while (cnt >= k) {
                if (nums[l++] == maxNum) {
                    cnt--;
                }
            }
            ans += l;
        }
        return ans;
    }
}
