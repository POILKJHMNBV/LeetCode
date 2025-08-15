package com.example.bfs;

import java.util.*;

/**
 * <p>L815:公交路线</p>
 * @author zhenwu
 * @date 2025/8/15 21:11
 */
public class L815_NumBusesToDestination {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(S)，其中 S 为站点数
     * 空间复杂度：O(S)
     */
    private static int numBusesToDestination(int[][] routes, int source, int target) {
        // 记录经过每个站点的公交车，键为站点，值为公交车
        Map<Integer, List<Integer>> stopToBusesMap = new HashMap<>();
        for (int i = 0, n = routes.length; i < n; i++) {
            for (int stop : routes[i]) {
                stopToBusesMap.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        // 特判
        if (!stopToBusesMap.containsKey(source) || !stopToBusesMap.containsKey(target)) {
            return source == target ? 0 : -1;
        }

        // 记录从起始站点到每个站点的距离
        Map<Integer, Integer> distMap = new HashMap<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        distMap.put(source, 0);
        while (!queue.isEmpty()) {
            int curStop = queue.poll();
            for (int bus : stopToBusesMap.getOrDefault(curStop, new ArrayList<>())) {
                if (routes[bus] == null) {
                    continue;
                }
                for (int nextStop : routes[bus]) {
                    if (distMap.containsKey(nextStop)) {
                        continue;
                    }
                    distMap.put(nextStop, distMap.get(curStop) + 1);
                    queue.offer(nextStop);
                }
                // 访问完该公交车的所有站点后，将公交车置为null，避免重复访问
                routes[bus] = null;
            }
        }
        return distMap.getOrDefault(target, -1);
    }
}
