package com.example.list;

/**
 * <p>L25:K 个一组翻转链表</p>
 * <p>
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * </p>
 */
public class L25_ReverseKGroup {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, null);
        ListNode node1 = new ListNode(2, null);
        ListNode node2 = new ListNode(3, null);
        ListNode node3 = new ListNode(4, null);
        ListNode node4 = new ListNode(5, null);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        int k = 2;
        ListNode newHead = reverseKGroup(head, k);
        System.out.println(123);
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummyNode = new ListNode(-1, head);
        int right = 0;
        ListNode preNode = dummyNode, curNode = head, nextNode;
        while (curNode != null && (right = getRight(curNode, right + 1, k)) % k == 0) {
            nextNode = curNode.next;
            int step = 1;
            while (step != k) {
                curNode.next = nextNode.next;
                nextNode.next = preNode.next;
                preNode.next = nextNode;
                nextNode = curNode.next;
                step++;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        return dummyNode.next;
    }

    private static int getRight(ListNode curNode, int left, int k) {
        while (curNode.next != null && left % k != 0) {
            curNode = curNode.next;
            left++;
        }
        return left;
    }
}