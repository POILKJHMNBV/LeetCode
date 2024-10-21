package com.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L149:直线上最多的点数</p>
 * @author zhenwu
 * @date 2024/10/21 21:14
 */
public class L149_MaxPoints {
    public static void main(String[] args) {
        System.out.println(5 % 15);
    }

    /**
     * 直线上最多的点数
     * 思路: 利用hashmap存储每个点与其他点的斜率，计算每个点与其他点的斜率是否相同
     * 时间复杂度：O(n^2 * log m), 其中 m 为坐标的最大差值
     * 空间复杂度：O(n)
     */
    private static int maxPointsPro(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int max = 2, len = points.length;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = i + 1; j < len; j++) {
                int a = points[i][0] - points[j][0];
                int b = points[i][1] - points[j][1];
                int k = gcd(a, b);
                String key = a / k + "_" + b / k;
                map.put(key, map.getOrDefault(key, 0) + 1);
                count = Math.max(map.get(key), count);
            }
            max = Math.max(count + 1, max);
            map.clear();
        }
        return max;
    }

    /**
     * 最大公约数
     */
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 直线上最多的点数
     * 思路：暴力枚举，计算每个点与其他点的斜率是否相同
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(1)
     * @param points 点
     * @return 直线上最多的点数
     */
    private static int maxPoints(int[][] points) {
        if (points.length < 3) {
            return points.length;
        }
        int max = 2, len = points.length;
        for (int i = 0; i < len; i++) {
            int[] x = points[i];
            for (int j = i + 1; j < len; j++) {
                int[] y = points[j];
                int count = 2;
                for (int k = j + 1; k < len; k++) {
                    int[] p = points[k];
                    int s1 = (y[1] - x[1]) * (p[0] - y[0]);
                    int s2 = (p[1] - y[1]) * (y[0] - x[0]);
                    if (s1 == s2) {
                        count++;
                    }
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}
