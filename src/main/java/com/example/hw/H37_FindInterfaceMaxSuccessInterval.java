package com.example.hw;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * <p>查找接口成功率最优时间段</p>
 * <p>
 *  服务之间交换的接口成功率作为服务调用关键质量特性，某个时间段内的接口失败率使用一个数组表示。
 *  数组中每个元素都是单位时间内失败率数值，数组中的数值为0~100的整数，
 *  给定一个数值(minAverageLost)表示某个时间段内平均失败率容忍值，即平均失败率小于等于minAverageLost.找出数组中最长时间段，
 *  如果未找到则直接返回NULL。
 * </p>
 * <p>
 *     输入描述：
 *          有两行内容，
 *              第一行为 minAverageLost，
 *              第二行为数组，数组元素通过空格(" ")分隔,
 *              minAverageLost及数组中元素取值范围为0~100的整数，数组元素的个数不会超过100个
 * </p>
 * <p>
 *     输出描述：
 *          找出平均值小于等于minAverageLost的最长时间段，输出数组下标对，格式{beginIndex}-{endIndex} (下标从0开始)
 * </p>
 * @author zhenwu
 * @date 2024/7/13 13:31
 */
public class H37_FindInterfaceMaxSuccessInterval {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int minAverageLost = Integer.parseInt(in.nextLine());
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 计算出数组每个位置的前缀和
        int length = nums.length;
        int[] prefixSum = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }

        LinkedList<int[]> res = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                if (((prefixSum[j] - prefixSum[i]) * 1.0 / (j - i)) <= minAverageLost) {
                    int interval = j - i;
                    if (res.isEmpty()) {
                        res.add(new int[]{i, j - 1});
                    } else {
                        int[] lastInterval = res.peekLast();
                        if (interval > (lastInterval[1] - lastInterval[0] + 1)) {
                            res.removeLast();
                            res.add(new int[]{i, j - 1});
                        } else if (interval == (lastInterval[1] - lastInterval[0] + 1)) {
                            res.add(new int[]{i, j - 1});
                        }
                    }
                }
            }
        }

        for (int[] interval : res) {
            System.out.print(interval[0] + "-" + interval[1] + " ");
        }
    }
}
