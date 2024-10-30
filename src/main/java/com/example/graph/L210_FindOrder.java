package com.example.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>L210:课程表 II</p>
 * @author zhenwu
 * @date 2024/10/30 20:53
 */
public class L210_FindOrder {
    public static void main(String[] args) {

    }

    /**
     * 拓扑排序
     * 时间复杂度：O(n + m), 其中 n 为课程数，m 为先修课程的要求数
     * 空间复杂度：O(n + m), 其中 n 为课程数，m 为先修课程的要求数
     */
    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }

        // 记录每个节点的入度
        int[] inDegree = new int[numCourses];

        // 记录每个节点的相邻节点
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        for (int[] edge : prerequisites) {
            inDegree[edge[0]]++;
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        // 记录结果
        ArrayList<Integer> res = new ArrayList<>();

        // 利用队列进行拓扑排序
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // 拓扑排序
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res.add(course);
            if (adj.containsKey(course)) {
                for (int adjCourse : adj.get(course)) {
                    // 将相邻节点的入度减1
                    inDegree[adjCourse]--;
                    if (inDegree[adjCourse] == 0) {
                        queue.offer(adjCourse);
                    }
                }
            }
        }
        return res.size() == numCourses ? res.stream().mapToInt(Integer::valueOf).toArray() : new int[0];
    }
}
