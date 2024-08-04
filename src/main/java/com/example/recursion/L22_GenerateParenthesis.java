package com.example.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>L22:括号生成</p>
 * <p>数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。</p>
 */
public class L22_GenerateParenthesis {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        s = s + getZeros(8 - (s.length() % 8));

        int len = s.length();
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < len; i += 8) {
            if (i + 8 <= len) {
                res.add(s.substring(i, i + 8));
            }
        }
        System.out.println(res);
    }

    private static String getZeros(int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(0);
        }
        return sb.toString();
    }

    private static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    /**
     * dfs
     * @param str 结果字符串
     * @param left 当前剩余的左括号数量
     * @param right 当前剩余的右括号数量
     * @param res 结果集
     */
    private static void dfs(String str, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left > right) {
            // 剪枝
            return;
        }

        if (left > 0) {
            dfs(str + "(", left - 1, right, res);
        }

        if (right > 0) {
            dfs(str + ")", left, right - 1, res);
        }
    }
}
