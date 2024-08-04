package com.example.list;

/**
 * <p>L19:删除链表的倒数第 N 个结点</p>
 * <p>给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点</p>
 */
public class L19_RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    /**
     * 双指针法
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode fastPointer = dummyNode, slowPointer = dummyNode;
        int step = 1;
        while (step != (n + 1) && fastPointer.next != null){
            fastPointer = fastPointer.next;
            step++;
        }
        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }
        slowPointer.next = slowPointer.next.next;
        return dummyNode.next;
    }
}
