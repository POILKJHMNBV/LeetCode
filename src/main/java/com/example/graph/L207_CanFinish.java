package com.example.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>L207: 课程表</p>
 * <p>
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * </p>
 */
public class L207_CanFinish {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    /**
     * 拓扑排序
     */
    private static boolean canFinish(int numCourses, int[][] prerequisites) {

        // 入度数组
        int[] inDegree = new int[numCourses];

        // 邻接表
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            ArrayList<Integer> arrayList = adj.getOrDefault(prerequisite[1], new ArrayList<>());
            arrayList.add(prerequisite[0]);
            adj.put(prerequisite[1], arrayList);
        }

        // 利用队列进行拓扑排序
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            if (adj.containsKey(course)) {
                for (int adjCourse : adj.get(course)) {
                    inDegree[adjCourse]--;
                    if (inDegree[adjCourse] == 0) {
                        queue.offer(adjCourse);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
