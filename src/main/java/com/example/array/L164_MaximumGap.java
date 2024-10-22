package com.example.array;

import java.util.Arrays;

/**
 * <p>L164:最大间距</p>
 * @author zhenwu
 * @date 2024/10/22 21:24
 */
public class L164_MaximumGap {
    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(maximumGapPro(nums));
    }

    /**
     * 最大间距
     * 时间复杂度：O(n * logn)
     * 空间复杂度：O(1)
     */
    private static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(nums[i + 1] - nums[i], max);
        }
        return max;
    }

    /**
     * 最大间距
     * 优化：使用桶排序
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int maximumGapPro(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int len = nums.length;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        // 找到数组中的最小值和最大值
        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        // 如果最大值和最小值相等，说明数组中所有元素都相同，直接返回0
        if (minVal == maxVal) {
            return 0;
        }

        // 桶的数量，通常取数组长度和最大值与最小值差值的较小者，并向上取整。这里为了简化，直接取数组长度。
        int bucketSize = Math.max(1, (maxVal - minVal) / (len - 1)); // 至少为1
        int bucketCount = (maxVal - minVal) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][2]; // 每个桶记录最小值和最大值，初始化为无效值
        for (int i = 0; i < bucketCount; i++) {
            buckets[i][0] = Integer.MAX_VALUE; // 桶的最小值
            buckets[i][1] = Integer.MIN_VALUE; // 桶的最大值
        }

        // 将数组中的元素放入对应的桶中，并更新桶的最小值和最大值
        for (int num : nums) {
            int bucketIndex = (num - minVal) / bucketSize; // 计算元素应该放入哪个桶中
            buckets[bucketIndex][0] = Math.min(buckets[bucketIndex][0], num); // 更新桶的最小值
            buckets[bucketIndex][1] = Math.max(buckets[bucketIndex][1], num); // 更新桶的最大值
        }

        // 遍历桶，找到相邻非空桶之间的最大差值。注意要跳过空桶。
        int prevMax = minVal; // 上一个非空桶的最大值，初始化为数组的最小值
        int maxGap = 0; // 相邻元素之间的最大差值
        for (int i = 0; i < bucketCount; i++) {
            if (buckets[i][0] == Integer.MAX_VALUE || buckets[i][1] == Integer.MIN_VALUE) {
                // 当前桶为空，跳过
                continue;
            }
            maxGap = Math.max(maxGap, buckets[i][0] - prevMax); // 更新最大差值
            prevMax = buckets[i][1]; // 更新上一个非空桶的最大值
        }

        return maxGap;
    }
}
