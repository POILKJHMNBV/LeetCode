package com.example.list;

/**
 * <p>L2074:反转偶数长度组的节点</p>
 * @author zhenwu
 * @date 2025/10/8 15:42
 */
public class L2074_ReverseEvenLengthGroups {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildSingleList(new int[]{5, 2, 6, 3, 9, 1, 7, 3, 8, 4});
        ListUtil.printList(reverseEvenLengthGroups(head));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode pre = head, tmpPre = head, cur = head.next;
        int cnt = 2;
        while (cur != null) {
            int count = 0;
            while (cur != null && count < cnt) {
                count++;
                cur = cur.next;
                tmpPre = tmpPre.next;
            }
            cnt++;
            if (count % 2 == 1) {
                pre = tmpPre;
                continue;
            }

            // 反转偶数长度的链表
            ListNode tmp = pre.next, next = tmp.next;
            while (next != cur) {
                tmp.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = tmp.next;
            }
            pre = tmp;
            tmpPre = tmp;
        }
        return head;
    }
}
