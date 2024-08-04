package com.example.hw;

import java.util.Scanner;

/**
 * <p>贪心歌手</p>
 * <p>
 *     一个歌手准备从A城去B城参加演出
 *          1.按照合同，他必须在T天内赶到
 *          2.歌手不能往回走
 *          3.每两座城市之间需要的天数都可以提前获知
 *          4.歌手在每座城市都可以在路边卖唱赚钱。经过调研，歌手提前获知了每座城市卖唱的收入预期: 如果在一座城市第一天卖唱可以赚M，后续每天的收入会减少D(第二天赚的钱是M - D，第三天是M-2D…)如果收入减到0就不会再少了
 *          5.歌手到达后的第二天才能开始卖唱。如果今天卖过唱，第二天才能出发
 *     贪心的歌手最多可以赚多少钱?
 * </p>
 * <p>
 *     输入描述：
 *          第一行两个数字 T 和 N，中间用空格隔开 T 代表总天数; N 代表路上经过N座城市; 0 < T < 1000 ,0 < N < 100
 *          第二行N+1个数字，中间用空格隔开 代表每两座城市之间耗费的时间。 其总和<=T
 *          接下来N行，每行两个数字M和D，中间用空格隔开.
 *          代表每个城市的收入预期。
 *          0< M <1000, 0 < D < 100
 * </p>
 * <p>
 *     输出描述：一个数字。代表歌手最多可以赚多少钱。以回车结束
 * </p>
 * @author zhenwu
 * @date 2024/7/14 17:22
 */
public class H50_GreedySinger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalDay = in.nextInt();
        int cityNum = in.nextInt();
        int hasCostDay = 0;
        for (int i = 0; i < cityNum + 1; i++) {
            hasCostDay += in.nextInt();
        }
        int[][] expectIncomeArray = new int[cityNum][2];
        for (int i = 0; i < cityNum; i++) {
            expectIncomeArray[i][0] = in.nextInt();
            expectIncomeArray[i][1] = in.nextInt();
        }

        int remainDay = totalDay - hasCostDay;

        // dp[i][j]表示到达第i座城市时已经耗费的总天数为j时所能获得获得的最大收益
        int[][] dp = new int[cityNum + 1][remainDay + 1];
        for (int i = 1; i <= cityNum; i++) {
            int[] expectCome = expectIncomeArray[i - 1];
            int profit = expectCome[0];
            int loss = expectCome[1];

            // 表示在第i座城市耗费 costDay 时，在第i座城市所获得的收益
            int money = 0;

            // costDay表示在第i座城市耗费的天数
            for (int costDay = 0; costDay <= remainDay; costDay++) {
                // j表示到达第i座城市时已经耗费的总天数
                for (int j = costDay; j <= remainDay; j++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - costDay] + money);
                }
                money += profit;
                profit = Math.max(0, profit - loss);
            }
        }

        System.out.println(dp[cityNum][remainDay]);
    }
}
