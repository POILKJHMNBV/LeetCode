package com.example.list;

/**
 * <p>L82:删除排序链表中的重复元素 II</p>
 * @author zhenwu
 * @date 2024/10/5 21:19
 */
public class L82_DeleteDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
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
        ListNode dummyNode = new ListNode(-1, head);
        ListNode slow = dummyNode, fast = dummyNode.next;
        while (fast != null) {
            int target = slow.next.val, count = 0;
            while (fast != null && fast.val == target) {
                fast = fast.next;
                count++;
            }
            if (count > 1) {
                slow.next = fast;
            } else {
                slow = slow.next;
            }
        }
        return dummyNode.next;
    }
}
