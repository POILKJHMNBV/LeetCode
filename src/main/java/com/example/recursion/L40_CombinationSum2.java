package com.example.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>组合总和 II</p>
 * <p>给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。</p>
 */
public class L40_CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return res;
        }
        process(res, new ArrayList<>(), candidates, target, 0, new int[candidates.length]);
        return res;
    }

    private static void process(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int startIndex, int[] used) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }
            if (candidates[i] > target) {
                return;
            }
            path.add(candidates[i]);
            used[i] = 1;
            process(res, path, candidates, target - candidates[i], i + 1, used);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}
