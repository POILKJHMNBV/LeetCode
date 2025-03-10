package com.example.doublepointer;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L986:区间列表的交集</p>
 * @author zhenwu
 * @date 2025/3/10 22:08
 */
public class L986_IntervalIntersection {
    public static void main(String[] args) {
        int[][] firstList = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] secondList = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] ans = intervalIntersection(firstList, secondList);
        for (int[] ints : ans) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }

    /**
     * 双指针
     * 时间复杂度：O(min(m, n))
     * 空间复杂度：O(1)
     */
    private static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || secondList == null) {
            return new int[0][];
        }
        int m = firstList.length, n = secondList.length;
        if (m == 0 || n == 0) {
            return new int[0][];
        }
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < m && j < n) {
            int[] p1 = firstList[i], p2 = secondList[j];
            if (!(p1[1] < p2[0] || p2[1] < p1[0])) {
                // 相交
                if (p2[1] == p1[0]) {
                    ans.add(new int[]{p1[0], p2[1]});
                } else if (p1[1] == p2[0]) {
                    ans.add(new int[]{p2[0], p1[1]});
                } else {
                    ans.add(new int[]{Math.max(p1[0], p2[0]), Math.min(p1[1], p2[1])});
                }
            }
            if (p1[1] > p2[1]) {
                j++;
            } else if (p1[1] < p2[1]) {
                i++;
            } else {
                i++;
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
