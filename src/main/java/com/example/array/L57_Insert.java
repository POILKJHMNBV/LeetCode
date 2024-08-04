package com.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * <p>L57:插入区间</p>
 * <p>给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。</p>
 */
public class L57_Insert {
    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {0, 3};
        int[][] res = insert(intervals, newInterval);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        Objects.requireNonNull(intervals);
        Objects.requireNonNull(newInterval);
        int len = intervals.length;
        if (len == 0) {
            return new int[][]{newInterval};
        }

        // 搜寻插入位置
        int left = 0, right = len;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (intervals[mid][0] < newInterval[0]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        ArrayList<int[]> ans = new ArrayList<>(Arrays.asList(intervals));
        if (right == len) {
            if (ans.get(len - 1)[1] >= newInterval[0]) {
                ans.get(len - 1)[1] = Math.max(ans.get(len - 1)[1], newInterval[1]);
            } else {
                ans.add(newInterval);
            }
        } else {
            if (right != 0) {
                if (ans.get(right - 1)[1] >= newInterval[0]) {
                    ans.get(right - 1)[1] = Math.max(ans.get(right - 1)[1], newInterval[1]);
                    right--;
                } else {
                    ans.add(right, newInterval);
                }
            } else {
                ans.add(right, newInterval);
            }
            while (ans.size() != 1 && right < ans.size() - 1 && ans.get(right)[1]  >= ans.get(right + 1)[0]) {
                ans.get(right)[1] = Math.max(ans.get(right)[1], ans.get(right + 1)[1]);
                ans.remove(right + 1);
            }
        }
        return ans.toArray(new int[0][0]);
    }
}
