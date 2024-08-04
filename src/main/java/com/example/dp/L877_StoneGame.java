package com.example.dp;

/**
 * <p>L877:石子游戏</p>
 * <p>Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i]</p>
 * <p>游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局</p>
 * <p>Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜</p>
 * <p>假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false</p>
 */
public class L877_StoneGame {
    public static void main(String[] args) {

    }


    private static boolean stoneGame(int[] piles) {
        // 初始化dp
        int len = piles.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }

        // 开始递推
        for (int j = 1; j < len; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }

        return dp[0][len - 1] > 0;
    }
}