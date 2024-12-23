package com.example.queue;

import java.util.*;

/**
 * <p>L218:天际线问题</p>
 * @author zhenwu
 * @date 2024/11/17 21:17
 */
public class L218_GetSkyline {
    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        System.out.println(getSkylineRBTree(buildings));
    }

    /**
     * 红黑树解决天际线问题
     * 时间复杂度：O(n logn)
     * 空间复杂度：O(n)
     */
    private static List<List<Integer>> getSkylineRBTree(int[][] buildings) {
        // 1.预处理
        List<int[]> buildingsList = new ArrayList<>();
        for (int[] building : buildings) {
            // 左边界，高度
            buildingsList.add(new int[]{building[0], -building[2]});
            // 右边界，高度
            buildingsList.add(new int[]{building[1], building[2]});
        }

        // 2.排序
        buildingsList.sort((a, b) -> {
            int res = a[0] - b[0];
            return res == 0 ? a[1] - b[1] : res;
        });

        // key 为高度，value 为该高度出现的次数
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        int preHeight = 0;
        List<List<Integer>> res = new ArrayList<>();
        // 初始化，高度为0的建筑物出现一次
        treeMap.put(preHeight, 1);
        for (int[] building : buildingsList) {
            if (building[1] < 0) {
                // 高度为负值，表示左边界，可以添加到树中
                treeMap.put(-building[1], treeMap.getOrDefault(-building[1], 0) + 1);
            } else {
                // 高度为正值，表示右边界，需要延迟删除
                treeMap.put(building[1], treeMap.get(building[1]) - 1);
                if (treeMap.get(building[1]) == 0) {
                    treeMap.remove(building[1]);
                }
            }

            int curHeight = treeMap.lastKey();
            if (curHeight != preHeight) {
                res.add(Arrays.asList(building[0], curHeight));
                preHeight = curHeight;
            }
        }
        return res;
    }

    /**
     * 延迟队列解决天际线问题
     * 时间复杂度：O(n logn)
     * 空间复杂度：O(n)
     */
    private static List<List<Integer>> getSkyline(int[][] buildings) {
        // 1.预处理
        List<int[]> buildingsList = new ArrayList<>();
        for (int[] building : buildings) {
            // 左边界，高度
            buildingsList.add(new int[]{building[0], -building[2]});
            // 右边界，高度
            buildingsList.add(new int[]{building[1], building[2]});
        }

        // 2.排序
        buildingsList.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // 3.处理
        // 利用大根堆，维护当前所有建筑的高度
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // 哈希表，记录「延迟删除」的元素，key 为元素，value 为需要删除的次数
        Map<Integer, Integer> delayed = new HashMap<>();

        // 哨兵
        maxHeap.offer(0);

        // 前一个建筑物的高度
        int preHeight = 0;
        List<List<Integer>> res = new ArrayList<>();

        for (int[] building : buildingsList) {
            if (building[1] < 0) {
                // 高度为负值，表示左边界，可以添加到堆中
                maxHeap.offer(-building[1]);
            } else {
                // 高度为正值，表示右边界，需要延迟删除
                delayed.put(building[1], delayed.getOrDefault(building[1], 0) + 1);
            }

            while (!maxHeap.isEmpty()) {
                int curHeight = maxHeap.peek();
                if (delayed.containsKey(curHeight)) {
                    // 需要删除的次数大于 0，需要延迟删除
                    delayed.put(curHeight, delayed.get(curHeight) - 1);
                    if (delayed.get(curHeight) == 0) {
                        // 当前高度需要删除
                        delayed.remove(curHeight);
                    }
                    maxHeap.poll();
                } else {
                    break;
                }
            }

            int curHeight = maxHeap.peek();
            // 有高度差，才有关键点出现
            if (curHeight != preHeight) {
                // 正在扫过的左端点的值
                res.add(Arrays.asList(building[0], curHeight));
                // 当前高度成为计算高度差的标准
                preHeight = curHeight;
            }

        }
        return res;
    }
}
