package com.example.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * <p>L739::每日温度</p>
 * <p>
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * </P>
 */
public class L739_DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    private static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] res = new int[len];
        queue.push(0);
        for (int i = 1; i < len; i++) {
            while (!queue.isEmpty() && temperatures[i] > temperatures[queue.peek()]) {
                int index = queue.pop();
                res[index] = i - index;
            }
            queue.push(i);
        }
        return res;
    }
}
