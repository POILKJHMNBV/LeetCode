package com.example.hw;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * <p>火星符号运算</p>
 * <p>
 *     已知火星人使用的运算符号为 #和 $
 *     其与地球人的等价公式如下
 *          x#y = 4 * x + 3 * y + 2
 *          x$y = 2 * x + y + 3
 *      1. x y是无符号整数。
 *      2. 地球人公式按照c语言规则进行计算。
 *      3. 火星人公式中，# 号的优先级高于 $ ,相同的运算符，按从左往右的顺序计算
 *      现有一段火星人的字符串报文，请你来翻译并计算结果
 * </p>
 * <p>
 *     输入描述：
 *          火星人的字符串表达式（结尾不带回车换行）
 *          输入的字符串说明：字符串为仅无符号整数和操作符（#、$）组成的计算表达式
 *              1.用例保证字符串中，操作数与操作符之间没有任何分隔符
 *              2.用例保证操作数取值范围为 3232 为无符号整数
 *              3.保证输入以及计算结果不会出现int整数溢出
 *              4.保证输入的字符串为合法的求值报文
 *              5.保证不会出现非法的求值报文
 * </p>
 * <p>
 *     输出描述：根据输入的火星人字符串输出计算结果（结尾不带回车换行）
 * </p>
 * @author zhenwu
 * @date 2024/7/22 20:24
 */
public class H87_MarsSymbolCalculate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        ArrayDeque<Character> opStack = new ArrayDeque<>();
        ArrayDeque<Integer> numStack = new ArrayDeque<>();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char ch = chars[i];
            if (Character.isDigit(ch)) {
                int num = 0, j = i;
                while (j < len && Character.isDigit(chars[j])) {
                    num = 10 * num + (chars[j++] - '0');
                }
                numStack.push(num);
                i = j - 1;
            } else {
                while (!opStack.isEmpty() && opStack.peek() == '#') {
                    calculate(opStack, numStack);
                }
                opStack.push(ch);
            }
        }
        while (!opStack.isEmpty()) {
            calculate(opStack, numStack);
        }
        System.out.print(numStack.poll());
    }

    private static void calculate(ArrayDeque<Character> opStack, ArrayDeque<Integer> numStack) {
        if (opStack.isEmpty() || numStack.size() < 2) {
            return;
        }
        int y = numStack.poll();
        int x = numStack.poll();
        char ch = opStack.poll();
        if (ch == '#') {
            numStack.push(4 * x + 3 * y + 2);
        } else {
            numStack.push(2 * x + y + 3);
        }
    }
}
