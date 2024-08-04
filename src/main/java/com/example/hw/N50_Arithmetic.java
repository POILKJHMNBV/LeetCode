package com.example.hw;

import java.util.*;

/**
 * @author zhenwu
 */
public class N50_Arithmetic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String express = in.nextLine();
        System.out.println(calculate(express.toCharArray()));
    }

    private static int calculate(char[] chars) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('-', 1);
        map.put('+', 1);
        map.put('*', 2);
        map.put('/', 2);
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> operateStack = new ArrayDeque<>();
        numStack.push(0);
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(' || ch == '[' || ch == '{') {
                operateStack.push(ch);
            } else if (ch == ')') {
                while (operateStack.peek() != '(') {
                    calculate(numStack, operateStack);
                }
                operateStack.poll();
            } else if (ch == ']') {
                while (operateStack.peek() != '[') {
                    calculate(numStack, operateStack);
                }
                operateStack.poll();
            } else if (ch == '}') {
                while (operateStack.peek() != '{') {
                    calculate(numStack, operateStack);
                }
                operateStack.poll();
            } else if (Character.isDigit(ch)) {
                int u = 0, j = i;
                while (j < chars.length && Character.isDigit(chars[j])) {
                    u = u * 10 + (chars[j++] - '0');
                }
                i = j - 1;
                numStack.push(u);
            } else {
                if (i > 0 && (chars[i - 1] == '(' || chars[i - 1] == '[' || chars[i - 1] == '{')) {
                    numStack.push(0);
                }
                while (!operateStack.isEmpty() && operateStack.peek() != '(' && operateStack.peek() != '[' && operateStack.peek() != '{') {
                    char pre = operateStack.peek();
                    if (map.get(pre) >= map.get(ch)) {
                        calculate(numStack, operateStack);
                    } else {
                        break;
                    }
                }
                operateStack.push(ch);
            }
        }
        while (!operateStack.isEmpty() && operateStack.peek() != '(' && operateStack.peek() != '[' && operateStack.peek() != '{') {
            calculate(numStack, operateStack);
        }
        return numStack.poll();
    }

    private static void calculate(Deque<Integer> numStack, Deque<Character> operateStack) {
        if (numStack.size() < 2 || operateStack.isEmpty()) {
            return;
        }
        int b = numStack.poll();
        int a = numStack.poll();
        char operate = operateStack.poll();
        if (operate == '+') {
            numStack.push(a + b);
        } else if (operate == '-') {
            numStack.push(a - b);
        } else if (operate == '*') {
            numStack.push(a * b);
        } else {
            numStack.push(a / b);
        }
    }
}
