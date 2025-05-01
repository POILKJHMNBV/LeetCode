package com.example.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L624:数组列表中的最大距离</p>
 * @author zhenwu
 * @date 2025/5/1 14:45
 */
public class L624_MaxDistance {
    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(List.of(1, 5));
        arrays.add(List.of(3, 4));
        System.out.println(maxDistancePro(arrays));
    }

    /**
     * 暴力循环：超时
     * 时间复杂度：O(n * n)
     * 空间复杂度：O(1)
     */
    private static int maxDistance(List<List<Integer>> arrays) {
        int ans = 0, size = arrays.size();
        for (int i = 0; i < size; i++) {
            List<Integer> list1 = arrays.get(i);
            int min = list1.get(0), max= list1.get(list1.size() - 1);
            for (int j = i + 1; j < size; j++) {
                List<Integer> list2 = arrays.get(j);
                int a = Math.abs(min - list2.get(list2.size() - 1));
                int b = Math.abs(max - list2.get(0));
                ans = Math.max(ans, Math.max(a, b));
            }
        }
        return ans;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int maxDistancePro(List<List<Integer>> arrays) {
        int ans = 0, size = arrays.size();
        List<Integer> firstList = arrays.get(0);
        int min = firstList.get(0), max = firstList.get(firstList.size() - 1);
        for (int i = 1; i < size; i++) {
            List<Integer> list = arrays.get(i);
            int m = list.get(0), n = list.get(list.size() - 1);
            ans = Math.max(ans, Math.max(Math.abs(min - n), Math.abs(max - m)));
            min = Math.min(min, m);
            max = Math.max(max, n);
        }
        return ans;
    }
}
