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
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] res = insert(intervals, newInterval);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    /**
     * 插入区间
     * 时间复杂度：O(n + log n)
     * 空间复杂度：O(n)
     */
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
        ArrayList<int[]> ans = new ArrayList<>();
        if (right > 0 && intervals[right - 1][1] >= newInterval[0]) {
            // 合并区间
            intervals[right - 1][1] = Math.max(intervals[right - 1][1], newInterval[1]);
        } else if (right == 0) {
            ans.add(newInterval);
        }

        // 将right之前的区间加入ans
        for (int i = 0; i < right; i++) {
            ans.add(intervals[i]);
        }

        // 前面未合并，将 newInterval 加入ans
        if (right > 0 && intervals[right - 1][1] < newInterval[0]) {
            ans.add(newInterval);
        }

        // 不断合并区间
        int[] lastInterval = ans.get(ans.size() - 1);
        while (left < len && intervals[left][0] <= newInterval[1]) {
            lastInterval[1] = Math.max(lastInterval[1], intervals[left][1]);
            left++;
        }

        // 将left之后的区间加入ans
        for (int i = left; i < len; i++) {
            ans.add(intervals[i]);
        }
        return ans.toArray(new int[0][0]);
    }
}
