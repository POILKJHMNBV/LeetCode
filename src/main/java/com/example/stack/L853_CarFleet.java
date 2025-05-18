package com.example.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>L853:车队</p>
 * @author zhenwu
 * @date 2025/5/18 21:35
 */
public class L853_CarFleet {

    public static void main(String[] args) {

    }

    /**
     * 单调栈
     * 时间复杂度：O(n * log n)
     * 空间复杂度：O(n)
     */
    private static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // 按照起始位置升序排序
        Arrays.sort(cars, Comparator.comparingInt(o -> o[0]));

        ArrayDeque<Double> timeStack = new ArrayDeque<>();
        for (int[] car : cars) {
            double costTime = (target - car[0]) * 1.0 / car[1];
            while (!timeStack.isEmpty() && timeStack.peek() <= costTime) {
                timeStack.pop();
            }
            timeStack.push(costTime);
        }
        return timeStack.size();
    }
}
