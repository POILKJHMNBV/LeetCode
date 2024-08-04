package com.example.hw;

import java.util.Scanner;

/**
 * <p>运输时间</p>
 * <p>
 *     M 辆车需要在一条不能超车的单行道到达终点，起点到终点的距离为 N 。
 *     速度快的车追上前车后，只能以前车的速度继续行驶，求最后一车辆到达目的地花费的时间。
 *     注意：
 *          每辆车固定间隔 1 小时出发，比如第一辆车 0 时出发，第二辆车 1 时出发，依次类推。
 * </p>
 * <p>
 *     输入描述：
 *          第一行两个数字： M 、 N，分别代表车辆数和到终点的距离，以空格分隔。
 *          接下来 M 行，每行 1 个数字 S , 代表每辆车的速度。
 *          1 ≤ M ≤ 20，1 ≤ N ≤ 400，0 < S < 30
 * </p>
 * <p>
 *     输出描述：
 *          最后一辆车到达目的地花费的时间。
 * </p>
 * @author zhenwu
 * @date 2024/7/16 21:11
 */
public class H56_TransportTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        // 最后一辆车的到达时间
        double lastCarArriveTime = 0;
        for (int i = 0; i < m; i++) {
            int speed = in.nextInt();
            // 每辆车预期到达终点的时间 = 1.0 * n / speed + 等待时间
            // 考虑到堵车情况，取每辆车预期到达终点的时间的最大值，即最慢的车到达终点的时间，即为最后一辆车的到达时间
            lastCarArriveTime = Math.max(lastCarArriveTime, 1.0 * n / speed + i);
        }
        System.out.println(lastCarArriveTime - m + 1);
    }
}
