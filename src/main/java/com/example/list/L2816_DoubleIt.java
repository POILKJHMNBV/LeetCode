package com.example.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L2816:翻倍以链表形式表示的数字</p>
 * @author zhenwu
 * @date 2025/10/12 14:35
 */
public class L2816_DoubleIt {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static ListNode doubleIt(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int carry = 0;
        ListNode newHead = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            int val = list.get(i) * 2 + carry;
            ListNode cur = new ListNode(val % 10);
            carry = val / 10;
            cur.next = newHead;
            newHead = cur;
        }
        if (carry != 0) {
            ListNode cur = new ListNode(carry);
            cur.next = newHead;
            newHead = cur;
        }
        return newHead;
    }
}
