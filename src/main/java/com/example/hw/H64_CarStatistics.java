package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>停车场车辆统计</p>
 * <p>
 *     特定大小的停车场，数组cars[]表示，其中1表示有车，0表示没车
 *     车辆大小不一，小车占一个车位（长度1），货车占两个车位（长度2），卡车占三个车位（长度3），统计停车场最少可以停多少辆车，返回具体的数目。
 * </p>
 * <p>
 *     输入描述：整型字符串数组cars[]，其中1表示有车，0表示没车，数组长度小于1000。
 *     输出描述：整型数字字符串，表示最少停车数目。
 * </p>
 * @author zhenwu
 * @date 2024/7/17 21:15
 */
public class H64_CarStatistics {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] cars = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int minCarNum = 0, count = 0;
        int len = cars.length;
        for (int i = 0; i < len; i++) {
            if (cars[i] == 1) {
                for (; i < len && cars[i] == 1; i++) {
                    count++;
                }
                minCarNum += Math.ceil(1.0 * count / 3);
                count = 0;
            }
        }
        System.out.println(minCarNum);
    }
}
