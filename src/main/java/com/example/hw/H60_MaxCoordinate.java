package com.example.hw;

import java.util.Scanner;

/**
 * <p>最大坐标值</p>
 * <p>
 *     小明在玩一个游戏，游戏规则如下:在游戏开始前，小明站在坐标轴原点处(坐标值为0)给定一组指令和一个幸运数，每个指令都是一个整数，小明按照指定的要求前进或者后退指定的步数。
 *     前进代表朝坐标轴的正方向走，后退代表朝坐标轴的负方向走，幸运数为一个整数，如果某个指令正好和幸运数相等，则小明行进步数加 1。
 *     例如: 幸运数为 3，指令内[ 2 , 3 , 0 , −5 ]
 *     指令为 2，表示前进 2步
 *     指令为 3 正好好和幸运数相等，前进 3+1=4步
 *     指令为 0,表示原地不动，既不前进，也不后退
 *     指令为 5,表示后退 5步。
 *     请你计算小明在整个游戏过程中，小明所处的最大坐标值。
 * </p>
 * <p>
 *     第一行输入 1 个数字，代表指令的总个数 n ( 1≤n≤100)
 *     第二行输入 1 个数字，代表幸运数 m ( −100≤m≤100)
 *     第三行输入 n 个指令，每个指令值的取值范围为: −100≤指令值≤100
 * </p>
 * <p>
 *     输出在整个游戏过程中，小明所处的最大坐标值。异常情况下输出：12345
 * </p>
 * @author zhenwu
 * @date 2024/7/17 20:35
 */
public class H60_MaxCoordinate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (invalidNum(n, 1, 100)) {
            System.out.println(12345);
            return;
        }
        int luckNum = in.nextInt();
        if (invalidNum(luckNum, -100, 100)) {
            System.out.println(12345);
            return;
        }
        int[] instructions = new int[n];
        for (int i = 0; i < n; i++) {
            int instruction = in.nextInt();
            if (invalidNum(instruction, -100, 100)) {
                System.out.println(12345);
                return;
            }
            instructions[i] = instruction;
        }

        int location = 0, maxCoordinate = 0;
        for (int instruction : instructions) {
            if (instruction == 0) {
                continue;
            }
            if (instruction > 0) {
                location = instruction == luckNum ? location + instruction + 1 : location + instruction;
            } else {
                location = instruction == luckNum ? location + instruction - 1 : location + instruction;
            }
            maxCoordinate = Math.max(location, maxCoordinate);
        }
        System.out.println(maxCoordinate);
    }

    private static boolean invalidNum(int num, int left, int right) {
        return num < left || num > right;
    }
}
