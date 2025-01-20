package com.example.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <p>L1019:链表中的下一个更大节点</p>
 * @author zhenwu
 * @date 2025/1/20 21:37
 */
public class L1019_NextLargerNodes {
    public static void main(String[] args) {

    }

    /**
     * 单调栈解法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int[] nextLargerNodes(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            while (!stack.isEmpty() && num > nums.get(stack.peek())) {
                res[stack.pop()] = num;
            }
            stack.push(i);
        }
        return res;
    }
}
