package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L46:全排列</p>
 * <p>给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案</p>
 */
public class L46_Permute {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] used = new int[nums.length];
        process(res, new ArrayList<>(), nums, used);
        return res;
    }

    private static void process(List<List<Integer>> res, List<Integer> path, int[] nums, int[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            path.add(nums[i]);
            used[i] = 1;
            process(res, path, nums, used);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
