package com.example.list;

/**
 * <p>L24:两两交换链表中的节点</p>
 * <p>给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）</p>
 */
public class L24_SwapPairs {
    public static void main(String[] args) {

    }

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next, curHead = head.next;
        ListNode prevNode = head;
        prevNode.next = nextNode.next;
        nextNode.next = head;
        nextNode = prevNode;
        while (nextNode.next != null && nextNode.next.next != null) {
            nextNode = nextNode.next.next;
            ListNode curNode = prevNode.next;
            curNode.next = nextNode.next;
            nextNode.next = curNode;
            prevNode.next = nextNode;
            prevNode = curNode;
            nextNode = curNode;
        }
        return curHead;
    }
}
