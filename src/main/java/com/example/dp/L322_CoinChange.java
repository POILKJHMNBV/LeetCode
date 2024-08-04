package com.example.dp;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * <p>L322:零钱兑换</p>
 * <p>给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额</p>
 * <p>计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1.</p>
 * <p>你可以认为每种硬币的数量是无限的。</p>
 */
public class L322_CoinChange {
    public static void main(String[] args) {
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        System.out.println(coinChange(coins, amount));
        System.out.println(coinChangeBasic(coins, amount));
        System.out.println(coinChangePro(coins, amount));
        System.out.println(coinChangeBFS(coins, amount));
    }

    /**
     * 存储面值 i 需要的最少的硬币数
     */
    private static int[] memo;

    /**
     * 暴力递归
     */
    public static int coinChangeBasic(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        Arrays.sort(coins);
        return dfs(coins, amount);
    }

    private static int dfs(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int res = amount + 1;
        for (int coin : coins) {
            if (amount - coin < 0) {
                break;
            }
            int subRes = dfs(coins, amount - coin);
            if (subRes == -1) {
                continue;
            }
            res = Math.min(res, subRes + 1);
        }

        if (res != amount + 1) {
            memo[amount] = res;
        } else {
            memo[amount] = -1;
        }
        return memo[amount];
    }


    /**
     * 抽象为完全背包问题
     * dp[i][j]: [0...i]区间内的硬币，凑成面值 j 所需的最少硬币数
     */
    public static int coinChangePro(int[] coins, int amount) {
        // 初始化dp
        int len = coins.length;
        int[][] dp = new int[len][amount + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], amount + 1);
        }
        dp[0][0] = 0;
        for (int j = coins[0]; j <= amount; j++) {
            if (dp[0][j - coins[0]] != amount + 1) {
                dp[0][j] = dp[0][j - coins[0]] + 1;
            }
        }

        // 开始递推
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i] && dp[i][j - coins[i]] != amount + 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - coins[i]] + 1);
                }
            }
        }

        return dp[len - 1][amount] == amount + 1 ? -1 : dp[len - 1][amount];
    }

    /**
     * 递推公式：dp[amount] = min(dp[amount - coin[i]] + 1)
     * 0 <= i <= len - 1, coin[i] < amount
     * 其中 len = coins.length
     */
    public static int coinChange(int[] coins, int amount) {
        // 初始化dp，由于要求最小值，则初始化为较大值
        int n = amount + 1;
        int[] dp = new int[n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != n) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == n ? -1 : dp[amount];
    }

    /**
     * 广度优先遍历
     */
    public static int coinChangeBFS(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[amount + 1];
        int step = 1;
        Arrays.sort(coins);
        queue.add(amount);
        visited[amount] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curAmount = queue.pop();
                for (int coin : coins) {
                    int next = curAmount - coin;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return step;
                    }

                    if (!visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
