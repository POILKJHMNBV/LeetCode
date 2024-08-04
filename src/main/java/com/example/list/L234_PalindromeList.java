package com.example.list;

/**
 * L234:回文链表
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false
 */
public class L234_PalindromeList {
    public static void main(String[] args) {

    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        ListNode fastPointer = head, slowPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;        // 快指针到达链表末尾
            slowPointer = slowPointer.next;             // 满指针到达链表中间
        }
        fastPointer = slowPointer.next;                 // 重置快指针位置
        ListNode preNode = null;
        // 开始反转链表后半部分
        while (fastPointer != null) {
            ListNode nextNode = fastPointer.next;       // 保存下一个结点
            fastPointer.next = preNode;
            preNode = fastPointer;
            fastPointer = nextNode;
        }

        // 开始判断是否回文
        fastPointer = preNode;
        boolean res = true;
        while (head != null && preNode != null) {
            if (head.val != preNode.val) {
                res = false;
                break;
            }
            head = head.next;
            preNode = preNode.next;
        }

        // 还原链表
        preNode = null;
        while (fastPointer != null) {
            ListNode nextNode = fastPointer.next;       // 保存下一个结点
            fastPointer.next = preNode;
            preNode = fastPointer;
            fastPointer = nextNode;
        }
        slowPointer.next = preNode;
        return res;
    }
}
