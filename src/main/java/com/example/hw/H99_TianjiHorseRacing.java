package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>田忌赛马</p>
 * <p>
 *     给定两个只包含数字的数组a,b,调整数组a里面数字的顺序，使得尽可能多的a[i] > b[i]。
 *     数组a和b中的数字各不相同。输出所有可以达到最优结果的a数组数量。
 * </p>
 * <p>
 *     输入描述：
 *          输入的第一行是数组a中的数字，其中只包含数字，每两个数字之间相隔一个空格，a数组大小不超过10
 *          输入的第二行是数组b中的数字，其中只包含数字，每两个数字之间相隔一个空格，b数组大小不超过10
 * </p>
 * <p>
 *     输出描述：输出所有可以达到最优结果的a数组数量
 * </p>
 * @author zhenwu
 * @date 2024/7/25 21:09
 */
public class H99_TianjiHorseRacing {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        backtracking(a, b, new boolean[a.length], 0, 0);
        System.out.println(result);
    }

    private static int result = 0;
    private static int maxCount = 0;

    private static void backtracking(int[] a, int[] b, boolean[] visited, int count, int index) {
        if (b.length - index + count < maxCount) {
            // 剪枝，剩下的数就算全部a[i] > b[i]，也不会超过maxCount
            return;
        }
        if (index == b.length) {
            if (count > maxCount) {
                result = 1;
                maxCount = count;
            } else if (count == maxCount) {
                result++;
            }
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            backtracking(a, b, visited, count + (a[i] > b[index] ? 1 : 0), index + 1);
            visited[i] = false;
        }
    }
}
