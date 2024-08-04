package com.example.hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <p>执行任务赚积分</p>
 * <p>
 *     现有 N 个任务需要处理，同一时间只能处理一个任务，处理每个任务所需要的时间固定为 1。
 *     每个任务都有最晚处理时间限制和积分值，在最晚处理时间点之前处理完成任务才可获得对应的积分奖励。
 *     可用于处理任务的时间有限，请问在有限的时间内，可获得的最多积分。
 * </p>
 * <p>
 *      输入描述：
 *          1.第一行为一个数 N ，表示有 N 个任务（1 ≤ N ≤ 100 ）
 *          2.第二行为一个数 T ，表示可用于处理任务的时间。（1 ≤ T ≤ 100）
 *          3.接下来 N 行，每行两个空格分隔的整数（SLA 和 和 V ），SLA 表示任务的最晚处理时间，V 表示任务对应的积分。
 *          4.1≤SLA≤100 , 0 ≤ V ≤ 100000
 * </p>
 * <p>
 *     输出描述：可获得的最多积分
 * </p>
 * @author zhenwu
 * @date 2024/7/11 21:10
 */
public class H35_PerformTaskAcquireIntegral {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int taskNum = in.nextInt();
        int time = in.nextInt();
        int[][] tasks = new int[taskNum][2];
        for (int i = 0; i < taskNum; i++) {
            int lastPerformTaskTime = in.nextInt();
            int integral = in.nextInt();
            tasks[i][0] = lastPerformTaskTime;
            tasks[i][1] = integral;
        }

        Arrays.sort(tasks, Comparator.comparingInt(task -> task[0]));

        // 利用小根堆维护每个最晚时间可以获取的最多积分
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int maxIntegral = 0;
        for (int[] task : tasks) {
            int lastPerformTaskTime = task[0];
            int integral = task[1];

            maxIntegral += integral;
            minHeap.offer(integral);

            if ((lastPerformTaskTime < minHeap.size() || minHeap.size() > time) && !minHeap.isEmpty()) {
                // 时间不够了，淘汰掉积分值最小的任务
                maxIntegral -= minHeap.poll();
            }
        }
        System.out.println(maxIntegral);
    }
}
