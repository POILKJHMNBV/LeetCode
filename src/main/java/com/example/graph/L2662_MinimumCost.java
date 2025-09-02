package com.example.graph;

import java.util.*;

/**
 * <p>L2662:前往目标的最小代价</p>
 * @author zhenwu
 * @date 2025/9/2 21:58
 */
public class L2662_MinimumCost {
    public static void main(String[] args) {
        int[] start = {1, 1}, target = {4, 5};
        int[][] specialRoads = {{1, 2, 3, 3, 2}, {3, 4, 4, 5, 1}};
        System.out.println(minimumCost(start, target, specialRoads));
    }

    /**
     * Dijkstra算法
     * 时间复杂度：O(n * n)
     * 空间复杂度：O(n)
     */
    private static int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        // 高位32位为x坐标，低位32位为y坐标
        long s = (long) start[0] << 32 | start[1], t = (long) target[0] << 32 | target[1];

        // 初始化到终点的距离为无穷大, 源点到源点的距离为0
        Map<Long, Integer> distMap = new HashMap<>();
        distMap.put(t, Integer.MAX_VALUE);
        distMap.put(s, 0);

        // 记录访问过的结点
        Set<Long> visited = new HashSet<>();
        while (true) {
            long p = -1;
            int dis = -1;

            // 找到距离最短的点
            for (Map.Entry<Long, Integer> entry : distMap.entrySet()) {
                Long key = entry.getKey();
                int value = entry.getValue();
                if (!visited.contains(key) && (dis == -1 || value < dis)) {
                    p = key;
                    dis = value;
                }
            }
            if (p == t) {
                return dis;
            }
            // 添加访问过的点
            visited.add(p);

            int x = (int) (p >> 32), y = (int) (p);

            // 更新到终点的距离的最小值
            distMap.merge(t, dis + Math.abs(x - target[0]) + Math.abs(y - target[1]), Math::min);

            for (int[] specialRoad : specialRoads) {
                int x1 = specialRoad[0], y1 = specialRoad[1], x2 = specialRoad[2], y2 = specialRoad[3], cost = specialRoad[4];
                // 通过特殊道路更新最短路径
                int newDis = dis + Math.abs(x - x1) + Math.abs(y - y1) + cost;
                long next = (long) x2 << 32 | y2;
                if (newDis < distMap.getOrDefault(next, Integer.MAX_VALUE)) {
                    distMap.put(next, newDis);
                }
            }
        }
    }
}
