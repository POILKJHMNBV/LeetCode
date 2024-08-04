package com.example.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>L51:N 皇后</p>
 * <p>按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。</p>
 */
public class L51_SolveNQueens {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(solveNQueens(n));
    }

    private static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }
        // record[i] -> i行的皇后，放在了第几列
        int[] record = new int[n];
        process(res, record, 0, n);
        return res;
    }

    private static void process(List<List<String>> res, int[] record, int i, int n) {
        if (i == n) {
            // 找到一种解法
            List<String> list = new ArrayList<>();
            for (int r : record) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[r] = 'Q';
                list.add(new String(chars));
            }
            res.add(list);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                process(res, record, i + 1, n);
            }
        }
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
