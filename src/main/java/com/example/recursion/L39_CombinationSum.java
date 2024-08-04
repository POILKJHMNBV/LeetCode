package com.example.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>组合总和</p>
 * <p>给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的</p>
 * <p>1 <= candidates.length <= 30</p>
 * <p>2 <= candidates[i] <= 40</p>
 * <p>candidates 的所有元素 互不相同</p>
 * <p>1 <= target <= 40</p>
 */
public class L39_CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        if (candidates[0] > target) {
            return res;
        }
        process(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private static void process(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int startIndex) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            path.add(candidates[i]);
            process(res, path, candidates, target - candidates[i], i);
            path.remove(path.size() - 1);
        }
    }
}
