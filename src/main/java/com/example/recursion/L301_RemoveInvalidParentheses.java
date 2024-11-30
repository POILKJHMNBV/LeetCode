package com.example.recursion;

import java.util.*;

/**
 * <p>L301:删除无效的括号</p>
 * <p>
 *     给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 *     返回所有可能的结果。答案可以按 任意顺序 返回。
 * </p>
 * @author zhenwu
 * @date 2024/11/30 21:04
 */
public class L301_RemoveInvalidParentheses {
    public static void main(String[] args) {

    }

    /**
     * 删除最小数量的无效括号
     * bfs
     */
    private static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        queue.offer(s);
        visited.add(s);
        // 本层是否找到有效字符串
        boolean found = false;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isValid(cur)) {
                res.add(cur);
                found = true;
            }
            if (found) {
                // 如果本层已经找到有效字符串，则无需向队列添加元素，即无需向下搜索，但是本层仍然需要遍历，后面可能会有满足条件的字符串
                continue;
            }
            for (int i = 0; i < cur.length(); i++) {
                char c = cur.charAt(i);
                if (c != '(' && c != ')') {
                    continue;
                }
                String next = cur.substring(0, i) + cur.substring(i + 1);
                if (!visited.contains(next)) {
                    queue.offer(next);
                    visited.add(next);
                }
            }
        }
        return res;
    }

    /**
     * 判断字符串是否有效
     */
    private static boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            }
            if (c == ')' && count-- == 0) {
                return false;
            }
        }
        return count == 0;
    }
}