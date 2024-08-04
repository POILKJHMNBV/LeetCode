package com.example.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>L148:排序链表</p>
 */
public class L148_SortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(-1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode head = sortListPro(node1);
        System.out.println(123);
    }

    /**
     * 暴力法
     */
    private static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        list.sort(Comparator.comparingInt(o -> o));
        ListNode newHead = new ListNode(list.get(0));
        ListNode curNode= newHead;
        for (int i = 1; i < list.size(); i++) {
            curNode.next = new ListNode(list.get(i));
            curNode = curNode.next;
        }
        return newHead;
    }

    private static ListNode sortListPro(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode head1 = sortListPro(head);
        ListNode head2 = sortListPro(tmp);
        return merge(head1, head2);
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyNode = new ListNode();
        ListNode curNode = dummyNode;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                curNode.next = head1;
                head1 = head1.next;
            } else {
                curNode.next = head2;
                head2 = head2.next;
            }
            curNode = curNode.next;
        }

        if (head1 != null) {
            curNode.next = head1;
        }
        if (head2 != null) {
            curNode.next = head2;
        }
        return dummyNode.next;
    }
}
