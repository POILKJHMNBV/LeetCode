package com.example.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>L147:对链表进行插入排序</p>
 * @author zhenwu
 * @date 2024/10/20 20:48
 */
public class L147_InsertionSortList {
    public static void main(String[] args) {
        int[] nums = {5, 2, 1, 4, 6};
        ListNode head = ListUtil.buildSingleList(nums);
        ListNode res = insertionSortListPro(head);
        ListUtil.printList(res);
    }

    /**
     * 插入排序
     * 时间复杂度：O(n * n)
     * 空间复杂度：O(1)
     */
    private static ListNode insertionSortListPro(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        // curNode: 当前节点 lastNode: 链表尾节点 recentNode: 最近节点
        ListNode curNode = head.next, lastNode = head, recentNode = null;
        dummyNode.next = head;
        while (curNode != null) {
            // 如果当前节点大于等于最后一个节点，则直接跳过
            if (curNode.val >= lastNode.val) {
                lastNode = lastNode.next;
                curNode = curNode.next;
                continue;
            }

            // 当前节点小于等于最近节点，从头节点开始遍历，找到第一个大于等于当前节点的节点
            if (recentNode == null || curNode.val <= recentNode.next.val) {
                recentNode = dummyNode;
            }
            while (recentNode.next != null && recentNode.next.val <= curNode.val) {
                recentNode = recentNode.next;
            }
            lastNode.next = curNode.next;
            curNode.next = recentNode.next;
            recentNode.next = curNode;
            curNode = lastNode.next;
        }
        return dummyNode.next;
    }

    /**
     * 插入排序
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static ListNode insertionSortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);
        ListNode dummyNode = new ListNode(-1);
        ListNode cur = dummyNode;
        for (int num : list) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummyNode.next;
    }
}
