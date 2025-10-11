package com.example.list;

/**
 * <p>L445:两数相加 II</p>
 * @author zhenwu
 * @date 2025/10/11 21:39
 */
public class L445_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = ListUtil.buildSingleList(new int[]{7, 2, 4, 3});
        ListNode l2 = ListUtil.buildSingleList(new int[]{5, 6, 4});
        ListNode res = addTwoNumbers(l1, l2);
        ListUtil.printList(res);
    }

    /**
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(1)
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newL1 = ListUtil.reverseList(l1);
        ListNode newL2 = ListUtil.reverseList(l2);

        int curVal, carry = 0;
        ListNode head = null, cur = null;
        while (newL1 != null || newL2 != null) {
            if (newL1 != null && newL2 != null) {
                curVal = (newL1.val + newL2.val + carry) % 10;
                carry = (newL1.val + newL2.val + carry) / 10;
                newL1 = newL1.next;
                newL2 = newL2.next;
            } else if (newL1 != null) {
                curVal = (newL1.val + carry) % 10;
                carry = (newL1.val + carry) / 10;
                newL1 = newL1.next;
            } else {
                curVal = (newL2.val + carry) % 10;
                carry = (newL2.val + carry) / 10;
                newL2 = newL2.next;
            }
            if (head == null) {
                head = new ListNode(curVal);
                cur = head;
            } else {
                cur.next = new ListNode(curVal);
                cur = cur.next;
            }
        }
        if (carry != 0) {
            cur.next = new ListNode(carry);
        }
        return ListUtil.reverseList(head);
    }

}
