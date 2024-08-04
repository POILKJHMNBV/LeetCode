package com.example.list;

/**
 * <p>L206:反转链表</p>
 * <p>给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。</p>
 */
public class L206_ReverseList {
    public static void main(String[] args) {

    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    private static ListNode reverseListPro(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode nextNode = head.next;
        while (nextNode != null) {
            head.next = nextNode.next;
            nextNode.next = dummyNode.next;
            dummyNode.next = nextNode;
            nextNode = head.next;
        }
        return dummyNode.next;
    }
}