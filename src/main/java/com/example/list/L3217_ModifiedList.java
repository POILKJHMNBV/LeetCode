package com.example.list;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L3217:从链表中移除在数组中存在的节点</p>
 * @author zhenwu
 * @date 2025/10/4 14:26
 */
public class L3217_ModifiedList {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ListNode head = ListUtil.buildSingleList(new int[]{1, 2, 3, 4, 5});
        ListNode ans = modifiedList(nums, head);
        ListUtil.printList(ans);
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode, cur = head;
        while (cur != null) {
           while (cur != null && set.contains(cur.val)) {
               cur = cur.next;
           }
           pre.next = cur;
           pre = cur;
           cur = cur != null ? cur.next : null;
        }
        return dummyNode.next;
    }
}
