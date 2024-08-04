package com.example.hw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * <p>最大化控制资源成本</p>
 * <p>
 *     公司创新实验室正在研究如何最小化资源成本，最大化资源利用率，
 *     请你设计算法帮他们解决一个任务分布问题:有taskNum项任务，每人任务有开始时间(startTime) ，结束时间(endTme) 并行度(paralelism) 三个属性，
 *     并行度是指这个任务运行时将会占用的服务器数量，一个服务器在每个时刻可以被任意任务使用但最多被一个任务占用，任务运行完成立即释放(结束时刻不占用)。
 *     任务分布问题是指给定一批任务，让这批任务由同一批服务器承载运行，请你计算完成这批任务分布最少需要多少服务器，从而最大化控制资源成本
 * </p>
 * <p>
 *     输入描述:
 *          第一行输入为taskNum，表示有taskNum项任务 接下来taskNum行，每行三个整数，表示每个任务的开始时间(startTime ) ，结束时间 (endTime ) ，并行度 (parallelism)
 *     输出描述:
 *          一个整数，表示最少需要的服务器数量
 * </p>
 * @author zhenwu
 * @date 2024/7/4 20:16
 */
public class H16_MaximizedControlCost {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int taskNum = in.nextInt();
        int[][] tasks = new int[taskNum][3];
        for (int i = 0; i < taskNum; i++) {
            tasks[i][0] = in.nextInt();
            tasks[i][1] = in.nextInt();
            tasks[i][2] = in.nextInt();
        }
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[0]));

        int maxServers = 0;
        for (int i = 0; i < taskNum - 1; i++) {
            int[] curTask = tasks[i];
            int[] nextTask = tasks[i + 1];
            if (curTask[1] > nextTask[0]) {
                maxServers = Math.max(maxServers, curTask[2] + nextTask[2]);
            } else {
                maxServers = Math.max(maxServers, Math.max(curTask[2], nextTask[2]));
            }
        }
        System.out.println(maxServers);
    }
}