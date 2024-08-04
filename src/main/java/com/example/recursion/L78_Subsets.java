package com.example.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>L78:子集</p>
 * <p>给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。</p>
 */
public class L78_Subsets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        res.add(Collections.emptyList());
        process(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void process(List<List<Integer>> res, List<Integer> set, int[] nums, int startIndex) {
        for (int i = startIndex; i < nums.length; i++) {
            set.add(nums[i]);
            res.add(new ArrayList<>(set));
            process(res, set, nums, i + 1);
            set.remove(set.size() - 1);
        }
    }
}
