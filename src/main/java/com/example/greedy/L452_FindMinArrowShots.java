package com.example.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>L452:用最少数量的箭引爆气球</p>
 * @author zhenwu
 * @date 2024/9/20 22:06
 */
public class L452_FindMinArrowShots {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n * lon n)      空间：O(1)
     */
    private static int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        Arrays.sort(points, Comparator.comparing(point -> point[0]));
        int count = 1, len = points.length;
        for (int i = 1; i < len; i++) {
            if (points[i][0] > points[i - 1][1]) {
                // 当前气球左边界严格大于前一个气球的右边界，弓箭数+1
                count++;
            } else {
                // 更新右边界
                points[i][1] = Math.min(points[i - 1][1], points[i][1]);
            }
        }
        return count;
    }
}
