package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L77:组合</p>
 * <p>给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合</p>
 */
public class L77_Combine {
    public static void main(String[] args) {
        int n = 4, k = 2;
        System.out.println(combine(n, k));
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        process(n, k, 1, res, new ArrayList<>());
        return res;
    }

    private static void process(int n, int k, int startIndex, List<List<Integer>> res, List<Integer> path) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= (n - k + path.size() + 1) ; i++) {
            path.add(i);
            process(n, k, i + 1, res, path);
            // 回溯
            path.remove(path.size() - 1);
        }
    }
}