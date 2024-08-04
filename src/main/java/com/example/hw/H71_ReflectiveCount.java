package com.example.hw;

import java.util.Scanner;

/**
 * <p>反射计数</p>
 * <p>
 *     给定一个包含 0 和 1 的二维矩阵, 给定一个初始位置和速度
 *     一个物体从给定的初始位置出发, 在给定的速度下进行移动, 遇到矩阵的边缘则发生镜面反射无论物体经过 0 还是 1，都不影响其速度。
 *     请计算并给出经过t 时间单位后,物体经过 1 点的次数。
 *     矩阵以左上角位置为[0,0](列(x),行(y)),例如坐标为[ 2 , 1 ](第二列,第一行)。
 *     注意：
 *          如果初始位置的点是 1, 也计算在内
 *          时间的最小单位为1, 不考虑小于 1 个时间单位内经过的点
 * </p>
 * <p>
 *     输入描述：
 *          第一行为初始信息 <w> <h> <x> <y> <sx> <sy> <t>
 *          第二行开始一共h行,为二维矩阵信息
 *          其中w,h 为矩阵的宽和高x,y 为起始位置
 *          sx,sy为初始速度t为经过的时间
 *          所有的输入都是有效的，数据范围 如下：0<w,h<100  0<=x<w  0<=y<h   -1<=sx,sy<=1  0<=t<=100
 * </p>
 * <p>
 *     输出描述：经过1的个数
 * </p>
 * @author zhenwu
 * @date 2024/7/20 9:45
 */
public class H71_ReflectiveCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt(), h = scanner.nextInt();
        int x = scanner.nextInt(), y = scanner.nextInt();
        int sx = scanner.nextInt(), sy = scanner.nextInt();
        int t = scanner.nextInt();

        char[][] grid = new char[h][w];
        for (int i = 0; i < h; i++) {
            grid[i] = scanner.next().toCharArray();
        }

        int ans = 0;
        do {
            if (grid[y][x] == '1') {
                ans++;
            }

            int nx = x + sx;
            if (nx < 0 || nx >= w) {
                sx = -sx; // 边界发生反射
            }

            int ny = y + sy;
            if (ny < 0 || ny >= h) {
                sy = -sy; // 边界发生反射
            }

            x += sx;
            y += sy;
        } while (t-- > 0);
        System.out.println(ans);
    }
}
