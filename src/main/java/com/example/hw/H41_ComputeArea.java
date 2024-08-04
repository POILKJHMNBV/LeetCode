package com.example.hw;

import java.util.Scanner;

/**
 * <p>计算面积</p>
 * <p>
 *  绘图机器的绘图笔初始位置在原点（0, 0），机器启动后其绘图笔按下面规则绘制直线：
 *      1) 尝试沿着横向坐标轴正向绘制直线，直到给定的终点值E
 *      2) 期间可通过指令在纵坐标轴方向进行偏移，并同时绘制直线，偏移后按规则1 绘制直线；指令的格式为X offsetY，表示在横坐标X 沿纵坐标方向偏移，offsetY为正数表示正向偏移，为负数表示负向偏移。
 *         给定了横坐标终点值E、以及若干条绘制指令，请计算绘制的直线和横坐标轴、以及 X=E 的直线组成图形的面积
 * </p>
 * <p>
 *     输入描述：
 *      首行为两个整数N E，表示有N条指令，机器运行的横坐标终点值E；
 *      接下来N行，每行两个整数表示一条绘制指令X offsetY，用例保证横坐标X以递增排席方式出现，目不会出现相同横坐标X；
 *      取值范围: 0<N<=10000，0<= X<=E<=20000,-10000 <= offsetY <= 10000。
 * </p>
 * <p>
 *     输出描述：
 *      一个整数，表示计算得到的面积，用例保证，结果范围在0~4294967295内
 * </p>
 * @author zhenwu
 * @date 2024/7/13 15:48
 */
public class H41_ComputeArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int instructionNum = in.nextInt();
        int destination = in.nextInt();
        int[][] height = new int[instructionNum][2];
        for (int i = 0; i < instructionNum; i++) {
            int x = in.nextInt();
            int y = i == 0 ? in.nextInt() : height[i - 1][1] + in.nextInt();
            height[i][0] = x;
            height[i][1] = y;
        }

        int area = 0;
        for (int i = 0; i < instructionNum; i++) {
            int h = Math.abs(height[i][1]);
            int w = i == instructionNum - 1 ? destination - height[i][0] : height[i + 1][0] - height[i][0];
            area += h * w;
        }
        System.out.println(area);
    }
}
