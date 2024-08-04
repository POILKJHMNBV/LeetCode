package com.example.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>L47:全排列 II</p>
 * <p>给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。</p>
 */
public class L47_PermuteUnique {
    public static void main(String[] args) {
        int[] nums = {3, 3, 0, 3};
        System.out.println(permuteUnique(nums));
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int[] levelUsed = new int[nums.length];
        int[] depthUsed = new int[nums.length];
        process(res, new ArrayList<>(), nums, levelUsed, depthUsed);
        return res;
    }

    private static void process(List<List<Integer>> res, List<Integer> path, int[] nums, int[] levelUsed, int[] depthUsed) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && levelUsed[i - 1] == 0) {
                continue;
            }
            if (depthUsed[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            depthUsed[i] = 1;
            levelUsed[i] = 1;
            process(res, path, nums, levelUsed, depthUsed);
            depthUsed[i] = 0;
            levelUsed[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
