package com.example.binaryserach;

/**
 * L410:分割数组的最大值
 * <p>
 * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
 * 设计一个算法使得这 m 个子数组各自和的最大值最小。
 * </p>
 */
public class L410_SplitArray {
    public static void main(String[] args) {
        int[] nums = {1, 4, 4};
        int k = 3;
        System.out.println(splitArray(nums, k));
    }

    private static int splitArray(int[] nums, int k) {
        int low = 0;
        int high = 0;
        for (int num : nums) {
            low = Math.max(num, low);
            high += num;
        }
        while (low < high) {
            int mid = (low + high) >> 1;
            int splits = getSplits(nums, mid);
            if (splits > k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int getSplits(int[] nums, int maxIntervalSum) {
        int sum = 0;
        int splits = 1;
        for (int num : nums) {
            if (sum + num > maxIntervalSum) {
                sum = 0;
                splits++;
            }
            sum += num;
        }
        return splits;
    }
}
