package com.example.slidewindow;

/**
 * <p>L1712:将数组分成三个子数组的方案数</p>
 * @author zhenwu
 * @date 2025/2/24 22:21
 */
public class L1712_WaysToSplit {
    public static void main(String[] args) {
        int[] nums = {0, 3, 3};
        System.out.println(waysToSplit(nums));
        System.out.println(waysToSplitPro(nums));
    }

    /**
     * 滑动窗口优化
     * 时间复杂度: O(n * n)
     * 空间复杂度: O(n)
     */
    private static int waysToSplitPro(int[] nums) { 
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        long res = 0;
        for (int l1 = 1, l2 = 1, r = 2; r < n; r++) {
            while (l1 < r && prefixSum[r] - prefixSum[l1] >= prefixSum[l1]) {
                l1++;
            }
            while (l2 < l1 && prefixSum[n] - prefixSum[r] < prefixSum[r] - prefixSum[l2]) {
                l2++;
            }
            res += l1 - l2;
        }
        return (int) (res % (Math.pow(10, 9) + 7));
    }

    /**
     * 暴力求解(超时)
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(1)
     */
    private static int waysToSplit(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int ls = 0, n = nums.length, avg = sum / 3;
        long res = 0;
        for (int i = 0; i < n; ++i) {
            ls += nums[i];
            if (ls > avg) break;
            for (int r = i + 1, ms = 0; r < n; r++) {
                ms += nums[r];
                if (ms >= ls && ms <= sum - ls - ms) {
                    res++;
                }
            }
        }
        return (int) (res % (Math.pow(10, 9) + 7));
    }
}
