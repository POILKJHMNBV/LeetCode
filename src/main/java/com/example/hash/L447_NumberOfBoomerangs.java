package com.example.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L447:回旋镖的数量</p>
 * @author zhenwu
 * @date 2025/1/19 20:33
 */
public class L447_NumberOfBoomerangs {
    public static void main(String[] args) {
        int[][] points = {{0, 0}, {1, 0}, {2, 0}};
        System.out.println(numberOfBoomerangsPro(points));
    }

    /**
     * 优化解法
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     */
    private static int numberOfBoomerangsPro(int[][] points) {
        int res = 0;
        Map<Integer, Integer> distanceMap = new HashMap<>();
        for (int[] point1 : points) {
            distanceMap.clear();
            for (int[] point2 : points) {
                int d = (int) (Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
                int cnt = distanceMap.getOrDefault(d, 0);
                res += cnt * 2;
                distanceMap.put(d, cnt + 1);
            }
        }
        return res;
    }

    /**
     * 暴力求解(超时)
     * 时间复杂度O(n^3)
     * 空间复杂度O(1)
     */
    private static int numberOfBoomerangs(int[][] points) {
        int n = points.length;
        if (n < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }
                    int[] a = points[i], b = points[j], c = points[k];
                    int d1 = (int) (Math.pow(b[0] - a[0], 2) + Math.pow(b[1] - a[1], 2));
                    int d2 = (int) (Math.pow(c[0] - a[0], 2) + Math.pow(c[1] - a[1], 2));
                    if (d1 == d2) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
