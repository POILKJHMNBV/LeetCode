package com.example.list;

/**
 * <p>L2181:合并零之间的节点</p>
 * @author zhenwu
 * @date 2025/10/2 14:28
 */
public class L2181_MergeNodes {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildSingleList(new int[]{0, 3, 1, 0, 4, 5, 2, 0});
        ListUtil.printList(mergeNodes(head));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static ListNode mergeNodes(ListNode head) {
        ListNode cur = head.next;
        while (cur != null) {
            ListNode node = cur;
            int sum = 0;
            while (node != null && node.val != 0) {
                sum += node.val;
                node = node.next;
            }
            cur.val = sum;
            cur.next = node.next;
            cur = cur.next;
            node.next = null;
        }
        return head.next;
    }
}
