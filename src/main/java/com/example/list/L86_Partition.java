package com.example.list;

/**
 * <p>L86:分隔链表</p>
 * @author zhenwu
 * @date 2024/10/5 22:00
 */
public class L86_Partition {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5, 2};
        ListNode head = ListUtil.buildSingleList(nums);
        int x = 3;
        ListUtil.printList(partition(head, x));
    }

    /**
     * 时间：O(n)  空间：O(1)
     */
    private static ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode cur1 = head1, cur2 = head2;
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
            }
            head = head.next;
        }
        cur2.next = null;
        cur1.next = head2.next;
        return head1.next;
    }
}
