package com.example.string;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L166:分数到小数</p>
 * @author zhenwu
 * @date 2024/10/23 20:34
 */
public class L166_FractionToDecimal {
    public static void main(String[] args) {
        int numerator = 10, denominator = 3;
        System.out.println(fractionToDecimal(numerator, denominator));
    }

    /**
     * 模拟除法过程，记录余数出现的位置
     * 时间复杂度：O(n), n为答案的长度
     * 空间复杂度：O(n), n为答案的长度
     * @param numerator 分子
     * @param denominator 分母
     */
    private static String fractionToDecimal(int numerator, int denominator) {
        // 转为long型，防止溢出
        long a = numerator, b = denominator;
        if (a % b == 0) {
            // 整除,，直接返回结果
            return String.valueOf(a / b);
        }
        StringBuilder sb = new StringBuilder();
        if ((a < 0) ^ (b < 0)) {
            // 符号不同
            sb.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b).append(".");
        a %= b;

        // 开始处理小数部分
        Map<Long, Integer> map = new HashMap<>();
        while (a != 0) {

            // 记录当前余数所在答案的位置，并继续模拟除法运算
            map.put(a, sb.length());

            // 模拟除法运算
            a *= 10;
            sb.append(a / b);
            a %= b;

            // 判断是否重复出现，如果重复出现说明已经循环完毕
            if (map.containsKey(a)) {
                int u = map.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }
        return sb.toString();
    }
}
