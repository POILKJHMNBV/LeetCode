package com.example.list;

/**
 * <p>L328:奇偶链表</p>
 * @author zhenwu
 * @date 2024/9/6 21:13
 */
public class L328_OddEvenList {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        ListNode head = oddEvenList(ListUtil.buildSingleList(nums));
        ListUtil.printList(head);
    }

    private static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode tail = head, cur = head.next, eventHead = cur;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            cur.next = next.next;
            tail.next = next;
            cur = cur.next;
            tail = tail.next;
        }
        tail.next = eventHead;
        return head;
    }
}