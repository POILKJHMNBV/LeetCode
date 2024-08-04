package com.example.list;

/**
 * <p>L160:相交链表</p>
 * <p>给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * 图示两个链表在节点 c1 开始相交：</p>
 */
public class L160_IntersectionNode {
    public static void main(String[] args) {

    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            if (curA != null) {
                curA = curA.next;
            } else {
                curA = headB;
            }

            if (curB != null) {
                curB = curB.next;
            } else {
                curB = headA;
            }
        }
        return curA;
    }
}
