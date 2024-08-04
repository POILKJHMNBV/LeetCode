package com.example.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>
 *     L224:简单计算器
 * </p>
 */
public class L224_SimpleCalculator {
    public static void main(String[] args) {

    }

    private static int calculate(String s) {
        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> opsStack = new LinkedList<>();
        String str = s.replaceAll(" ", "");

        // 为了防止第一个数为负数，先往 nums 加个 0
        numStack.push(0);

        int length = str.length();
        char[] charArray = str.toCharArray();

        for (int i = 0; i < length; i++) {
            char ch = charArray[i];
            if (ch == '(') {
                opsStack.push(ch);
            } else if (ch == ')') {
                // 将操作数栈不断出栈，直到遇到第一个 ( 为止
                while (!opsStack.isEmpty()) {
                    char ops = opsStack.peek();
                    if (ops != '(') {
                        calculate(numStack, opsStack);
                    } else {
                        opsStack.pop();
                        break;
                    }
                }
            } else {
                if (Character.isDigit(ch)) {
                    int num = 0;
                    int j = i;
                    // 将从 i 位置开始后面的连续数字整体取出，加入 nums
                    while (j < length && Character.isDigit(charArray[j])) {
                        num = 10 * num + (charArray[j++] - '0');
                    }
                    numStack.push(num);
                    i = j - 1;
                } else {
                    if (i > 0 && charArray[i - 1] == '(') {
                        numStack.push(0);
                    }
                    while (!opsStack.isEmpty() && opsStack.peek() != '(') {
                        calculate(numStack, opsStack);
                    }
                    opsStack.push(ch);
                }
            }
        }
        while (!opsStack.isEmpty() && opsStack.peek() != '(') {
            calculate(numStack, opsStack);
        }
        return numStack.pop();
    }

    private static void calculate(Deque<Integer> numStack, Deque<Character> opsStack) {
        if (numStack.size() < 2 || opsStack.isEmpty()) {
            return;
        }
        int b = numStack.pop();
        int a = numStack.pop();
        char ops = opsStack.pop();
        numStack.push(ops == '+' ? a + b : a - b);
    }
}
