package com.example.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>L90:子集 II</p>
 * <p>给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列</p>
 * @see L78_Subsets
 */
public class L90_SubsetsWithDup {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    private static List<List<Integer>> subsetsWithDupPro(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int len = nums.length;
        for (int mask = 0; mask < (1 << len); mask++) {
            tmp.clear();
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                if ((mask & (1 << j)) != 0) {
                    tmp.add(nums[j]);
                    if (j > 0 && nums[j-1]==nums[j] && ((mask >> (j - 1)) & 1) == 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                res.add(new ArrayList<>(tmp));
            }
        }
        return res;
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        res.add(Collections.emptyList());
        Arrays.sort(nums);
        int[] used = new int[nums.length];
        process(res, new ArrayList<>(), nums, used,0);
        return res;
    }

    private static void process(List<List<Integer>> res, List<Integer> set, int[] nums, int[] used, int startIndex) {
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && used[i - 1] == 0) {
                continue;
            }
            set.add(nums[i]);
            res.add(new ArrayList<>(set));
            used[i] = 1;
            process(res, set, nums, used, i + 1);
            set.remove(set.size() - 1);
            used[i] = 0;
        }
    }
}
