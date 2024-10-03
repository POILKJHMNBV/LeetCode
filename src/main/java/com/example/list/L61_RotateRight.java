package com.example.list;

/**
 * <p>L61:旋转链表</p>
 * @author zhenwu
 * @date 2024/10/2 21:46
 */
public class L61_RotateRight {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n)     空间：O(1)
     */
    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode cur = head;
        ListNode tail = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
            if (cur.next == null) {
                tail = cur;
            }
        }

        k = k % len;
        if (k == 0) {
            return head;
        }

        cur = head;
        for (int i = 1; i < len - k; i++) {
            cur = cur.next;
        }

        ListNode newHead = cur.next;
        cur.next = null;
        tail.next = head;
        return newHead;
    }
}
