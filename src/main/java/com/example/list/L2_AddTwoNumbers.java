package com.example.list;

/**
 * <p>L2:两数相加</p>
 * <p>给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。</p>
 */
public class L2_AddTwoNumbers {
    public static void main(String[] args) {

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode tail = dummyNode;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            carry = getCarry(sum);
            tail.next = new ListNode(sum % 10, null);
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = getCarry(sum);
            tail.next = new ListNode(sum % 10, null);
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = getCarry(sum);
            tail.next = new ListNode(sum % 10, null);
            tail = tail.next;
            l2 = l2.next;
        }
        if (carry == 1) {
            tail.next = new ListNode(carry, null);
        }
        return dummyNode.next;
    }

    private static int getCarry(int num) {
        if (num < 10) {
            return 0;
        } else {
            return 1;
        }
    }
}
