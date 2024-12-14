package com.example.greedy;

/**
 * <p>L330:按要求补齐数组</p>
 * <p>
 * 给定一个已排序的正整数数组 nums ，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。
 * 请返回 满足上述要求的最少需要补充的数字个数
 * </p>
 * @author zhenwu
 * @date 2024/12/14 10:34
 */
public class L330_MinPatches {
    public static void main(String[] args) {

    }

    /**
     * 贪心算法
     * 时间复杂度：O(m + logn), 其中 m 是数组 nums 的长度。
     * 空间复杂度：O(1)
     */
    private static int minPatches(int[] nums, int n) {
        // 当前可以表示的最大数，一开始只能组成[0, miss - 1]的所有数字
        long miss = 1;
        int patches = 0;
        int i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // 如果当前数字小于等于可以表示的最大数，则将其加入到集合中
                // 现在可以组成的数字范围变为[0, miss + nums[i] - 1]，即扩充了nums[i]
                miss += nums[i++];
            } else {
                // 如果当前数字大于可以表示的最大数，则需要补充一个最小的数（即当前的miss）
                // 现在可以组成的数字范围变为[0, 2 * miss - 1]
                miss <<= 1;
                patches++;
            }
        }
        return patches;
    }
}
