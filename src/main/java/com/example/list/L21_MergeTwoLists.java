package com.example.list;

/**
 * <p>L21:合并两个有序链表</p>
 * <p>将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的</p>
 */
public class L21_MergeTwoLists {
    public static void main(String[] args) {

    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 != null ? list1 : list2;
        }

        // 设置哑节点
        ListNode dummyNode = new ListNode();
        ListNode cur = dummyNode;
        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 < val2) {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
                cur.next = null;
            } else if (val1 > val2) {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
                cur.next = null;
            } else {
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
                cur.next = null;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummyNode.next;
    }
}
