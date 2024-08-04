package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>分披萨</p>
 * <p>
 *     “吃货”和“馋嘴”两人到披萨店点了一份铁盘(圆形)披萨，并嘱咐店员将披萨按放射状切成大小相同的偶数个小块。
 *     但是粗心服务员将披萨切成了每块大小都完全不同奇数块，且肉眼能分辨出大小。
 *     由于两人都想吃到最多的披萨，他们商量了一个他们认为公平的分法:从“吃货”开始，轮流取披萨。
 *     除了第一块披萨可以任意选取以外，其他都必须从缺口开始选。 他俩选披萨的思路不同。
 *     “馋嘴”每次都会选最大块的拨萨，而且“吃货”知道“馋嘴”的想法。
 *     已知披萨小块的数量以及每块的大小，求“吃货”能分得的最大的披萨大小的总和。
 * </p>
 * <p>
 *     输入描述：
 *          第1行为一个正整数奇数 N ，表示披萨小块数量。其中 3 ≤ N< 500
 *          接下来的第 2 行到第 N+1 （共 N 行），每行为一个正整数，表示第i块披萨的大小， 1≤i≤N 。
 *          披萨小块从某一块开始，按照一个方向次序顺序编号为 1 ~ N ,每块披萨的大小范围为[1,2147483647]。
 * </p>
 * <p>
 *     输出描述：”吃货“能分得到的最大的披萨大小的总和。
 * </p>
 * @author zhenwu
 * @date 2024/7/21 15:00
 */
public class H83_AssignPizza {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] pizzas = new int[n];
        for (int i = 0; i < n; i++) {
            pizzas[i] = in.nextInt();
        }
        memo = new long[n][n];
        for (long[] array : memo) {
            Arrays.fill(array, -1);
        }
        long maxPizza = 0;
        for (int i = 0; i < n; i++) {
            maxPizza = Math.max(maxPizza, pizzas[i] + process(i - 1, i + 1, pizzas, n - 1));
        }
        System.out.println(maxPizza);
    }

    private static long[][] memo;

    /**
     * 记忆化递归模拟分披萨的过程求解
     * @param l 缺口左边界
     * @param r 缺口右边界
     * @param pizzas 披萨小块大小数组
     * @param remainPizza 剩余披萨数目
     * @return 吃货在(l, r)或(r, l)这个区间所能分得的最大披萨
     */
    private static long process(int l, int r, int[] pizzas, int remainPizza) {
        if (remainPizza <= 1) {
            return 0;
        }
        int n = pizzas.length;
        l = (l + n) % n;
        r = r % n;

        // 馋嘴每次选最大块的拨萨
        if (pizzas[l] >= pizzas[r]) {
            l = (l - 1 + n) % n;
        } else {
            r = (r + 1) % n;
        }

        if (memo[l][r] != -1) {
            return memo[l][r];
        }

        // 馋嘴选完，吃货选
        long left = pizzas[l] + process(l - 1, r, pizzas, remainPizza - 2);
        long right = pizzas[r] + process(l, r + 1, pizzas, remainPizza - 2);

        // 吃货选择左端或右端披萨所能获得的最大值
        return memo[l][r] = Math.max(left, right);
    }
}
