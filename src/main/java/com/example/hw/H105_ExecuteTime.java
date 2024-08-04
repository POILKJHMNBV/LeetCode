package com.example.hw;

import java.util.Scanner;

/**
 * <p>执行时长</p>
 * <p>
 *     为了充分发挥GPU算力，需要尽可能多的将任务交给GPU执行，现在有一个任务数组，数组元素表示在这1秒内新增的任务个数，且每秒都有新增任务。
 *     假设GPU最多一次执行n个任务，一次执行耗时1秒，在保证GPU不空闲情况下，最少需要多长时间执行完成。
 * </p>
 * <p>
 *     输入描述：
 *          第一个参数为GPU一次最多执行的任务个数，取值范围[1, 10000]
 *          第二个参数为任务数组长度，取值范围[1, 10000]
 *          第三个参数为任务数组，数字范围[1, 10000]
 * </p>
 * <p>
 *     输出描述：执行完所有任务最少需要多少秒
 * </p>
 * @author zhenwu
 * @date 2024/7/27 10:34
 */
public class H105_ExecuteTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int mostTasks = in.nextInt();
        int len = in.nextInt();
        int[] tasks = new int[len];
        int time = 0;
        int remainTask = 0;
        for (int i = 0; i < len; i++) {
            tasks[i] = in.nextInt();
            time++;
            remainTask = mostTasks >= (remainTask + tasks[i]) ? 0 : (remainTask + tasks[i] - mostTasks);
        }
        time += (remainTask + mostTasks - 1) / mostTasks;
        System.out.println(time);
    }
}
