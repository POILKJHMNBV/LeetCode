package com.example.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(twoSum1(nums, 4)));
        System.out.println(Arrays.toString(twoSum2(nums, 4)));
    }

    // 方法一：暴力枚举
    // 时间复杂度：O(N*N)     空间复杂度：O(1)
    public static int[] twoSum1(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};
            }
        }
        return new int[0];
    }

    // 哈希表法
    // 时间复杂度：O(N)     空间复杂度：O(N)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
