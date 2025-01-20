package com.example.list;

/**
 * <p>L876:链表的中间结点</p>
 * @author zhenwu
 * @date 2025/1/20 21:45
 */
public class L876_MiddleNode {
    public static void main(String[] args) {

    }

    /**
     * 快慢指针法
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
