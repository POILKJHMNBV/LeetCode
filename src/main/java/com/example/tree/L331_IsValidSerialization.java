package com.example.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>L331:验证二叉树的前序序列化</p>
 * @author zhenwu
 * @date 2024/11/22 21:56
 */
public class L331_IsValidSerialization {
    public static void main(String[] args) {

    }

    /**
     * 验证二叉树的前序序列化
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int i = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i++;
            } else if (preorder.charAt(i) == '#'){
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                i++;
            } else {
                // 读一个数字
                while (i < n && preorder.charAt(i) != ',') {
                    i++;
                }
                int top = stack.pop() - 1;
                if (top > 0) {
                    stack.push(top);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }
}
