package com.example.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的。
 * 如果要买归类为附件的物品，必须先买该附件所属的主件，且每件物品只能购买一次。
 * 每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。
 * 王强查到了每件物品的价格（都是 10 元的整数倍），而他只有 N 元的预算。除此之外，他给每件物品规定了一个重要度，用整数 1 ~ 5 表示。他希望在花费不超过 N 元的前提下，使自己的满意度达到最大。
 * 满意度是指所购买的每件物品的价格与重要度的乘积的总和
 * </p>
 *
 * <p>
 * 输入的第 1 行，为两个正整数N，m，用一个空格隔开：
 * （其中 N （ N<32000 ）表示总钱数， m （m <60 ）为可购买的物品的个数。）
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 * </p>
 */
public class N16_ShoppingList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] metaData = line.split(" ");

        // 总金额
        int totalMoney = Integer.parseInt(metaData[0]);

        // 物品总数
        int n = Integer.parseInt(metaData[1]);

        // 物品价格数组
        int[] prices = new int[n];
        // 物品重要度数组
        int[] important = new int[n];
        // 附件从属主件关系数组
        int[] relation = new int[n];


        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] data = s.split(" ");
            prices[i] = Integer.parseInt(data[0]);
            important[i] = Integer.parseInt(data[1]);
            relation[i] = Integer.parseInt(data[2]);
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (relation[i] != 0) {
                List<Integer> list = map.getOrDefault(relation[i], new ArrayList<>());
                list.add(i);
                map.put(relation[i], list);
            }
        }

        // dp[i][j], 表示前i个物品花费j元时所获得的最大满意度
        int[][] dp = new int[n + 1][totalMoney + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= totalMoney; j++) {
                // 不购买第i个物品
                dp[i][j] = dp[i - 1][j];
                if (relation[i - 1] != 0) {
                    // 物品为附件, 跳过本次循环
                    continue;
                }

                int satisfaction = prices[i - 1] * important[i - 1];

                // 购买该物品, 0附件
                if (j >= prices[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - prices[i - 1]] + satisfaction, dp[i][j]);
                }

                // 购买该物品, 第一个附件
                if (map.containsKey(i)) {
                    List<Integer> list = map.get(i);
                    int firstAttIndex = list.get(0);
                    if (j >= prices[i - 1] + prices[firstAttIndex]) {
                        dp[i][j] = Math.max(dp[i - 1][j - prices[i - 1] - prices[firstAttIndex]]
                                + satisfaction
                                + prices[firstAttIndex] * important[firstAttIndex], dp[i][j]);
                    }
                }

                // 购买该物品, 第二个附件
                if (map.containsKey(i)) {
                    List<Integer> list = map.get(i);
                    if (list.size() == 2) {
                        int secondAttIndex = list.get(1);
                        if (j >= prices[i - 1] + prices[secondAttIndex]) {
                            dp[i][j] = Math.max(dp[i - 1][j - prices[i - 1] - prices[secondAttIndex]]
                                    + satisfaction
                                    + prices[secondAttIndex] * important[secondAttIndex], dp[i][j]);
                        }
                    }
                }

                // 购买该物品, 两个附件
                if (map.containsKey(i)) {
                    List<Integer> list = map.get(i);
                    if (list.size() == 2) {
                        int firstAttIndex = list.get(0);
                        int secondAttIndex = list.get(1);
                        if (j >= prices[i - 1] + prices[firstAttIndex] + prices[secondAttIndex]) {
                            dp[i][j] = Math.max(dp[i - 1][j - prices[i - 1] - prices[firstAttIndex] - prices[secondAttIndex]]
                                    + satisfaction
                                    + prices[firstAttIndex] * important[firstAttIndex]
                                    + prices[secondAttIndex] * important[secondAttIndex], dp[i][j]);
                        }
                    }
                }
            }
        }

        System.out.println(dp[n][totalMoney]);
    }
}