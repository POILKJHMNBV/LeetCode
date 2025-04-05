package com.example.binaryserach;

import java.util.*;

/**
 * <p>L3488:距离最小相等元素查询</p>
 * @author zhenwu
 * @date 2025/4/5 21:47
 */
public class L3488_SolveQueries {
    public static void main(String[] args) {
        int[] nums = {2, 10, 20, 20, 20}, queries = {1, 4, 2};
        System.out.println(solveQueries(nums, queries));
    }

    /**
     * 时间：O(n + q log n)，其中 n 是 nums 的长度，q 是 queries 的长度。每次二分需要 O(log n) 的时间。
     * 空间：O(n)
     */
    private static List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int n = nums.length;
        for (List<Integer> p : indices.values()) {
            // 前后各加一个哨兵
            int i0 = p.get(0);
            p.add(0, p.get(p.size() - 1) - n);
            p.add(i0 + n);
        }

        List<Integer> ans = new ArrayList<>(queries.length); // 预分配空间
        for (int i : queries) {
            List<Integer> p = indices.get(nums[i]);
            if (p.size() == 3) {
                ans.add(-1);
            } else {
                int j = Collections.binarySearch(p, i);
                ans.add(Math.min(i - p.get(j - 1), p.get(j + 1) - i));
            }
        }
        return ans;
    }
}
