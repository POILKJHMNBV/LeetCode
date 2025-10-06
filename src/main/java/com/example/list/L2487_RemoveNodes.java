package com.example.list;

/**
 * <p>L2487:从链表中移除节点</p>
 * @author zhenwu
 * @date 2025/10/6 14:24
 */
public class L2487_RemoveNodes {
    public static void main(String[] args) {
        ListNode listNode = ListUtil.buildSingleList(new int[]{5, 2, 13, 3, 8});
        ListUtil.printList(removeNodes(listNode));
    }

    /**
     * 思路：先反转链表，然后从后往前遍历，如果当前节点的值大于后一个节点的值，则删除后一个节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static ListNode removeNodes(ListNode head) {
        ListNode newHead = ListUtil.reverseList(head);
        ListNode cur = newHead;
        while (cur.next != null) {
            if (cur.val > cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return ListUtil.reverseList(newHead);
    }
}
