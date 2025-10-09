package com.example.list;

/**
 * <p>L1721:交换链表中的节点</p>
 * @author zhenwu
 * @date 2025/10/9 21:57
 */
public class L1721_SwapNodes {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildSingleList(new int[]{1, 2});
        int k = 2;
        ListUtil.printList(swapNodes(head, k));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static ListNode swapNodes(ListNode head, int k) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        int m = k;
        ListNode cur = dummyNode, slow = dummyNode, fast = dummyNode;
        while (k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            if (m == 0) {
                cur = slow;
            }
            slow = slow.next;
            fast = fast.next;
            m--;
        }
        if (m >= 0) {
            cur = slow;
        }
        while (m > 0) {
            cur = cur.next;
            m--;
        }
        int tmp = slow.val;
        slow.val = cur.val;
        cur.val = tmp;
        return dummyNode.next;
    }
}
