package com.example.list;

/**
 * <p>L2095:删除链表的中间节点</p>
 * @author zhenwu
 * @date 2024/9/5 21:19
 */
public class L2095_DeleteMiddle {
    public static void main(String[] args) {

    }

    private static ListNode deleteMiddle(ListNode head) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode pre = dummyNode;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            pre.next = pre.next.next;
        } else {
            slow.next = slow.next.next;
        }
        return dummyNode.next;
    }
}
