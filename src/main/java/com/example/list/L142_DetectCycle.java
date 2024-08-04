package com.example.list;

/**
 * <p>L141:环形链表II</p>
 * <p>
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 * </p>
 */
public class L142_DetectCycle {
    public static void main(String[] args) {

    }

    private static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        if (head.next == head) {
            return head;
        }
        ListNode fastPointer = head, slowPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer == slowPointer) {
                break;
            }
        }
        if (fastPointer.next == null || fastPointer.next.next == null){
            return null;
        }
        if (slowPointer == head) {
            return head;
        }
        while (head != null) {
            slowPointer = slowPointer.next;
            head = head.next;
            if (slowPointer == head) {
                return head;
            }
        }
        return null;
    }
}
