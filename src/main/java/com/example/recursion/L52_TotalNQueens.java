package com.example.recursion;

/**
 * <p>L52:N 皇后 II</p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 */
public class L52_TotalNQueens {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(totalNQueens(n));
        System.out.println(TotalNQueens.totalNQueens(n));
    }

    private static int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }

        // record[i] -> i行的皇后，放在了第几列
        int[] record = new int[n];
        return process(0, record, n);
    }

    /**
     * <p>潜台词：record[0..i - 1]的皇后，任何两个皇后一定都不共行，共列，共斜线</p>
     * 时间复杂度 O(n<sup>n</sup>)
     * @param i 目前来到了第i行
     * @param record record[i..i - 1]表示之前的行，已经放置好了皇后的位置
     * @param n 整体一共有多少行
     * @return 摆完所有的皇后，合理的摆法一共有多少种
     */
    private static int process(int i, int[] record, int n) {
        if (i == n) {
            // 此时所有皇后已经摆好位置，找到一种摆放方法
            return 1;
        }
        int res = 0;
        // 每来到一行，尝试每一列是否可以摆放皇后
        for (int j = 0; j < n; j++) {
            // 当前i行的皇后，放在j列，会不会和之前(0..i - 1)的皇后，共行，共列，共斜线
            // 如果是，认为无效；如果不是，认为有效
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                // 共列或者共斜线
                return false;
            }
        }
        return true;
    }
}

/**
 * 利用位运算优化N皇后问题的常数时间复杂度
 */
class TotalNQueens {
    public static int totalNQueens(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }

        // record[i] -> i行的皇后，放在了第几列
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process(limit, 0, 0 , 0);
    }

    /**
     * 递归求解N皇后问题
     * @param limit 皇后可以摆放的位置
     * @param colLim 列的限制，1的位置不能放皇后，0的位置可以
     * @param leftDiaLim 左斜线的限制，1的位置不能放皇后，0的位置可以
     * @param rightDiaLim 右斜线的限制，1的位置不能放皇后，0的位置可以
     * @return 摆完所有的皇后，合理的摆法一共有多少种
     */
    private static int process(int limit, int colLim, int leftDiaLim, int rightDiaLim) {
        if (colLim == limit) {
            return 1;
        }

        // 皇后可以摆放的位置
        int pos = limit & (~(colLim | leftDiaLim | rightDiaLim));
        int mostRightOne, res = 0;
        while (pos != 0) {
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process(limit, colLim | mostRightOne, (leftDiaLim | mostRightOne) << 1, (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }
}