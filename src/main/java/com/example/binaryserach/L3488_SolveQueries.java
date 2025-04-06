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
     * 时间：O(n + q)，其中 n 是 nums 的长度，q 是 queries 的长度。
     * 空间：O(n)
     */
    private static List<Integer> solveQueriesPro(int[] nums, int[] queries) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int n = nums.length;
        // left 和 right 数组分别记录当前位置元素左右两边离它最近元素的索引
        int[] left = new int[n], right = new int[n];
        for (int i = -n; i < n; i++) {
            if (i >= 0) {
                left[i] = indexMap.get(nums[i]);
            }
            indexMap.put(nums[(i + n) % n], i);
        }

        indexMap.clear();
        for (int i = 2 * n - 1; i >= 0; i--) {
            if (i < n) {
                right[i] = indexMap.get(nums[i]);
            }
            indexMap.put(nums[i % n], i);
        }

        List<Integer> ans = new ArrayList<>(queries.length);
        for (int index : queries) {
            int l = left[index], r = right[index];
            ans.add(index - l == n ? -1 : Math.min(index - l, r - index));
        }
        return ans;
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
