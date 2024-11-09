package com.example.stack;

import com.example.hw.H44_Arithmetic;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>L227:基本计算器 II</p>
 * @author zhenwu
 * @date 2024/11/9 20:48
 * @see L224_SimpleCalculator
 * @see H44_Arithmetic
 */
public class L227_Calculate {
    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        System.out.println(calculate(s));
    }

    /**
     * 符号优先级map
     */
    private static final Map<Character, Integer> operatePriorityMap;

    static {
        operatePriorityMap = new HashMap<>();
        operatePriorityMap.put('+', 1);
        operatePriorityMap.put('-', 1);
        operatePriorityMap.put('*', 2);
        operatePriorityMap.put('/', 2);
    }

    /**
     * 计算表达式的值
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int calculate(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> opsStack = new ArrayDeque<>();
        char[] chars = s.replaceAll(" ", "").toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(chars[i])) {
                int num = 0;
                while (i < len && Character.isDigit(chars[i])) {
                    num = num * 10 + (chars[i] - '0');
                    i++;
                }
                i--;
                numStack.push(num);
            } else {
                while (!opsStack.isEmpty() && operatePriorityMap.getOrDefault(opsStack.peek(), 0) >= operatePriorityMap.getOrDefault(chars[i], 0)) {
                    // 计算栈顶两个元素的结果
                    numStack.push(calculate(numStack.pop(), numStack.pop(), opsStack.pop()));
                }
                opsStack.push(chars[i]);
            }
        }
        // 计算栈中剩余的元素
        while (!opsStack.isEmpty()) {
            numStack.push(calculate(numStack.pop(), numStack.pop(), opsStack.pop()));
        }
        return numStack.pop();
    }

    private static int calculate(int a, int b, char op) {
        switch (op) {
            case '+':
                return b + a;
            case '-':
                return b - a;
            case '*':
                return b * a;
            case '/':
                return b / a;
            default:
                throw new IllegalArgumentException("非法操作符");
        }
    }
}
