package com.example.list;

/**
 * <p>L83:删除排序链表中的重复元素</p>
 * @author zhenwu
 * @date 2024/10/5 21:45
 */
public class L83_DeleteDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 4, 5, 5};
        ListNode head = ListUtil.buildSingleList(nums);
        ListUtil.printList(deleteDuplicates(head));
    }

    /**
     * 时间：O(n)  空间：O(1)
     */
    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            while (fast != null && slow.val == fast.val) {
                fast = fast.next;
            }
            slow.next = fast;
            slow = slow.next;
        }
        return head;
    }
}
