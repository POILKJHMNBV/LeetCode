package com.example.list;

/**
 * <p>L141:环形链表</p>
 * <p>
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * </p>
 */
public class L141_HasCycle {
    public static void main(String[] args) {

    }


    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next == head) {
            return true;
        }
        ListNode fastPointer = head, slowPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            // 快慢指针相遇
            if (fastPointer == slowPointer) {
                return true;
            }
        }
        return false;
    }
}
