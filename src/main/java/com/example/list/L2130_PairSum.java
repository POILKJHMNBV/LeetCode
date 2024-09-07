package com.example.list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>L2130:链表最大孪生和</p>
 * @author zhenwu
 * @date 2024/9/7 15:39
 */
public class L2130_PairSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(pairSum(ListUtil.buildSingleList(nums)));
    }

    private static int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        Deque<Integer> stack = new LinkedList<>();
        while (fast.next != null && fast.next.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        stack.push(slow.val);
        slow = slow.next;
        int maxPairSum = 0;
        while (slow != null && !stack.isEmpty()) {
            maxPairSum = Math.max(slow.val + stack.pop(), maxPairSum);
            slow = slow.next;
        }
        return maxPairSum;
    }
}
