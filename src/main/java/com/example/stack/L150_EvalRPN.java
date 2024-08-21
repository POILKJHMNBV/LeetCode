package com.example.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>L150:逆波兰表达式求值</p>
 *
 * @author zhenwu
 * @date 2024/8/21 20:42
 */
public class L150_EvalRPN {
    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (String token : tokens) {
            if (set.contains(token)) {
                int b = Integer.parseInt(stack.pop());
                int a = Integer.parseInt(stack.pop());
                if ("+".equals(token)) {
                    stack.push(a + b + "");
                } else if ("-".equals(token)) {
                    stack.push(a - b + "");
                } else if ("*".equals(token)) {
                    stack.push(a * b + "");
                } else {
                    stack.push(a / b + "");
                }
            } else {
                stack.push(token);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
