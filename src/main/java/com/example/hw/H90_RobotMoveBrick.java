package com.example.hw;

import com.example.binaryserach.L875_MinEatingSpeed;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>机器人搬砖</p>
 * <p>
 *     机器人搬砖，一共有N堆砖存放在N个不同的仓库中，第 i 堆中有 bricks[i] 块砖头，要求在8小时内搬完。
 *     机器人每小时能搬砖的数量取决于有多少能量格，机器人一个小时中只能在一仓库中搬砖，机器人的能量格每小时补充一次且能量格只在这一个小时有效，为使得机器人损耗最小化，应尽量减小每次补充的能量格数。
 *     为了保障在8小时内能完成砖任务，请计算每小时始机器人充能的最小能量格数。
 *     备注：
 *          1.无需考虑机器人补充能量的耗时
 *          2.无需考虑机器人搬砖的耗时
 *          3.机器人每小时补充能量格只在这一个小时中有效
 * </p>
 * <p>
 *     输入描述：程序有输入为“30 12 25 8 19”一个整数数组，数组中的每个数字代表第i堆砖的个数，每堆砖的个数不超过100
 * </p>
 * <p>
 *     输出描述：
 *          输出在8小时内完成搬砖任务，机器人每小时最少需要充多少个能量格；
 *          如果8个小时内无法完成任务，则输出“-1”；
 * </p>
 * @see L875_MinEatingSpeed
 * @author zhenwu
 * @date 2024/7/22 21:20
 */
public class H90_RobotMoveBrick {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] bricks = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        if (bricks.length > 8) {
            System.out.println(-1);
            return;
        }
        int l = 1;
        int r = Arrays.stream(bricks).max().getAsInt();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (calCostTime(m, bricks) > 8) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        System.out.println(l);
    }

    private static int calCostTime(int speed,int[] bricks) {
        int time = 0;
        for (int brick : bricks) {
            time += (brick + speed - 1) / speed;
        }
        return time;
    }
}
