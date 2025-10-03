package com.example.list;

/**
 * <p>L725:分隔链表</p>
 * @author zhenwu
 * @date 2025/10/3 13:56
 */
public class L725_SplitListToParts {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildSingleList(new int[]{1, 2, 3});
        int k = 5;
        ListNode[] ans = splitListToParts(head, k);
        for (ListNode node : ans) {
            ListUtil.printList(node);
        }
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode cur = head;
        // 获取链表长度
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        ListNode[] ans = new ListNode[k];

        // 计算平均每一段的平均长度
        int per = len / k;
        for (int i = 0, cnt = 1; i < k; i++, cnt++) {
            // cnt表示已经统计的节点个数
            ans[i] = head;
            cur = ans[i];
            int u = per;

            // 先分配per个节点
            while (u > 1 && cur != null) {
                // 前面已经分配了 1 个 head 节点，这里只需要分配 per - 1 个节点
                cur = cur.next;
                u--;
                cnt++;
            }

            int x = k - i - 1;
            if (per != 0 && cnt + x * per < len && cur != null) {
                // 已经处理的链表长度 + 剩余的链表长度 < 总长度，则为当前ans[i]多分配一个节点
                cur = cur.next;
                cnt++;
            }

            // 断开链表
            head = cur != null ? cur.next : null;
            if (cur != null) {
                cur.next = null;
            }
        }
        return ans;
    }
}
