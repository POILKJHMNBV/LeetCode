package com.example.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L143:重排链表</p>
 * @author zhenwu
 * @date 2024/10/20 20:13
 */
public class L143_ReorderList {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListUtil.buildSingleList(nums);
        reorderListPro(head);
        ListUtil.printList(head);
    }

    /**
     * 重排链表
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param head 头节点
     */
    private static void reorderListPro(ListNode head) {
        ListNode fast = head, slow = head;
        // 快慢指针，快指针每次走两步，慢指针每次走一步，当快指针走到末尾时，慢指针正好走到中间
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 反转后半部分链表
        ListNode newHead = reverseList(slow.next);

        // 断开链表前半部分和后半部分的联系
        slow.next = null;

        // 合并链表
        mergeList(head, newHead);
    }

    private static void mergeList(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            ListNode next2 = head2.next;
            head2.next = head1.next;
            head1.next = head2;
            head1 = head1.next.next;
            head2 = next2;
        }
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     * 重排链表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param head 头节点
     */
    private static void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode cur = head.next;
        // 遍历链表，将每个节点添加到列表中
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        int size = list.size(), n = size / 2, i = 0;
        cur = head;
        head.next = null;
        for (; i < n; i++) {
            ListNode node1 = list.get(size - 1 - i);
            node1.next = list.get(i);
            cur.next = node1;
            cur = cur.next.next;
            cur.next = null;
        }
        if (size % 2 == 1) {
            cur.next = list.get(n);
            cur = cur.next;
            cur.next = null;
        }
    }
}
