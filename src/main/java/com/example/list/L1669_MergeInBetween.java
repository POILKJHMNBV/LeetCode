package com.example.list;

/**
 * <p>L1669:合并两个链表</p>
 * @author zhenwu
 * @date 2025/10/5 9:44
 */
public class L1669_MergeInBetween {
    public static void main(String[] args) {
        ListNode list1 = ListUtil.buildSingleList(new int[]{10, 1, 13, 6, 9, 5});
        int a = 3, b = 4;
        ListNode list2 = ListUtil.buildSingleList(new int[]{1000000, 1000001, 1000002});
        ListUtil.printList(mergeInBetween(list1, a, b, list2));
    }

    /**
     * 时间复杂度：O(b + m)
     * 空间复杂度：O(1)
     */
    private static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = list1;
        ListNode cur = dummyNode, pre1 = null, pre2;
        for (int i = 0; i <= b; i++) {
            cur = cur.next;
            if (i == a - 1) {
                pre1 = cur;
            }
        }
        pre2 = cur;
        cur = list2;
        while (cur.next != null) {
            cur = cur.next;
        }
        pre1.next = list2;
        cur.next = pre2.next;
        pre2.next = null;
        return dummyNode.next;
    }
}
