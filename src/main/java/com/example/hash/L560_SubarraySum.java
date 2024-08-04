package com.example.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L560:和为 K 的子数组</p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数。
 * 子数组是数组中元素的连续非空序列。
 */
public class L560_SubarraySum {
    public static void main(String[] args) {
        int[] nums = {5, -6, 1};
        int k = 5;
        System.out.println(subarraySum(nums, k));
    }

    /**
     * 前缀和+哈希表
     * 转化未求取前缀和之差为 K 的子数组个数
     */
    public static int subarraySum(int[] nums, int k) {
        // key-前缀和  value-前缀和出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        // 初始化map
        map.put(0, 1);

        int pre = 0, count = 0;
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
