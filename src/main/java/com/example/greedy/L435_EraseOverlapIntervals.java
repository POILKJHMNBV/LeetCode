package com.example.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>L435:无重叠区间</p>
 * @author zhenwu
 * @date 2024/9/19 21:30
 */
public class L435_EraseOverlapIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }

    /**
     * 时间：O(n * lon n)      空间：O(1)
     */
    private static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int end = intervals[0][1], count = 0, len = intervals.length;
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] < end) {
                //  有重叠，移除尾部比较大的区间，防止和后面的区间重和
                count++;
                end = Math.min(end, intervals[i][1]);
            } else {
                // 区间未重合，更新右端点值
                end = Math.max(end, intervals[i][1]);
            }
        }
        return count;
    }
}
