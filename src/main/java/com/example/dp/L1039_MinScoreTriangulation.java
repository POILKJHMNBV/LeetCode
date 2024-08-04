package com.example.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L1039:多边形三角剖分的最低得分</p>
 * <p>你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，其中 values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。</p>
 * <p>假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。</p>
 * <p>返回 多边形进行三角剖分后可以得到的最低分 。</p>
 */
public class L1039_MinScoreTriangulation {
    public static void main(String[] args) {
        int[] values = {1, 3, 1, 4, 1, 5};
        System.out.println(minScoreTriangulation(values));
    }

    private static int minScoreTriangulation(int[] values) {
        int len = values.length;
        if (len == 3) {
            return values[0] * values[1] * values[2];
        }
        return process(0, len - 1, values, new HashMap<>());
    }


    private static int process(int i, int j, int[] values, Map<Integer, Integer> memo) {
        // 此时已经无法构成多边形，返回0
        if (i + 2 > j) {
            return 0;
        }

        // 此时刚好构成三角形，计算得分
        if (i + 2 == j) {
            return values[i] * values[i + 1] * values[j];
        }
        int key = i * values.length + j;
        if (!memo.containsKey(key)) {
            int minScore = Integer.MAX_VALUE;
            for (int k = i + 1; k < j; k++) {
                minScore = Math.min(minScore,
                        values[i] * values[k] * values[j] + process(i, k, values, memo) + process(k, j, values, memo));
            }
            memo.put(key, minScore);
        }
        return memo.get(key);
    }
}