package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L115:不同的子序列</p>
 * <p>给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数</p>
 */
public class L115_NumDistinct {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(processPlus(s.toCharArray(), 0, t));
        System.out.println(numDistinctPro(s, t));
    }

    private static int numDistinctPro(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        // 初始化dp
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i <= sLen; i++) {
            dp[i][0] = 1;
        }


        // 开始递推
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++) {
                if (sCharArray[i - 1] == tCharArray[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[sLen][tLen];
    }

    private static int numDistinct(String s, String t) {
        return process(s.toCharArray(), 0, new ArrayList<>(), t);
    }

    /**
     *
     * @param chars 要求解子序列的字符串
     * @param i 当前所来到的位置
     * @param res 当前路径所形成的解
     * @param t 要出现的子序列
     */
    private static int process(char[] chars, int i, List<Character> res, String t) {
        if (i == chars.length) {
            // 找到一个解
            int size = res.size();
            char[] tmp = new char[size];
            for (int j = 0; j < size; j++) {
                tmp[j] = res.get(j);
            }
            return t.equals(new String(tmp)) ? 1 : 0;
        }
        ArrayList<Character> resKeep = new ArrayList<>(res);
        // 当前字符需要
        resKeep.add(chars[i]);
        int result1 = process(chars, i + 1, resKeep, t);

        // 当前字符不需要
        ArrayList<Character> resNoKeep = new ArrayList<>(res);
        int result2 = process(chars, i + 1, resNoKeep, t);
        return result1 + result2;
    }

    /**
     * 节省空间复杂度
     */
    private static int processPlus(char[] chars, int i, String t) {
        if (i == chars.length) {
            StringBuilder sb = new StringBuilder();
            for (char ch : chars) {
                if (ch != 0) {
                    sb.append(ch);
                }
            }
            return t.equals(sb.toString()) ? 1 : 0;
        }

        // 要当前字符
        int res1 = processPlus(chars, i + 1, t);
        char tmp = chars[i];
        chars[i] = 0;

        // 不要当前字符
        int res2 = processPlus(chars, i + 1, t);

        // 回溯
        chars[i] = tmp;
        return res1 + res2;
    }
}
