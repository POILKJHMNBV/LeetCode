package com.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>L56:合并区间</p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 */
public class L56_MergeSection {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        ArrayList<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            int L = interval[0], R = interval[1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < L) {
                // 列表中最后一个元素的右值小于当前元素的左，证明区间没有重叠
                ans.add(new int[]{L, R});
            } else {
                // 取列表中最后一个元素的右值和当前元素的右值的最大者
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], R);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
