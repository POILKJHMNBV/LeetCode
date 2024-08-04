package com.example.stack;

import java.util.ArrayDeque;

/**
 * <p>L20:有效的括号</p>
 * <p>给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。</p>
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * </p>
 */
public class L20_IsValid {
    public static void main(String[] args) {
        String s = "()))";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return false;
        }
        if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']') {
            return false;
        }
        ArrayDeque<Character> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            if (ch == ')' || ch == '}' || ch == ']') {
                if (!stack.isEmpty()) {
                    char character = stack.peek();
                    if (ch == ')') {
                        if (character == '(') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }

                    if (ch == '}') {
                        if (character == '{') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }

                    if (ch == ']') {
                        if (character == '[') {
                            stack.pop();
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
