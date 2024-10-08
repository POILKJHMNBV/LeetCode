package com.example.list;

/**
 * <p>L92:反转链表 II</p>
 * @author zhenwu
 * @date 2024/10/8 21:02
 */
public class L92_ReverseBetween {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n)   空间：O(1)
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1, head), cur = dummyNode;
        int step = 1;
        while (cur.next != null && (step++) != left) {
            cur = cur.next;
        }
        if (cur.next == null) {
            return head;
        }

        step = right - left;
        ListNode newHead = cur;
        cur = cur.next;
        ListNode next = cur.next;
        while (step-- != 0) {
            cur.next = next.next;
            next.next = newHead.next;
            newHead.next = next;
            next = cur.next;
        }
        return dummyNode.next;
    }
}
