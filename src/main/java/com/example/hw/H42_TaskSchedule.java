package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>项目排期</p>
 * <p>
 *     项目组共有N个开发人员，项目经理接到了M个独立的需求，每个需求的工作量不同，且每个需求只能由一个开发人员独立完成，不能多人合作。
 *     假定各个需求直接无任何先后依赖关系，请设计算法帮助项目经理进行工作安排，使整个项目能用最少的时间交付。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入为M个需求的工作量，单位为天，用逗号隔开。
 *          例如：X1 X2 X3 .... Xm 表示共有M个需求，每个需求的工作量分别为X1天，X2天......Xm天。其中0<M<30；0<Xm<200
 *          第二行输入为项目组人员数量N 例如： 5 表示共有5名员工，其中0<N<10
 * </p>
 * <p>
 *     输出描述：
 *          最快完成所有工作的天数 例如： 25 表示最短需要25天能完成所有工作
 * </p>
 * @author zhenwu
 * @date 2024/7/13 16:57
 */
public class H42_TaskSchedule {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] tasks = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int people = Integer.parseInt(in.nextLine());

        // 利用二分查找和暴力递归求出最快完成所有工作所需的天数
        int l = Arrays.stream(tasks).max().getAsInt() - 1;
        int r = Arrays.stream(tasks).sum();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (!canAllocate(0, m, new int[people], tasks)) {
                // 当前天数不足以完成任务，尝试增加天数
                l = m + 1;
            } else {
                r = m;
            }
        }
        System.out.println(l);
    }

    /**
     * 在工作所需的天数为maxDays时，每个开发是否可以按时完成工作
     * @param idx 任务索引
     * @param maxDays 最快完成所有工作所需的天数
     * @param sums 每个开发人员完成工作所需的天数
     * @param tasks 任务数组
     * @return 开发是否可以按时完成工作
     */
    private static boolean canAllocate(int idx, int maxDays, int[] sums, int[] tasks) {
        if (idx == tasks.length) {
            // 任务已经分配完
            return true;
        }
        for (int i = 0; i < sums.length; i++) {
            // 尝试将任务分给第i个开发人员
            if (sums[i] + tasks[idx] <= maxDays) {
                // 当前开发可以分配该任务
                sums[i] += tasks[idx];
                if (canAllocate(idx + 1, maxDays, sums, tasks)) {
                    return true;
                }
                // 当前开发不能分配该任务，尝试下一个开发人员
                sums[i] -= tasks[idx];
            }
        }
        return false;
    }
}
