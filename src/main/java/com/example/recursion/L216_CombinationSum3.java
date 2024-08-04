package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L216:组合总和 III</p>
 * <p>找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：</p>
 * <p>只使用数字1到9</p>
 * <p>每个数字 最多使用一次 </p>
 * <p>返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回</p>
 */
public class L216_CombinationSum3 {
    public static void main(String[] args) {
        int k = 2, n = 6;
        System.out.println(combinationSum3(k, n));
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        process(n, k, 1, res, new ArrayList<>());
        return res;
    }

    private static void process(int n, int k, int startIndex, List<List<Integer>> res, List<Integer> path) {
        if (path.size() == k) {
            int sum = 0;
            for (Integer num : path) {
                sum += num;
            }
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        // 剪枝
        for (int i = startIndex; i <= (9 - k + path.size() + 1) ; i++) {
            path.add(i);
            process(n, k, i + 1, res, path);
            // 回溯
            path.remove(path.size() - 1);
        }
    }
}
