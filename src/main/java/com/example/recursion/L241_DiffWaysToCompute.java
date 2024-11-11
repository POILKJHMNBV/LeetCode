package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L241:为运算表达式设计优先级</p>
 * <p>
 *     给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * </p>
 * <p>
 *     生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 * </p>
 * <p>
 *     expression 由数字和算符 '+'、'-' 和 '*' 组成。
 *     输入表达式中的所有整数值在范围 [0, 99]
 *     输入表达式中的所有整数都没有前导 '-' 或 '+' 表示符号
 * </p>
 * @author zhenwu
 * @date 2024/11/11 21:47
 */
public class L241_DiffWaysToCompute {
    public static void main(String[] args) {
        String expression = "2*3-4*5";
        System.out.println(diffWaysToCompute(expression));
    }

    private static List<Integer> diffWaysToCompute(String expression) {
        char[] chars = expression.toCharArray();
        return dfs(chars, 0, chars.length - 1);
    }

    /**
     * 深度优先搜索
     * 时间复杂度：O(Cn), 最终结果为卡特兰数列 Cn, n 为输入字符串长度
     * 空间复杂度：O(Cn)，最终结果为卡特兰数列 Cn, n 为输入字符串长度
     */
    private static List<Integer> dfs(char[] chars, int l, int r) {
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            char c = chars[i];
            if (c >= '0' && c <= '9') {
                // 数字直接跳过
                continue;
            }
            // 递归处理左右区间
            List<Integer> left = dfs(chars, l, i - 1);
            List<Integer> right = dfs(chars, i + 1, r);
            for (int a : left) {
                for (int b : right) {
                    if (c == '+') {
                        res.add(a + b);
                    } else if (c == '-') {
                        res.add(a - b);
                    } else if (c == '*') {
                        res.add(a * b);
                    }
                }
            }
        }
        if (res.isEmpty()) {
            // 递归到叶子节点了，将数字加入结果集
            int num = 0;
            for (int i = l; i <= r; i++) {
                num = num * 10 + (chars[i] - '0');
            }
            res.add(num);
        }
        return res;
    }
}
