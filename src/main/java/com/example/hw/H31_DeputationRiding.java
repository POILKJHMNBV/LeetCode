package com.example.hw;

import java.util.*;

/**
 * <p>代表团坐车</p>
 * <p>
 *     某组织举行会议，来了多个代表团同时到达，接待处只有一辆汽车可以同时接待多个代表团，为了提高车辆利用率，请帮接待员计算可以坐满车的接待方案输出方案数量。
 *     约束：
 *      1.一个团只能上一辆车，并且代表团人数(代表团数量小于30，每个代表团人数小于30)小于汽车容量(汽车容量小于100)。
 *      2.需要将车辆坐满
 * </p>
 * <p>
 *     输入描述：
 *          第一行 代表团人数，英文逗号隔开，代表团数量小于30，每个代表团人数小于30。
 *          第二行 汽车载客量，汽车容量小于100。
 * </p>
 * <p>
 *     输出描述：
 *          坐满汽车的方案数量，如果无解输出0
 * </p>
 * @author zhenwu
 * @date 2024/7/10 20:30
 */
public class H31_DeputationRiding {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] deputation = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int capacity = Integer.parseInt(in.nextLine());
        List<List<Integer>> res = new ArrayList<>();
        backtracking(deputation, capacity, new ArrayList<>(), res, 0);
        int num = dynamicProgramming(deputation, capacity);
        System.out.println(res.size());
        System.out.println(num);
    }

    /**
     * 动态规划求解(转换为0-1背包问题)
     * @param deputation 代表团人数数组
     * @param capacity 汽车容量
     * @return 坐满汽车的方案数
     */
    private static int dynamicProgramming(int[] deputation, int capacity) {
        int len = deputation.length;

        // dp[i][j]表示在区间0...i的代表团坐满容量为j的汽车的方案数
        int[][] dp = new int[len][capacity + 1];
        dp[0][deputation[0]] = 1;
        dp[0][0] = 1;

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= capacity; j++) {
                // 当前代表团坐不上车
                dp[i][j] = dp[i - 1][j];
                if (j >= deputation[i]) {
                    // 当前代表团坐上车
                    dp[i][j] += dp[i - 1][j - deputation[i]];
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        return dp[len - 1][capacity];
    }

    /**
     * 暴力递归求解
     * @param deputation 代表团人数数组
     * @param capacity 汽车容量
     * @param path 单次递归结果
     * @param res 结果集
     * @param startIndex 开始索引
     */
    private static void backtracking(int[] deputation,
                                     int capacity,
                                     List<Integer> path,
                                     List<List<Integer>> res,
                                     int startIndex) {
        Optional<Integer> optional = path.stream().reduce(Integer::sum);
        if (optional.isPresent()) {
            int sum = optional.get();
            if (sum >= capacity) {
                if (sum == capacity) {
                    res.add(new ArrayList<>(path));
                }
                return;
            }
        }
        for (int i = startIndex; i < deputation.length; i++) {
            path.add(deputation[i]);
            backtracking(deputation, capacity, path, res, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
