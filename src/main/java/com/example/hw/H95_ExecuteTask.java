package com.example.hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>任务处理</p>
 * <p>
 *     在某个项目中有多个任务(用tasks数组表示)需要您进行处理，其中tasks[i]=[si,ei],
 *     你可以在si <= day <= ei 中的任意一天处理该任务，请返回你可以处理的最大任务数
 * </p>
 * <p>
 *     输入描述：
 *          第一行为任务数量n，1 <= n <= 100000。
 *          后面n行表示各个任务的开始时间和终止时间，使用si,ei表示,1 <= si <= ei <= 100000
 * </p>
 * <p>
 *     输出描述：输出为一个整数，表示可以处理的最大任务数。
 * </p>
 * @author zhenwu
 * @date 2024/7/23 20:38
 */
public class H95_ExecuteTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            tasks[i][0] = in.nextInt();
            tasks[i][1] = in.nextInt();
        }
        /* 思路：
                1.将任务数组按照开始时间从小到大排序。
                2.使用一个小根堆（优先队列），用于保存当前可以执行的任务的截止时间。
                3.遍历每一天，将当天开始的任务加入小根堆，同时弹出已经过期的任务。
                4.在小根堆中选择距离截止时间最近的任务进行处理，每次处理后将该任务从小根堆中弹出。
                5.统计处理的任务数量即为最大任务数。
            总结：利用贪心思想，每天取出快过期的任务执行，淘汰已经过期的任务，求取可以处理的最大任务数
         */
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int res = 0, index = 0;
        for (int time = 1; time <= 100000; time++) {
            while (index < n && tasks[index][0] <= time) {
                // 将当天可以执行的任务加入小根堆
                minHeap.offer(tasks[index++][1]);
            }

            while (!minHeap.isEmpty() && minHeap.peek() < time) {
                // 任务已经过期，移除任务
                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                // 当天可以取出一个任务执行
                minHeap.poll();
                res++;
            }
        }
        System.out.println(res);
    }
}
